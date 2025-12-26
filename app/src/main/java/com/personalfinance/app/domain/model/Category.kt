package com.personalfinance.app.domain.model

data class Category(
    val id: String,
    val name: String,
    val icon: String,
    val color: String,
    val isDefault: Boolean = false,
    val parentCategoryId: String? = null,
    val userId: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)

object DefaultCategories {
    fun getDefaultCategories(userId: String): List<Category> {
        return listOf(
            Category(
                id = "food",
                name = "Food & Dining",
                icon = "🍽️",
                color = "#FF6B6B",
                isDefault = true,
                userId = userId
            ),
            Category(
                id = "transport",
                name = "Transportation",
                icon = "🚗",
                color = "#4ECDC4",
                isDefault = true,
                userId = userId
            ),
            Category(
                id = "shopping",
                name = "Shopping",
                icon = "🛍️",
                color = "#45B7D1",
                isDefault = true,
                userId = userId
            ),
            Category(
                id = "entertainment",
                name = "Entertainment",
                icon = "🎬",
                color = "#96CEB4",
                isDefault = true,
                userId = userId
            ),
            Category(
                id = "bills",
                name = "Bills & Utilities",
                icon = "💡",
                color = "#FFEAA7",
                isDefault = true,
                userId = userId
            ),
            Category(
                id = "healthcare",
                name = "Healthcare",
                icon = "🏥",
                color = "#DDA0DD",
                isDefault = true,
                userId = userId
            ),
            Category(
                id = "education",
                name = "Education",
                icon = "📚",
                color = "#98D8C8",
                isDefault = true,
                userId = userId
            ),
            Category(
                id = "salary",
                name = "Salary",
                icon = "💰",
                color = "#6C5CE7",
                isDefault = true,
                userId = userId
            ),
            Category(
                id = "freelance",
                name = "Freelance",
                icon = "💻",
                color = "#A29BFE",
                isDefault = true,
                userId = userId
            ),
            Category(
                id = "investment",
                name = "Investment",
                icon = "📈",
                color = "#FD79A8",
                isDefault = true,
                userId = userId
            ),
            Category(
                id = "other",
                name = "Other",
                icon = "📝",
                color = "#636E72",
                isDefault = true,
                userId = userId
            )
        )
    }
}