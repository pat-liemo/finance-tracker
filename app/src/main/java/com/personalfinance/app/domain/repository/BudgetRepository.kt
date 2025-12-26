package com.personalfinance.app.domain.repository

import com.personalfinance.app.domain.model.Budget
import com.personalfinance.app.domain.model.BudgetAlert
import kotlinx.coroutines.flow.Flow

interface BudgetRepository {
    suspend fun createBudget(budget: Budget): Result<Long>
    suspend fun getBudgets(): Flow<List<Budget>>
    suspend fun getBudgetById(id: Long): Budget?
    suspend fun updateBudget(budget: Budget): Result<Unit>
    suspend fun deleteBudget(id: Long): Result<Unit>
    suspend fun updateBudgetProgress(categoryId: String, amount: Double): Result<Unit>
    suspend fun checkBudgetAlerts(): List<BudgetAlert>
    suspend fun getBudgetsByCategory(categoryId: String): Flow<List<Budget>>
}