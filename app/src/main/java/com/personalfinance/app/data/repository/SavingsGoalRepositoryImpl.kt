package com.personalfinance.app.data.repository

import com.personalfinance.app.data.local.dao.SavingsGoalDao
import com.personalfinance.app.domain.model.SavingsGoal
import com.personalfinance.app.domain.repository.SavingsGoalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class SavingsGoalRepositoryImpl @Inject constructor(
    private val savingsGoalDao: SavingsGoalDao
) : SavingsGoalRepository {
    
    override suspend fun createGoal(goal: SavingsGoal): Result<Long> {
        return try {
            Result.failure(NotImplementedError("To be implemented"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getGoals(): Flow<List<SavingsGoal>> {
        return flowOf(emptyList())
    }
    
    override suspend fun getGoalById(id: Long): SavingsGoal? {
        return null
    }
    
    override suspend fun updateGoal(goal: SavingsGoal): Result<Unit> {
        return try {
            Result.failure(NotImplementedError("To be implemented"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun deleteGoal(id: Long): Result<Unit> {
        return try {
            Result.failure(NotImplementedError("To be implemented"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun addContribution(goalId: Long, amount: Double): Result<Unit> {
        return try {
            Result.failure(NotImplementedError("To be implemented"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getActiveGoals(): Flow<List<SavingsGoal>> {
        return flowOf(emptyList())
    }
}