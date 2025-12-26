package com.personalfinance.app.data.local.dao

import androidx.room.*
import com.personalfinance.app.data.local.entity.DebtEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DebtDao {
    
    @Query("SELECT * FROM debts WHERE userId = :userId ORDER BY dueDate ASC")
    fun getAllDebts(userId: String): Flow<List<DebtEntity>>
    
    @Query("SELECT * FROM debts WHERE id = :id")
    suspend fun getDebtById(id: Long): DebtEntity?
    
    @Query("SELECT * FROM debts WHERE userId = :userId AND isActive = 1 ORDER BY dueDate ASC")
    fun getActiveDebts(userId: String): Flow<List<DebtEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDebt(debt: DebtEntity): Long
    
    @Update
    suspend fun updateDebt(debt: DebtEntity)
    
    @Delete
    suspend fun deleteDebt(debt: DebtEntity)
    
    @Query("DELETE FROM debts WHERE id = :id")
    suspend fun deleteDebtById(id: Long)
}