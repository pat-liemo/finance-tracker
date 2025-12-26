package com.personalfinance.app.data.repository

import com.personalfinance.app.data.local.dao.CategoryDao
import com.personalfinance.app.data.local.entity.CategoryEntity
import com.personalfinance.app.domain.model.Category
import com.personalfinance.app.domain.model.DefaultCategories
import com.personalfinance.app.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao
) : CategoryRepository {
    
    override suspend fun createCategory(category: Category): Result<Long> {
        return try {
            val entity = category.toEntity()
            categoryDao.insertCategory(entity)
            Result.success(0L) // Room doesn't return ID for string primary keys
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getCategories(): Flow<List<Category>> {
        // For now using empty userId - will be updated when auth is integrated
        return categoryDao.getAllCategories("").map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    override suspend fun getCategoryById(id: String): Category? {
        return try {
            categoryDao.getCategoryById(id)?.toDomain()
        } catch (e: Exception) {
            null
        }
    }
    
    override suspend fun updateCategory(category: Category): Result<Unit> {
        return try {
            val entity = category.toEntity()
            categoryDao.updateCategory(entity)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun deleteCategory(id: String): Result<Unit> {
        return try {
            categoryDao.deleteCategoryById(id)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getDefaultCategories(): List<Category> {
        return DefaultCategories.getDefaultCategories("")
    }
    
    override suspend fun initializeDefaultCategories(): Result<Unit> {
        return try {
            val defaultCategories = DefaultCategories.getDefaultCategories("")
            defaultCategories.forEach { category ->
                val entity = category.toEntity()
                categoryDao.insertCategory(entity)
            }
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    // Extension functions for mapping between domain and entity models
    private fun Category.toEntity(): CategoryEntity {
        return CategoryEntity(
            id = this.id,
            name = this.name,
            icon = this.icon,
            color = this.color,
            isDefault = this.isDefault,
            parentCategoryId = this.parentCategoryId,
            userId = this.userId,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt
        )
    }
    
    private fun CategoryEntity.toDomain(): Category {
        return Category(
            id = this.id,
            name = this.name,
            icon = this.icon,
            color = this.color,
            isDefault = this.isDefault,
            parentCategoryId = this.parentCategoryId,
            userId = this.userId,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt
        )
    }
}