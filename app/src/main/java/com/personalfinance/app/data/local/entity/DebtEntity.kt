package com.personalfinance.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.personalfinance.app.data.local.converter.DateTimeConverter
import com.personalfinance.app.data.local.converter.PaymentScheduleConverter
import com.personalfinance.app.domain.model.PaymentSchedule
import kotlinx.datetime.LocalDate

@Entity(tableName = "debts")
@TypeConverters(DateTimeConverter::class, PaymentScheduleConverter::class)
data class DebtEntity(
    @PrimaryKey(autoGenerate = true)
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