package com.personalfinance.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.personalfinance.app.data.local.converter.DateTimeConverter
import com.personalfinance.app.data.local.converter.PaymentMethodConverter
import com.personalfinance.app.data.local.converter.RecurringPatternConverter
import com.personalfinance.app.data.local.converter.SyncStatusConverter
import com.personalfinance.app.data.local.converter.StringListConverter
import com.personalfinance.app.domain.model.PaymentMethod
import com.personalfinance.app.domain.model.RecurringPattern
import com.personalfinance.app.domain.model.SyncStatus
import kotlinx.datetime.LocalDateTime

@Entity(tableName = "transactions")
@TypeConverters(
    DateTimeConverter::class,
    PaymentMethodConverter::class,
    RecurringPatternConverter::class,
    SyncStatusConverter::class,
    StringListConverter::class
)
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val amount: Double,
    val categoryId: String,
    val date: LocalDateTime,
    val description: String,
    val paymentMethod: PaymentMethod,
    val tags: List<String>,
    val isRecurring: Boolean = false,
    val recurringPattern: RecurringPattern? = null,
    val syncStatus: SyncStatus = SyncStatus.PENDING,
    val userId: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)