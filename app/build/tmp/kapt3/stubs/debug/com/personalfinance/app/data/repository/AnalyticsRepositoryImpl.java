package com.personalfinance.app.data.repository;

import com.personalfinance.app.data.local.dao.BudgetDao;
import com.personalfinance.app.data.local.dao.CategoryDao;
import com.personalfinance.app.data.local.dao.TransactionDao;
import com.personalfinance.app.domain.model.*;
import com.personalfinance.app.domain.repository.AnalyticsRepository;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\n2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u000fJ$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\n2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0016\u0010\u000fJ$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0019\u0010\u000fJ\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00110\nH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001e"}, d2 = {"Lcom/personalfinance/app/data/repository/AnalyticsRepositoryImpl;", "Lcom/personalfinance/app/domain/repository/AnalyticsRepository;", "transactionDao", "Lcom/personalfinance/app/data/local/dao/TransactionDao;", "categoryDao", "Lcom/personalfinance/app/data/local/dao/CategoryDao;", "budgetDao", "Lcom/personalfinance/app/data/local/dao/BudgetDao;", "(Lcom/personalfinance/app/data/local/dao/TransactionDao;Lcom/personalfinance/app/data/local/dao/CategoryDao;Lcom/personalfinance/app/data/local/dao/BudgetDao;)V", "calculateTrends", "Lkotlin/Result;", "Lcom/personalfinance/app/domain/model/TrendAnalysis;", "period", "Lcom/personalfinance/app/domain/model/DateRange;", "calculateTrends-gIAlu-s", "(Lcom/personalfinance/app/domain/model/DateRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectSpendingBehaviorChanges", "", "", "detectSpendingBehaviorChanges-gIAlu-s", "generateIncomeVsExpenseChart", "Lcom/personalfinance/app/domain/model/ChartData;", "generateIncomeVsExpenseChart-gIAlu-s", "generateSpendingBreakdown", "Lcom/personalfinance/app/domain/model/SpendingBreakdown;", "generateSpendingBreakdown-gIAlu-s", "getBudgetUtilization", "Lcom/personalfinance/app/domain/model/BudgetUtilization;", "getBudgetUtilization-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AnalyticsRepositoryImpl implements com.personalfinance.app.domain.repository.AnalyticsRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.TransactionDao transactionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.CategoryDao categoryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.BudgetDao budgetDao = null;
    
    @javax.inject.Inject()
    public AnalyticsRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.TransactionDao transactionDao, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.CategoryDao categoryDao, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.BudgetDao budgetDao) {
        super();
    }
}