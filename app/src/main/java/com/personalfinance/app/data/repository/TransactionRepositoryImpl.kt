package com.personalfinance.app.data.repository

import com.personalfinance.app.data.local.dao.TransactionDao
import com.personalfinance.app.data.local.entity.TransactionEntity
import com.personalfinance.app.domain.model.Transaction
import com.personalfinance.app.domain.model.TransactionFilter
import com.personalfinance.app.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.LocalDateTime
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDao
) : TransactionRepository {
    
    override suspend fun addTransaction(transaction: Transaction): Result<Long> {
        return try {
            val entity = transaction.toEntity()
            val id = transactionDao.insertTransaction(entity)
            Result.success(id)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getTransactions(filter: TransactionFilter): Flow<List<Transaction>> {
        return when {
            // If no filters applied, get all transactions for user
            filter.isEmpty() -> {
                // For now, using empty userId - this will be updated when auth is integrated
                transactionDao.getAllTransactions("").map { entities ->
                    entities.map { it.toDomain() }
                }
            }
            // Apply date range filter
            filter.startDate != null && filter.endDate != null -> {
                transactionDao.getTransactionsByDateRange("", filter.startDate, filter.endDate)
                    .map { entities -> entities.map { it.toDomain() } }
            }
            // Apply category filter
            filter.categoryIds.isNotEmpty() -> {
                // For multiple categories, we'll get the first one for now
                // This can be enhanced to support multiple categories
                transactionDao.getTransactionsByCategory("", filter.categoryIds.first())
                    .map { entities -> entities.map { it.toDomain() } }
            }
            // Apply amount range filter
            filter.minAmount != null && filter.maxAmount != null -> {
                transactionDao.getTransactionsByAmountRange("", filter.minAmount, filter.maxAmount)
                    .map { entities -> entities.map { it.toDomain() } }
            }
            // Apply payment method filter
            filter.paymentMethods.isNotEmpty() -> {
                transactionDao.getTransactionsByPaymentMethod("", filter.paymentMethods.first())
                    .map { entities -> entities.map { it.toDomain() } }
            }
            // Apply search query filter
            filter.searchQuery != null -> {
                transactionDao.searchTransactions("", filter.searchQuery)
                    .map { entities -> entities.map { it.toDomain() } }
            }
            else -> {
                transactionDao.getAllTransactions("").map { entities ->
                    entities.map { it.toDomain() }
                }
            }
        }
    }
    
    override suspend fun getTransactionById(id: Long): Transaction? {
        return try {
            transactionDao.getTransactionById(id)?.toDomain()
        } catch (e: Exception) {
            null
        }
    }
    
    override suspend fun updateTransaction(transaction: Transaction): Result<Unit> {
        return try {
            val entity = transaction.toEntity()
            transactionDao.updateTransaction(entity)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun deleteTransaction(id: Long): Result<Unit> {
        return try {
            transactionDao.deleteTransactionById(id)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun syncTransactions(): Result<Unit> {
        return try {
            // TODO: Implement cloud sync with Firestore
            // For now, return success as local operations are working
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getTransactionsByDateRange(
        startDate: LocalDateTime,
        endDate: LocalDateTime
    ): Flow<List<Transaction>> {
        return transactionDao.getTransactionsByDateRange("", startDate, endDate)
            .map { entities -> entities.map { it.toDomain() } }
    }
    
    override suspend fun getTransactionsByCategory(categoryId: String): Flow<List<Transaction>> {
        return transactionDao.getTransactionsByCategory("", categoryId)
            .map { entities -> entities.map { it.toDomain() } }
    }
    
    // Extension functions for mapping between domain and entity models
    private fun Transaction.toEntity(): TransactionEntity {
        return TransactionEntity(
            id = this.id,
            amount = this.amount,
            categoryId = this.categoryId,
            date = this.date,
            description = this.description,
            paymentMethod = this.paymentMethod,
            tags = this.tags,
            isRecurring = this.isRecurring,
            recurringPattern = this.recurringPattern,
            syncStatus = this.syncStatus,
            userId = this.userId,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt
        )
    }
    
    private fun TransactionEntity.toDomain(): Transaction {
        return Transaction(
            id = this.id,
            amount = this.amount,
            categoryId = this.categoryId,
            date = this.date,
            description = this.description,
            paymentMethod = this.paymentMethod,
            tags = this.tags,
            isRecurring = this.isRecurring,
            recurringPattern = this.recurringPattern,
            syncStatus = this.syncStatus,
            userId = this.userId,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt
        )
    }
    
    // Helper function to check if filter is empty
    private fun TransactionFilter.isEmpty(): Boolean {
        return startDate == null && 
               endDate == null && 
               categoryIds.isEmpty() && 
               minAmount == null && 
               maxAmount == null && 
               paymentMethods.isEmpty() && 
               searchQuery == null && 
               tags.isEmpty() && 
               isRecurring == null
    }
}