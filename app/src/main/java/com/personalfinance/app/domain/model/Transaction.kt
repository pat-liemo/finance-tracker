package com.personalfinance.app.domain.model

import kotlinx.datetime.LocalDateTime

data class Transaction(
    val id: Long = 0,
    val amount: Double,
    val categoryId: String,
    val date: LocalDateTime,
    val description: String,
    val paymentMethod: PaymentMethod,
    val tags: List<String> = emptyList(),
    val isRecurring: Boolean = false,
    val recurringPattern: RecurringPattern? = null,
    val syncStatus: SyncStatus = SyncStatus.PENDING,
    val userId: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)

enum class PaymentMethod {
    CASH,
    CREDIT_CARD,
    DEBIT_CARD,
    BANK_TRANSFER,
    DIGITAL_WALLET,
    CHECK,
    OTHER
}

data class RecurringPattern(
    val frequency: RecurringFrequency,
    val interval: Int = 1, // Every X days/weeks/months/years
    val endDate: LocalDateTime? = null,
    val maxOccurrences: Int? = null
)

enum class RecurringFrequency {
    DAILY,
    WEEKLY,
    MONTHLY,
    YEARLY
}

enum class SyncStatus {
    PENDING,
    SYNCED,
    FAILED
}