package com.personalfinance.app.domain.repository

import com.personalfinance.app.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

interface RecurringTransactionRepository {
    suspend fun createRecurringTransaction(transaction: Transaction): Result<Long>
    suspend fun getRecurringTransactions(): Flow<List<Transaction>>
    suspend fun updateRecurringTransaction(transaction: Transaction): Result<Unit>
    suspend fun deleteRecurringTransaction(id: Long): Result<Unit>
    suspend fun processRecurringTransactions(): Result<List<Transaction>>
    suspend fun getNextDueTransactions(): List<Transaction>
}