package com.personalfinance.app.domain.model

import kotlinx.datetime.LocalDate

data class Debt(
    val id: Long = 0,
    val creditorName: String,
    val originalAmount: Double,
    val currentBalance: Double,
    val interestRate: Double,
    val minimumPayment: Double,
    val dueDate: LocalDate,
    val paymentSchedule: PaymentSchedule,
    val isActive: Boolean = true,
    val userId: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)

data class PaymentSchedule(
    val frequency: PaymentFrequency,
    val dayOfMonth: Int? = null, // For monthly payments
    val dayOfWeek: Int? = null   // For weekly payments
)

enum class PaymentFrequency {
    WEEKLY,
    BI_WEEKLY,
    MONTHLY,
    QUARTERLY
}