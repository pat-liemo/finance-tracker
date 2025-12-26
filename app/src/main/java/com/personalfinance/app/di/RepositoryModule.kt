package com.personalfinance.app.di

import com.personalfinance.app.data.repository.AuthRepositoryImpl
import com.personalfinance.app.data.repository.TransactionRepositoryImpl
import com.personalfinance.app.data.repository.BudgetRepositoryImpl
import com.personalfinance.app.data.repository.CategoryRepositoryImpl
import com.personalfinance.app.data.repository.RecurringTransactionRepositoryImpl
import com.personalfinance.app.data.repository.AnalyticsRepositoryImpl
import com.personalfinance.app.data.repository.ExportRepositoryImpl
import com.personalfinance.app.data.repository.DebtRepositoryImpl
import com.personalfinance.app.data.repository.SavingsGoalRepositoryImpl
import com.personalfinance.app.data.repository.CurrencyRepositoryImpl
import com.personalfinance.app.domain.repository.AuthRepository
import com.personalfinance.app.domain.repository.TransactionRepository
import com.personalfinance.app.domain.repository.BudgetRepository
import com.personalfinance.app.domain.repository.CategoryRepository
import com.personalfinance.app.domain.repository.RecurringTransactionRepository
import com.personalfinance.app.domain.repository.AnalyticsRepository
import com.personalfinance.app.domain.repository.ExportRepository
import com.personalfinance.app.domain.repository.DebtRepository
import com.personalfinance.app.domain.repository.SavingsGoalRepository
import com.personalfinance.app.domain.repository.CurrencyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindTransactionRepository(
        transactionRepositoryImpl: TransactionRepositoryImpl
    ): TransactionRepository

    @Binds
    @Singleton
    abstract fun bindBudgetRepository(
        budgetRepositoryImpl: BudgetRepositoryImpl
    ): BudgetRepository

    @Binds
    @Singleton
    abstract fun bindCategoryRepository(
        categoryRepositoryImpl: CategoryRepositoryImpl
    ): CategoryRepository

    @Binds
    @Singleton
    abstract fun bindRecurringTransactionRepository(
        recurringTransactionRepositoryImpl: RecurringTransactionRepositoryImpl
    ): RecurringTransactionRepository

    @Binds
    @Singleton
    abstract fun bindAnalyticsRepository(
        analyticsRepositoryImpl: AnalyticsRepositoryImpl
    ): AnalyticsRepository

    @Binds
    @Singleton
    abstract fun bindExportRepository(
        exportRepositoryImpl: ExportRepositoryImpl
    ): ExportRepository

    @Binds
    @Singleton
    abstract fun bindDebtRepository(
        debtRepositoryImpl: DebtRepositoryImpl
    ): DebtRepository

    @Binds
    @Singleton
    abstract fun bindSavingsGoalRepository(
        savingsGoalRepositoryImpl: SavingsGoalRepositoryImpl
    ): SavingsGoalRepository

    @Binds
    @Singleton
    abstract fun bindCurrencyRepository(
        currencyRepositoryImpl: CurrencyRepositoryImpl
    ): CurrencyRepository
}