package com.personalfinance.app.domain.model

import kotlinx.datetime.LocalDateTime

data class TransactionFilter(
    val startDate: LocalDateTime? = null,
    val endDate: LocalDateTime? = null,
    val categoryIds: List<String> = emptyList(),
    val minAmount: Double? = null,
    val maxAmount: Double? = null,
    val paymentMethods: List<PaymentMethod> = emptyList(),
    val searchQuery: String? = null,
    val tags: List<String> = emptyList(),
    val isRecurring: Boolean? = null
)