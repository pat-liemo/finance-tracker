package com.personalfinance.app.data.local.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.personalfinance.app.data.local.converter.*
import com.personalfinance.app.data.local.dao.*
import com.personalfinance.app.data.local.entity.*

@Database(
    entities = [
        TransactionEntity::class,
        CategoryEntity::class,
        BudgetEntity::class,
        UserEntity::class,
        DebtEntity::class,
        SavingsGoalEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    DateTimeConverter::class,
    PaymentMethodConverter::class,
    RecurringPatternConverter::class,
    SyncStatusConverter::class,
    StringListConverter::class,
    BudgetPeriodConverter::class,
    PaymentScheduleConverter::class
)
abstract class PersonalFinanceDatabase : RoomDatabase() {
    
    abstract fun transactionDao(): TransactionDao
    abstract fun categoryDao(): CategoryDao
    abstract fun budgetDao(): BudgetDao
    abstract fun userDao(): UserDao
    abstract fun debtDao(): DebtDao
    abstract fun savingsGoalDao(): SavingsGoalDao
}