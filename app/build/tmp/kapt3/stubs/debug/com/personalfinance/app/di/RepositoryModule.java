package com.personalfinance.app.di;

import com.personalfinance.app.data.repository.AuthRepositoryImpl;
import com.personalfinance.app.data.repository.TransactionRepositoryImpl;
import com.personalfinance.app.data.repository.BudgetRepositoryImpl;
import com.personalfinance.app.data.repository.CategoryRepositoryImpl;
import com.personalfinance.app.data.repository.RecurringTransactionRepositoryImpl;
import com.personalfinance.app.data.repository.AnalyticsRepositoryImpl;
import com.personalfinance.app.data.repository.ExportRepositoryImpl;
import com.personalfinance.app.data.repository.DebtRepositoryImpl;
import com.personalfinance.app.data.repository.SavingsGoalRepositoryImpl;
import com.personalfinance.app.data.repository.CurrencyRepositoryImpl;
import com.personalfinance.app.domain.repository.AuthRepository;
import com.personalfinance.app.domain.repository.TransactionRepository;
import com.personalfinance.app.domain.repository.BudgetRepository;
import com.personalfinance.app.domain.repository.CategoryRepository;
import com.personalfinance.app.domain.repository.RecurringTransactionRepository;
import com.personalfinance.app.domain.repository.AnalyticsRepository;
import com.personalfinance.app.domain.repository.ExportRepository;
import com.personalfinance.app.domain.repository.DebtRepository;
import com.personalfinance.app.domain.repository.SavingsGoalRepository;
import com.personalfinance.app.domain.repository.CurrencyRepository;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\'J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\'J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\'J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\'J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\'J\u0010\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\'\u00a8\u0006+"}, d2 = {"Lcom/personalfinance/app/di/RepositoryModule;", "", "()V", "bindAnalyticsRepository", "Lcom/personalfinance/app/domain/repository/AnalyticsRepository;", "analyticsRepositoryImpl", "Lcom/personalfinance/app/data/repository/AnalyticsRepositoryImpl;", "bindAuthRepository", "Lcom/personalfinance/app/domain/repository/AuthRepository;", "authRepositoryImpl", "Lcom/personalfinance/app/data/repository/AuthRepositoryImpl;", "bindBudgetRepository", "Lcom/personalfinance/app/domain/repository/BudgetRepository;", "budgetRepositoryImpl", "Lcom/personalfinance/app/data/repository/BudgetRepositoryImpl;", "bindCategoryRepository", "Lcom/personalfinance/app/domain/repository/CategoryRepository;", "categoryRepositoryImpl", "Lcom/personalfinance/app/data/repository/CategoryRepositoryImpl;", "bindCurrencyRepository", "Lcom/personalfinance/app/domain/repository/CurrencyRepository;", "currencyRepositoryImpl", "Lcom/personalfinance/app/data/repository/CurrencyRepositoryImpl;", "bindDebtRepository", "Lcom/personalfinance/app/domain/repository/DebtRepository;", "debtRepositoryImpl", "Lcom/personalfinance/app/data/repository/DebtRepositoryImpl;", "bindExportRepository", "Lcom/personalfinance/app/domain/repository/ExportRepository;", "exportRepositoryImpl", "Lcom/personalfinance/app/data/repository/ExportRepositoryImpl;", "bindRecurringTransactionRepository", "Lcom/personalfinance/app/domain/repository/RecurringTransactionRepository;", "recurringTransactionRepositoryImpl", "Lcom/personalfinance/app/data/repository/RecurringTransactionRepositoryImpl;", "bindSavingsGoalRepository", "Lcom/personalfinance/app/domain/repository/SavingsGoalRepository;", "savingsGoalRepositoryImpl", "Lcom/personalfinance/app/data/repository/SavingsGoalRepositoryImpl;", "bindTransactionRepository", "Lcom/personalfinance/app/domain/repository/TransactionRepository;", "transactionRepositoryImpl", "Lcom/personalfinance/app/data/repository/TransactionRepositoryImpl;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.domain.repository.AuthRepository bindAuthRepository(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.repository.AuthRepositoryImpl authRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.domain.repository.TransactionRepository bindTransactionRepository(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.repository.TransactionRepositoryImpl transactionRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.domain.repository.BudgetRepository bindBudgetRepository(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.repository.BudgetRepositoryImpl budgetRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.domain.repository.CategoryRepository bindCategoryRepository(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.repository.CategoryRepositoryImpl categoryRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.domain.repository.RecurringTransactionRepository bindRecurringTransactionRepository(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.repository.RecurringTransactionRepositoryImpl recurringTransactionRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.domain.repository.AnalyticsRepository bindAnalyticsRepository(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.repository.AnalyticsRepositoryImpl analyticsRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.domain.repository.ExportRepository bindExportRepository(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.repository.ExportRepositoryImpl exportRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.domain.repository.DebtRepository bindDebtRepository(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.repository.DebtRepositoryImpl debtRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.domain.repository.SavingsGoalRepository bindSavingsGoalRepository(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.repository.SavingsGoalRepositoryImpl savingsGoalRepositoryImpl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.personalfinance.app.domain.repository.CurrencyRepository bindCurrencyRepository(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.repository.CurrencyRepositoryImpl currencyRepositoryImpl);
}