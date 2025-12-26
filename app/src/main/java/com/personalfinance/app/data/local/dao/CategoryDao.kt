package com.personalfinance.app.data.local.dao

import androidx.room.*
import com.personalfinance.app.data.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    
    @Query("SELECT * FROM categories WHERE userId = :userId OR isDefault = 1 ORDER BY name ASC")
    fun getAllCategories(userId: String): Flow<List<CategoryEntity>>
    
    @Query("SELECT * FROM categories WHERE id = :id")
    suspend fun getCategoryById(id: String): CategoryEntity?
    
    @Query("SELECT * FROM categories WHERE isDefault = 1")
    suspend fun getDefaultCategories(): List<CategoryEntity>
    
    @Query("SELECT * FROM categories WHERE userId = :userId AND isDefault = 0")
    fun getUserCategories(userId: String): Flow<List<CategoryEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: CategoryEntity)
    
    @Update
    suspend fun updateCategory(category: CategoryEntity)
    
    @Delete
    suspend fun deleteCategory(category: CategoryEntity)
    
    @Query("DELETE FROM categories WHERE id = :id")
    suspend fun deleteCategoryById(id: String)
    
    @Query("DELETE FROM categories WHERE userId = :userId")
    suspend fun deleteAllCategories(userId: String)
}