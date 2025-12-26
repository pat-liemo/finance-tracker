package com.personalfinance.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.personalfinance.app.data.local.converter.DateTimeConverter
import kotlinx.datetime.LocalDate

@Entity(tableName = "savings_goals")
@TypeConverters(DateTimeConverter::class)
data class SavingsGoalEntity(
    @PrimaryKey(autoGenerate = true)
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
)