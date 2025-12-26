package com.personalfinance.app.domain.repository;

import com.personalfinance.app.domain.model.SavingsGoal;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\f\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160\u0015H\u00a6@\u00a2\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0013J\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160\u0015H\u00a6@\u00a2\u0006\u0002\u0010\u0017J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u000f\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001c"}, d2 = {"Lcom/personalfinance/app/domain/repository/SavingsGoalRepository;", "", "addContribution", "Lkotlin/Result;", "", "goalId", "", "amount", "", "addContribution-0E7RQCE", "(JDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createGoal", "goal", "Lcom/personalfinance/app/domain/model/SavingsGoal;", "createGoal-gIAlu-s", "(Lcom/personalfinance/app/domain/model/SavingsGoal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteGoal", "id", "deleteGoal-gIAlu-s", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveGoals", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGoalById", "getGoals", "updateGoal", "updateGoal-gIAlu-s", "app_debug"})
public abstract interface SavingsGoalRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGoals(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.SavingsGoal>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGoalById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.domain.model.SavingsGoal> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getActiveGoals(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.SavingsGoal>>> $completion);
}