package com.personalfinance.app.data.local.dao

import androidx.room.*
import com.personalfinance.app.data.local.entity.SavingsGoalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SavingsGoalDao {
    
    @Query("SELECT * FROM savings_goals WHERE userId = :userId ORDER BY targetDate ASC")
    fun getAllGoals(userId: String): Flow<List<SavingsGoalEntity>>
    
    @Query("SELECT * FROM savings_goals WHERE id = :id")
    suspend fun getGoalById(id: Long): SavingsGoalEntity?
    
    @Query("SELECT * FROM savings_goals WHERE userId = :userId AND isCompleted = 0 ORDER BY targetDate ASC")
    fun getActiveGoals(userId: String): Flow<List<SavingsGoalEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGoal(goal: SavingsGoalEntity): Long
    
    @Update
    suspend fun updateGoal(goal: SavingsGoalEntity)
    
    @Delete
    suspend fun deleteGoal(goal: SavingsGoalEntity)
    
    @Query("DELETE FROM savings_goals WHERE id = :id")
    suspend fun deleteGoalById(id: Long)
}