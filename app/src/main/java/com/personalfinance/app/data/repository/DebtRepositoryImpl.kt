package com.personalfinance.app.data.repository

import com.personalfinance.app.data.local.dao.DebtDao
import com.personalfinance.app.domain.model.Debt
import com.personalfinance.app.domain.repository.DebtRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class DebtRepositoryImpl @Inject constructor(
    private val debtDao: DebtDao
) : DebtRepository {
    
    override suspend fun addDebt(debt: Debt): Result<Long> {
        return try {
            Result.failure(NotImplementedError("To be implemented"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getDebts(): Flow<List<Debt>> {
        return flowOf(emptyList())
    }
    
    override suspend fun getDebtById(id: Long): Debt? {
        return null
    }
    
    override suspend fun updateDebt(debt: Debt): Result<Unit> {
        return try {
            Result.failure(NotImplementedError("To be implemented"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun deleteDebt(id: Long): Result<Unit> {
        return try {
            Result.failure(NotImplementedError("To be implemented"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun makePayment(debtId: Long, amount: Double): Result<Unit> {
        return try {
            Result.failure(NotImplementedError("To be implemented"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getUpcomingPayments(): Flow<List<Debt>> {
        return flowOf(emptyList())
    }
}