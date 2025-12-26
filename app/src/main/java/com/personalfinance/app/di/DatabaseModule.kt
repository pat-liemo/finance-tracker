package com.personalfinance.app.di

import android.content.Context
import androidx.room.Room
import com.personalfinance.app.data.local.database.PersonalFinanceDatabase
import com.personalfinance.app.data.local.dao.TransactionDao
import com.personalfinance.app.data.local.dao.CategoryDao
import com.personalfinance.app.data.local.dao.BudgetDao
import com.personalfinance.app.data.local.dao.UserDao
import com.personalfinance.app.data.local.dao.DebtDao
import com.personalfinance.app.data.local.dao.SavingsGoalDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providePersonalFinanceDatabase(
        @ApplicationContext context: Context
    ): PersonalFinanceDatabase {
        // SQLCipher encryption setup
        val passphrase: ByteArray = SQLiteDatabase.getBytes("personal_finance_key".toCharArray())
        val factory = SupportFactory(passphrase)
        
        return Room.databaseBuilder(
            context,
            PersonalFinanceDatabase::class.java,
            "personal_finance_database"
        )
            .openHelperFactory(factory)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideTransactionDao(database: PersonalFinanceDatabase): TransactionDao {
        return database.transactionDao()
    }

    @Provides
    fun provideCategoryDao(database: PersonalFinanceDatabase): CategoryDao {
        return database.categoryDao()
    }

    @Provides
    fun provideBudgetDao(database: PersonalFinanceDatabase): BudgetDao {
        return database.budgetDao()
    }

    @Provides
    fun provideUserDao(database: PersonalFinanceDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideDebtDao(database: PersonalFinanceDatabase): DebtDao {
        return database.debtDao()
    }

    @Provides
    fun provideSavingsGoalDao(database: PersonalFinanceDatabase): SavingsGoalDao {
        return database.savingsGoalDao()
    }
}