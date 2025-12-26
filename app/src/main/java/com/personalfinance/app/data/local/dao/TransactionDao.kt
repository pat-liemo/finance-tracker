package com.personalfinance.app.data.local.dao

import androidx.room.*
import com.personalfinance.app.data.local.entity.TransactionEntity
import com.personalfinance.app.domain.model.PaymentMethod
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDateTime

@Dao
interface TransactionDao {
    
    @Query("SELECT * FROM transactions WHERE userId = :userId ORDER BY date DESC")
    fun getAllTransactions(userId: String): Flow<List<TransactionEntity>>
    
    @Query("SELECT * FROM transactions WHERE id = :id")
    suspend fun getTransactionById(id: Long): TransactionEntity?
    
    @Query("SELECT * FROM transactions WHERE userId = :userId AND date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    fun getTransactionsByDateRange(
        userId: String,
        startDate: LocalDateTime,
        endDate: LocalDateTime
    ): Flow<List<TransactionEntity>>
    
    @Query("SELECT * FROM transactions WHERE userId = :userId AND categoryId = :categoryId ORDER BY date DESC")
    fun getTransactionsByCategory(userId: String, categoryId: String): Flow<List<TransactionEntity>>
    
    @Query("SELECT * FROM transactions WHERE userId = :userId AND amount BETWEEN :minAmount AND :maxAmount ORDER BY date DESC")
    fun getTransactionsByAmountRange(
        userId: String,
        minAmount: Double,
        maxAmount: Double
    ): Flow<List<TransactionEntity>>
    
    @Query("SELECT * FROM transactions WHERE userId = :userId AND paymentMethod = :paymentMethod ORDER BY date DESC")
    fun getTransactionsByPaymentMethod(
        userId: String,
        paymentMethod: PaymentMethod
    ): Flow<List<TransactionEntity>>
    
    @Query("SELECT * FROM transactions WHERE userId = :userId AND description LIKE '%' || :searchQuery || '%' ORDER BY date DESC")
    fun searchTransactions(userId: String, searchQuery: String): Flow<List<TransactionEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: TransactionEntity): Long
    
    @Update
    suspend fun updateTransaction(transaction: TransactionEntity)
    
    @Delete
    suspend fun deleteTransaction(transaction: TransactionEntity)
    
    @Query("SELECT * FROM transactions WHERE userId = :userId AND syncStatus = 'PENDING'")
    suspend fun getPendingTransactions(userId: String): List<TransactionEntity>
    
    @Query("SELECT * FROM transactions WHERE isRecurring = 1 AND userId = :userId")
    fun getRecurringTransactionsFlow(userId: String): Flow<List<TransactionEntity>>
    
    @Query("SELECT * FROM transactions WHERE isRecurring = 1 AND userId = :userId")
    suspend fun getRecurringTransactionsList(userId: String): List<TransactionEntity>
    
    @Query("DELETE FROM transactions WHERE id = :id")
    suspend fun deleteTransactionById(id: Long)
    
    @Query("DELETE FROM transactions WHERE userId = :userId")
    suspend fun deleteAllTransactions(userId: String)
}