package com.personalfinance.app.domain.repository

import com.personalfinance.app.domain.model.Transaction
import com.personalfinance.app.domain.model.TransactionFilter
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    suspend fun addTransaction(transaction: Transaction): Result<Long>
    suspend fun getTransactions(filter: TransactionFilter): Flow<List<Transaction>>
    suspend fun getTransactionById(id: Long): Transaction?
    suspend fun updateTransaction(transaction: Transaction): Result<Unit>
    suspend fun deleteTransaction(id: Long): Result<Unit>
    suspend fun syncTransactions(): Result<Unit>
    suspend fun getTransactionsByDateRange(
        startDate: kotlinx.datetime.LocalDateTime,
        endDate: kotlinx.datetime.LocalDateTime
    ): Flow<List<Transaction>>
    suspend fun getTransactionsByCategory(categoryId: String): Flow<List<Transaction>>
}