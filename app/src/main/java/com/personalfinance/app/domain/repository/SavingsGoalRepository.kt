package com.personalfinance.app.domain.repository

import com.personalfinance.app.domain.model.SavingsGoal
import kotlinx.coroutines.flow.Flow

interface SavingsGoalRepository {
    suspend fun createGoal(goal: SavingsGoal): Result<Long>
    suspend fun getGoals(): Flow<List<SavingsGoal>>
    suspend fun getGoalById(id: Long): SavingsGoal?
    suspend fun updateGoal(goal: SavingsGoal): Result<Unit>
    suspend fun deleteGoal(id: Long): Result<Unit>
    suspend fun addContribution(goalId: Long, amount: Double): Result<Unit>
    suspend fun getActiveGoals(): Flow<List<SavingsGoal>>
}