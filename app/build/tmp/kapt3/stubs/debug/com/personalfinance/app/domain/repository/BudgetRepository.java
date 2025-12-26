package com.personalfinance.app.domain.repository;

import com.personalfinance.app.domain.model.Budget;
import com.personalfinance.app.domain.model.BudgetAlert;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u000f\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\u0011J\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u0014H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\"\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u00a6@\u00a2\u0006\u0002\u0010\u0018J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001a\u0010\fJ,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001f\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006 "}, d2 = {"Lcom/personalfinance/app/domain/repository/BudgetRepository;", "", "checkBudgetAlerts", "", "Lcom/personalfinance/app/domain/model/BudgetAlert;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBudget", "Lkotlin/Result;", "", "budget", "Lcom/personalfinance/app/domain/model/Budget;", "createBudget-gIAlu-s", "(Lcom/personalfinance/app/domain/model/Budget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBudget", "", "id", "deleteBudget-gIAlu-s", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBudgetById", "getBudgets", "Lkotlinx/coroutines/flow/Flow;", "getBudgetsByCategory", "categoryId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBudget", "updateBudget-gIAlu-s", "updateBudgetProgress", "amount", "", "updateBudgetProgress-0E7RQCE", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface BudgetRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBudgets(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Budget>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBudgetById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.domain.model.Budget> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object checkBudgetAlerts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.personalfinance.app.domain.model.BudgetAlert>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBudgetsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Budget>>> $completion);
}