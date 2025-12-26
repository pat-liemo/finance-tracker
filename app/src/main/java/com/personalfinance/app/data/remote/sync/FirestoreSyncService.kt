package com.personalfinance.app.data.remote.sync

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.personalfinance.app.data.local.dao.TransactionDao
import com.personalfinance.app.data.local.dao.BudgetDao
import com.personalfinance.app.data.local.dao.CategoryDao
import com.personalfinance.app.data.local.entity.TransactionEntity
import com.personalfinance.app.data.local.entity.BudgetEntity
import com.personalfinance.app.data.local.entity.CategoryEntity
import com.personalfinance.app.domain.model.SyncStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirestoreSyncService @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val transactionDao: TransactionDao,
    private val budgetDao: BudgetDao,
    private val categoryDao: CategoryDao
) {
    
    private var transactionListener: ListenerRegistration? = null
    private var budgetListener: ListenerRegistration? = null
    private var categoryListener: ListenerRegistration? = null
    
    suspend fun syncUserData(userId: String): Result<Unit> {
        return try {
            // Sync transactions
            syncTransactions(userId)
            
            // Sync budgets
            syncBudgets(userId)
            
            // Sync categories
            syncCategories(userId)
            
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    private suspend fun syncTransactions(userId: String) {
        // Upload pending local transactions to Firestore
        val pendingTransactions = transactionDao.getPendingTransactions(userId)
        
        pendingTransactions.forEach { transaction ->
            try {
                val documentRef = firestore
                    .collection("users")
                    .document(userId)
                    .collection("transactions")
                    .document(transaction.id.toString())
                
                documentRef.set(transaction.toFirestoreMap()).await()
                
                // Update sync status to SYNCED
                transactionDao.updateTransaction(
                    transaction.copy(syncStatus = SyncStatus.SYNCED)
                )
            } catch (e: Exception) {
                // Update sync status to FAILED
                transactionDao.updateTransaction(
                    transaction.copy(syncStatus = SyncStatus.FAILED)
                )
            }
        }
        
        // Download remote transactions and update local database
        val remoteTransactions = firestore
            .collection("users")
            .document(userId)
            .collection("transactions")
            .get()
            .await()
        
        remoteTransactions.documents.forEach { document ->
            val remoteTransaction = document.toTransactionEntity()
            val localTransaction = transactionDao.getTransactionById(remoteTransaction.id)
            
            if (localTransaction == null) {
                // New remote transaction, insert locally
                transactionDao.insertTransaction(remoteTransaction)
            } else if (remoteTransaction.updatedAt > localTransaction.updatedAt) {
                // Remote transaction is newer, update local
                transactionDao.updateTransaction(remoteTransaction)
            } else if (localTransaction.updatedAt > remoteTransaction.updatedAt && 
                       localTransaction.syncStatus == SyncStatus.PENDING) {
                // Local transaction is newer, upload to remote
                document.reference.set(localTransaction.toFirestoreMap()).await()
                transactionDao.updateTransaction(
                    localTransaction.copy(syncStatus = SyncStatus.SYNCED)
                )
            }
        }
    }
    
    private suspend fun syncBudgets(userId: String) {
        // Upload pending local budgets to Firestore
        val localBudgets = budgetDao.getAllBudgets(userId)
        
        localBudgets.collect { budgets ->
            budgets.forEach { budget ->
                try {
                    val documentRef = firestore
                        .collection("users")
                        .document(userId)
                        .collection("budgets")
                        .document(budget.id.toString())
                    
                    documentRef.set(budget.toFirestoreMap()).await()
                } catch (e: Exception) {
                    // Handle error
                }
            }
        }
        
        // Download remote budgets
        val remoteBudgets = firestore
            .collection("users")
            .document(userId)
            .collection("budgets")
            .get()
            .await()
        
        remoteBudgets.documents.forEach { document ->
            val remoteBudget = document.toBudgetEntity()
            val localBudget = budgetDao.getBudgetById(remoteBudget.id)
            
            if (localBudget == null) {
                budgetDao.insertBudget(remoteBudget)
            } else if (remoteBudget.updatedAt > localBudget.updatedAt) {
                budgetDao.updateBudget(remoteBudget)
            }
        }
    }
    
    private suspend fun syncCategories(userId: String) {
        // Upload local categories to Firestore
        val localCategories = categoryDao.getAllCategories(userId)
        
        localCategories.collect { categories ->
            categories.forEach { category ->
                try {
                    val documentRef = firestore
                        .collection("users")
                        .document(userId)
                        .collection("categories")
                        .document(category.id)
                    
                    documentRef.set(category.toFirestoreMap()).await()
                } catch (e: Exception) {
                    // Handle error
                }
            }
        }
        
        // Download remote categories
        val remoteCategories = firestore
            .collection("users")
            .document(userId)
            .collection("categories")
            .get()
            .await()
        
        remoteCategories.documents.forEach { document ->
            val remoteCategory = document.toCategoryEntity()
            val localCategory = categoryDao.getCategoryById(remoteCategory.id)
            
            if (localCategory == null) {
                categoryDao.insertCategory(remoteCategory)
            } else if (remoteCategory.updatedAt > localCategory.updatedAt) {
                categoryDao.updateCategory(remoteCategory)
            }
        }
    }
    
    fun startRealtimeSync(userId: String) {
        // Listen for real-time changes in transactions
        transactionListener = firestore
            .collection("users")
            .document(userId)
            .collection("transactions")
            .addSnapshotListener { snapshot, error ->
                if (error != null) return@addSnapshotListener
                
                snapshot?.documentChanges?.forEach { change ->
                    when (change.type) {
                        com.google.firebase.firestore.DocumentChange.Type.ADDED,
                        com.google.firebase.firestore.DocumentChange.Type.MODIFIED -> {
                            val transaction = change.document.toTransactionEntity()
                            // Update local database in background
                            CoroutineScope(Dispatchers.IO).launch {
                                transactionDao.insertTransaction(transaction)
                            }
                        }
                        com.google.firebase.firestore.DocumentChange.Type.REMOVED -> {
                            val transactionId = change.document.id.toLongOrNull()
                            if (transactionId != null) {
                                CoroutineScope(Dispatchers.IO).launch {
                                    transactionDao.deleteTransactionById(transactionId)
                                }
                            }
                        }
                    }
                }
            }
        
        // Similar listeners for budgets and categories...
    }
    
    fun stopRealtimeSync() {
        transactionListener?.remove()
        budgetListener?.remove()
        categoryListener?.remove()
    }
    
    // Extension functions for Firestore mapping
    private fun TransactionEntity.toFirestoreMap(): Map<String, Any> {
        return mapOf(
            "id" to id,
            "amount" to amount,
            "categoryId" to categoryId,
            "date" to date.toString(),
            "description" to description,
            "paymentMethod" to paymentMethod.name,
            "tags" to tags,
            "isRecurring" to isRecurring,
            "recurringPattern" to (recurringPattern?.let { 
                mapOf(
                    "frequency" to it.frequency.name,
                    "interval" to it.interval,
                    "endDate" to it.endDate?.toString(),
                    "maxOccurrences" to it.maxOccurrences
                )
            } ?: emptyMap<String, Any>()),
            "syncStatus" to syncStatus.name,
            "userId" to userId,
            "createdAt" to createdAt,
            "updatedAt" to updatedAt
        )
    }
    
    private fun com.google.firebase.firestore.DocumentSnapshot.toTransactionEntity(): TransactionEntity {
        return TransactionEntity(
            id = getLong("id") ?: 0L,
            amount = getDouble("amount") ?: 0.0,
            categoryId = getString("categoryId") ?: "",
            date = getString("date")?.let { kotlinx.datetime.LocalDateTime.parse(it) } 
                ?: Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
            description = getString("description") ?: "",
            paymentMethod = getString("paymentMethod")?.let { 
                com.personalfinance.app.domain.model.PaymentMethod.valueOf(it) 
            } ?: com.personalfinance.app.domain.model.PaymentMethod.CASH,
            tags = get("tags") as? List<String> ?: emptyList(),
            isRecurring = getBoolean("isRecurring") ?: false,
            recurringPattern = null, // Would need more complex parsing
            syncStatus = getString("syncStatus")?.let { SyncStatus.valueOf(it) } ?: SyncStatus.SYNCED,
            userId = getString("userId") ?: "",
            createdAt = getLong("createdAt") ?: System.currentTimeMillis(),
            updatedAt = getLong("updatedAt") ?: System.currentTimeMillis()
        )
    }
    
    private fun BudgetEntity.toFirestoreMap(): Map<String, Any> {
        return mapOf(
            "id" to id,
            "categoryId" to categoryId,
            "amount" to amount,
            "period" to period.name,
            "startDate" to startDate.toString(),
            "alertThreshold" to alertThreshold,
            "isActive" to isActive,
            "userId" to userId,
            "createdAt" to createdAt,
            "updatedAt" to updatedAt
        )
    }
    
    private fun com.google.firebase.firestore.DocumentSnapshot.toBudgetEntity(): BudgetEntity {
        return BudgetEntity(
            id = getLong("id") ?: 0L,
            categoryId = getString("categoryId") ?: "",
            amount = getDouble("amount") ?: 0.0,
            period = getString("period")?.let { 
                com.personalfinance.app.domain.model.BudgetPeriod.valueOf(it) 
            } ?: com.personalfinance.app.domain.model.BudgetPeriod.MONTHLY,
            startDate = getString("startDate")?.let { kotlinx.datetime.LocalDate.parse(it) } 
                ?: Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date,
            alertThreshold = getDouble("alertThreshold") ?: 0.8,
            isActive = getBoolean("isActive") ?: true,
            userId = getString("userId") ?: "",
            createdAt = getLong("createdAt") ?: System.currentTimeMillis(),
            updatedAt = getLong("updatedAt") ?: System.currentTimeMillis()
        )
    }
    
    private fun CategoryEntity.toFirestoreMap(): Map<String, Any> {
        return mapOf(
            "id" to id,
            "name" to name,
            "icon" to icon,
            "color" to color,
            "isDefault" to isDefault,
            "parentCategoryId" to (parentCategoryId ?: ""),
            "userId" to userId,
            "createdAt" to createdAt,
            "updatedAt" to updatedAt
        )
    }
    
    private fun com.google.firebase.firestore.DocumentSnapshot.toCategoryEntity(): CategoryEntity {
        return CategoryEntity(
            id = getString("id") ?: "",
            name = getString("name") ?: "",
            icon = getString("icon") ?: "📝",
            color = getString("color") ?: "#636E72",
            isDefault = getBoolean("isDefault") ?: false,
            parentCategoryId = getString("parentCategoryId")?.takeIf { it.isNotEmpty() },
            userId = getString("userId") ?: "",
            createdAt = getLong("createdAt") ?: System.currentTimeMillis(),
            updatedAt = getLong("updatedAt") ?: System.currentTimeMillis()
        )
    }
}