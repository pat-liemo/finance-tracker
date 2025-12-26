package com.personalfinance.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.personalfinance.app.data.local.converter.BudgetPeriodConverter
import com.personalfinance.app.data.local.converter.DateTimeConverter
import com.personalfinance.app.domain.model.BudgetPeriod
import kotlinx.datetime.LocalDate

@Entity(tableName = "budgets")
@TypeConverters(DateTimeConverter::class, BudgetPeriodConverter::class)
data class BudgetEntity(
    @PrimaryKey(autoGenerate = true)
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