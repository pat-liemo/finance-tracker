package com.personalfinance.app.domain.model

import kotlinx.datetime.LocalDate

data class SavingsGoal(
    val id: Long = 0,
    val name: String,
    val description: String,
    val targetAmount: Double,
    val currentAmount: Double = 0.0,
    val targetDate: LocalDate,
    val isCompleted: Boolean = false,
    val userId: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) {
    val progressPercentage: Double
        get() = if (targetAmount > 0) (currentAmount / targetAmount) * 100 else 0.0
    
    val remainingAmount: Double
        get() = maxOf(0.0, targetAmount - currentAmount)
}