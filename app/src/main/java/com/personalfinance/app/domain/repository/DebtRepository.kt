package com.personalfinance.app.domain.repository

import com.personalfinance.app.domain.model.Debt
import kotlinx.coroutines.flow.Flow

interface DebtRepository {
    suspend fun addDebt(debt: Debt): Result<Long>
    suspend fun getDebts(): Flow<List<Debt>>
    suspend fun getDebtById(id: Long): Debt?
    suspend fun updateDebt(debt: Debt): Result<Unit>
    suspend fun deleteDebt(id: Long): Result<Unit>
    suspend fun makePayment(debtId: Long, amount: Double): Result<Unit>
    suspend fun getUpcomingPayments(): Flow<List<Debt>>
}