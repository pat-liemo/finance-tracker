package com.personalfinance.app.domain.repository

import com.personalfinance.app.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun createCategory(category: Category): Result<Long>
    suspend fun getCategories(): Flow<List<Category>>
    suspend fun getCategoryById(id: String): Category?
    suspend fun updateCategory(category: Category): Result<Unit>
    suspend fun deleteCategory(id: String): Result<Unit>
    suspend fun getDefaultCategories(): List<Category>
    suspend fun initializeDefaultCategories(): Result<Unit>
}