package com.personalfinance.app.data.repository;

import com.personalfinance.app.data.local.dao.BudgetDao;
import com.personalfinance.app.data.local.dao.TransactionDao;
import com.personalfinance.app.data.local.entity.BudgetEntity;
import com.personalfinance.app.domain.model.Budget;
import com.personalfinance.app.domain.model.BudgetAlert;
import com.personalfinance.app.domain.model.BudgetAlertType;
import com.personalfinance.app.domain.repository.BudgetRepository;
import kotlinx.coroutines.flow.Flow;
import kotlinx.datetime.Clock;
import kotlinx.datetime.TimeZone;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00a2\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u0014\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u0016J\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u0019H\u0096@\u00a2\u0006\u0002\u0010\nJ\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010\u001dJ$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010\u0011J,\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b$\u0010%J\f\u0010&\u001a\u00020\u000f*\u00020\'H\u0002J\f\u0010(\u001a\u00020\'*\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006)"}, d2 = {"Lcom/personalfinance/app/data/repository/BudgetRepositoryImpl;", "Lcom/personalfinance/app/domain/repository/BudgetRepository;", "budgetDao", "Lcom/personalfinance/app/data/local/dao/BudgetDao;", "transactionDao", "Lcom/personalfinance/app/data/local/dao/TransactionDao;", "(Lcom/personalfinance/app/data/local/dao/BudgetDao;Lcom/personalfinance/app/data/local/dao/TransactionDao;)V", "checkBudgetAlerts", "", "Lcom/personalfinance/app/domain/model/BudgetAlert;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBudget", "Lkotlin/Result;", "", "budget", "Lcom/personalfinance/app/domain/model/Budget;", "createBudget-gIAlu-s", "(Lcom/personalfinance/app/domain/model/Budget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBudget", "", "id", "deleteBudget-gIAlu-s", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBudgetById", "getBudgets", "Lkotlinx/coroutines/flow/Flow;", "getBudgetsByCategory", "categoryId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentMonthSpending", "", "updateBudget", "updateBudget-gIAlu-s", "updateBudgetProgress", "amount", "updateBudgetProgress-0E7RQCE", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDomain", "Lcom/personalfinance/app/data/local/entity/BudgetEntity;", "toEntity", "app_debug"})
public final class BudgetRepositoryImpl implements com.personalfinance.app.domain.repository.BudgetRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.BudgetDao budgetDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.TransactionDao transactionDao = null;
    
    @javax.inject.Inject()
    public BudgetRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.BudgetDao budgetDao, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.TransactionDao transactionDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getBudgets(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Budget>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getBudgetById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.domain.model.Budget> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object checkBudgetAlerts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.personalfinance.app.domain.model.BudgetAlert>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getBudgetsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Budget>>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCurrentMonthSpending(@org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    private final com.personalfinance.app.data.local.entity.BudgetEntity toEntity(com.personalfinance.app.domain.model.Budget $this$toEntity) {
        return null;
    }
    
    private final com.personalfinance.app.domain.model.Budget toDomain(com.personalfinance.app.data.local.entity.BudgetEntity $this$toDomain) {
        return null;
    }
}