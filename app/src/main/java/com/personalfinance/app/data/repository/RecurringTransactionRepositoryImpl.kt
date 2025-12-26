package com.personalfinance.app.data.repository

import com.personalfinance.app.data.local.dao.TransactionDao
import com.personalfinance.app.data.local.entity.TransactionEntity
import com.personalfinance.app.domain.model.RecurringFrequency
import com.personalfinance.app.domain.model.Transaction
import com.personalfinance.app.domain.repository.RecurringTransactionRepository
import com.personalfinance.app.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject

class RecurringTransactionRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDao,
    private val transactionRepository: TransactionRepository
) : RecurringTransactionRepository {
    
    override suspend fun createRecurringTransaction(transaction: Transaction): Result<Long> {
        return transactionRepository.addTransaction(transaction)
    }
    
    override suspend fun getRecurringTransactions(): Flow<List<Transaction>> {
        return transactionDao.getRecurringTransactionsFlow("").map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    override suspend fun updateRecurringTransaction(transaction: Transaction): Result<Unit> {
        return transactionRepository.updateTransaction(transaction)
    }
    
    override suspend fun deleteRecurringTransaction(id: Long): Result<Unit> {
        return transactionRepository.deleteTransaction(id)
    }
    
    override suspend fun processRecurringTransactions(): Result<List<Transaction>> {
        return try {
            val recurringTransactions = transactionDao.getRecurringTransactionsList("")
            
            val newTransactions = mutableListOf<Transaction>()
            val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
            
            recurringTransactions.forEach { recurringTransactionEntity ->
                val recurringTransaction = recurringTransactionEntity.toDomain()
                val nextDueDate = calculateNextDueDate(recurringTransaction)
                
                if (nextDueDate != null && nextDueDate <= now) {
                    // Create new transaction based on recurring pattern
                    val newTransaction = recurringTransaction.copy(
                        id = 0, // New transaction
                        date = nextDueDate,
                        isRecurring = false, // The generated transaction is not recurring
                        recurringPattern = null,
                        createdAt = System.currentTimeMillis(),
                        updatedAt = System.currentTimeMillis()
                    )
                    
                    transactionRepository.addTransaction(newTransaction)
                        .onSuccess { newTransactions.add(newTransaction) }
                    
                    // Update the recurring transaction's next due date
                    val updatedRecurringTransaction = recurringTransaction.copy(
                        date = calculateNextDueDate(recurringTransaction, nextDueDate) ?: nextDueDate,
                        updatedAt = System.currentTimeMillis()
                    )
                    
                    transactionRepository.updateTransaction(updatedRecurringTransaction)
                }
            }
            
            Result.success(newTransactions)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getNextDueTransactions(): List<Transaction> {
        return try {
            val recurringTransactions = mutableListOf<Transaction>()
            val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
            
            val transactions = transactionDao.getRecurringTransactionsList("").map { it.toDomain() }
            
            transactions.forEach { transaction ->
                val nextDueDate = calculateNextDueDate(transaction)
                if (nextDueDate != null && nextDueDate <= now.date.plus(DatePeriod(days = 7)).let { 
                    LocalDateTime(it, now.time) 
                }) {
                    recurringTransactions.add(transaction.copy(date = nextDueDate))
                }
            }
            
            recurringTransactions.sortedBy { it.date }
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    private fun calculateNextDueDate(
        transaction: Transaction, 
        fromDate: LocalDateTime? = null
    ): LocalDateTime? {
        val pattern = transaction.recurringPattern ?: return null
        val baseDate = fromDate ?: transaction.date
        
        return when (pattern.frequency) {
            RecurringFrequency.DAILY -> {
                baseDate.date.plus(DatePeriod(days = pattern.interval)).let { 
                    LocalDateTime(it, baseDate.time) 
                }
            }
            RecurringFrequency.WEEKLY -> {
                baseDate.date.plus(DatePeriod(days = pattern.interval * 7)).let { 
                    LocalDateTime(it, baseDate.time) 
                }
            }
            RecurringFrequency.MONTHLY -> {
                baseDate.date.plus(DatePeriod(months = pattern.interval)).let { 
                    LocalDateTime(it, baseDate.time) 
                }
            }
            RecurringFrequency.YEARLY -> {
                baseDate.date.plus(DatePeriod(years = pattern.interval)).let { 
                    LocalDateTime(it, baseDate.time) 
                }
            }
        }
    }
    
    // Extension function for mapping entity to domain
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
}