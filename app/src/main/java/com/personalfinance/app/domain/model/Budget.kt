package com.personalfinance.app.domain.model

import kotlinx.datetime.LocalDate

data class Budget(
    val id: Long = 0,
    val categoryId: String,
    val amount: Double,
    val period: BudgetPeriod,
    val startDate: LocalDate,
    val alertThreshold: Double = 0.8,
    val isActive: Boolean = true,
    val userId: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)

enum class BudgetPeriod {
    WEEKLY,
    MONTHLY,
    QUARTERLY,
    YEARLY
}

data class BudgetAlert(
    val budgetId: Long,
    val categoryId: String,
    val budgetAmount: Double,
    val currentSpending: Double,
    val alertType: BudgetAlertType,
    val message: String
)

enum class BudgetAlertType {
    APPROACHING_LIMIT,
    EXCEEDED_LIMIT,
    MILESTONE_REACHED
}