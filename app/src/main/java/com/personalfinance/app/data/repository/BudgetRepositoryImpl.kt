package com.personalfinance.app.data.repository

import com.personalfinance.app.data.local.dao.BudgetDao
import com.personalfinance.app.data.local.dao.TransactionDao
import com.personalfinance.app.data.local.entity.BudgetEntity
import com.personalfinance.app.domain.model.Budget
import com.personalfinance.app.domain.model.BudgetAlert
import com.personalfinance.app.domain.model.BudgetAlertType
import com.personalfinance.app.domain.repository.BudgetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject

class BudgetRepositoryImpl @Inject constructor(
    private val budgetDao: BudgetDao,
    private val transactionDao: TransactionDao
) : BudgetRepository {
    
    override suspend fun createBudget(budget: Budget): Result<Long> {
        return try {
            val entity = budget.toEntity()
            val id = budgetDao.insertBudget(entity)
            Result.success(id)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getBudgets(): Flow<List<Budget>> {
        // For now using empty userId - will be updated when auth is integrated
        return budgetDao.getAllBudgets("").map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    override suspend fun getBudgetById(id: Long): Budget? {
        return try {
            budgetDao.getBudgetById(id)?.toDomain()
        } catch (e: Exception) {
            null
        }
    }
    
    override suspend fun updateBudget(budget: Budget): Result<Unit> {
        return try {
            val entity = budget.toEntity()
            budgetDao.updateBudget(entity)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun deleteBudget(id: Long): Result<Unit> {
        return try {
            budgetDao.deleteBudgetById(id)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun updateBudgetProgress(categoryId: String, amount: Double): Result<Unit> {
        return try {
            // This method would be called when transactions are added/updated
            // For now, we'll just return success as the progress is calculated on-demand
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun checkBudgetAlerts(): List<BudgetAlert> {
        return try {
            val budgets = budgetDao.getAllBudgets("").map { entities ->
                entities.map { it.toDomain() }
            }
            
            // For now, return empty list - alerts would be calculated based on spending vs budget
            emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    override suspend fun getBudgetsByCategory(categoryId: String): Flow<List<Budget>> {
        return budgetDao.getBudgetsByCategory("", categoryId).map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    // Helper method to calculate spending for a category in the current month
    suspend fun getCurrentMonthSpending(categoryId: String): Double {
        return try {
            val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
            val startOfMonth = now.date.let { date ->
                kotlinx.datetime.LocalDateTime(date.year, date.month, 1, 0, 0, 0)
            }
            val endOfMonth = now.date.let { date ->
                val nextMonth = if (date.monthNumber == 12) {
                    kotlinx.datetime.LocalDateTime(date.year + 1, 1, 1, 0, 0, 0)
                } else {
                    kotlinx.datetime.LocalDateTime(date.year, date.monthNumber + 1, 1, 0, 0, 0)
                }
                nextMonth.let { kotlinx.datetime.LocalDateTime(it.year, it.month, it.dayOfMonth - 1, 23, 59, 59) }
            }
            
            val transactions = transactionDao.getTransactionsByDateRange("", startOfMonth, endOfMonth)
            // This would need to be calculated properly - for now return 0
            0.0
        } catch (e: Exception) {
            0.0
        }
    }
    
    // Extension functions for mapping between domain and entity models
    private fun Budget.toEntity(): BudgetEntity {
        return BudgetEntity(
            id = this.id,
            categoryId = this.categoryId,
            amount = this.amount,
            period = this.period,
            startDate = this.startDate,
            alertThreshold = this.alertThreshold,
            isActive = this.isActive,
            userId = this.userId,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt
        )
    }
    
    private fun BudgetEntity.toDomain(): Budget {
        return Budget(
            id = this.id,
            categoryId = this.categoryId,
            amount = this.amount,
            period = this.period,
            startDate = this.startDate,
            alertThreshold = this.alertThreshold,
            isActive = this.isActive,
            userId = this.userId,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt
        )
    }
}