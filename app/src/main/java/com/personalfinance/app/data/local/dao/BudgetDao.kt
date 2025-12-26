package com.personalfinance.app.data.local.dao

import androidx.room.*
import com.personalfinance.app.data.local.entity.BudgetEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {
    
    @Query("SELECT * FROM budgets WHERE userId = :userId ORDER BY createdAt DESC")
    fun getAllBudgets(userId: String): Flow<List<BudgetEntity>>
    
    @Query("SELECT * FROM budgets WHERE id = :id")
    suspend fun getBudgetById(id: Long): BudgetEntity?
    
    @Query("SELECT * FROM budgets WHERE userId = :userId AND categoryId = :categoryId")
    fun getBudgetsByCategory(userId: String, categoryId: String): Flow<List<BudgetEntity>>
    
    @Query("SELECT * FROM budgets WHERE userId = :userId AND isActive = 1")
    fun getActiveBudgets(userId: String): Flow<List<BudgetEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBudget(budget: BudgetEntity): Long
    
    @Update
    suspend fun updateBudget(budget: BudgetEntity)
    
    @Delete
    suspend fun deleteBudget(budget: BudgetEntity)
    
    @Query("DELETE FROM budgets WHERE id = :id")
    suspend fun deleteBudgetById(id: Long)
    
    @Query("DELETE FROM budgets WHERE userId = :userId")
    suspend fun deleteAllBudgets(userId: String)
}