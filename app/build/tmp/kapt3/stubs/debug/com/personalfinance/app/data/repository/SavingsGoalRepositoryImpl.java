package com.personalfinance.app.data.repository;

import com.personalfinance.app.data.local.dao.SavingsGoalDao;
import com.personalfinance.app.domain.model.SavingsGoal;
import com.personalfinance.app.domain.repository.SavingsGoalRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0014\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190\u0018H\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\u0016J\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00190\u0018H\u0096@\u00a2\u0006\u0002\u0010\u001aJ$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001f"}, d2 = {"Lcom/personalfinance/app/data/repository/SavingsGoalRepositoryImpl;", "Lcom/personalfinance/app/domain/repository/SavingsGoalRepository;", "savingsGoalDao", "Lcom/personalfinance/app/data/local/dao/SavingsGoalDao;", "(Lcom/personalfinance/app/data/local/dao/SavingsGoalDao;)V", "addContribution", "Lkotlin/Result;", "", "goalId", "", "amount", "", "addContribution-0E7RQCE", "(JDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createGoal", "goal", "Lcom/personalfinance/app/domain/model/SavingsGoal;", "createGoal-gIAlu-s", "(Lcom/personalfinance/app/domain/model/SavingsGoal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteGoal", "id", "deleteGoal-gIAlu-s", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveGoals", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGoalById", "getGoals", "updateGoal", "updateGoal-gIAlu-s", "app_debug"})
public final class SavingsGoalRepositoryImpl implements com.personalfinance.app.domain.repository.SavingsGoalRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.SavingsGoalDao savingsGoalDao = null;
    
    @javax.inject.Inject()
    public SavingsGoalRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.SavingsGoalDao savingsGoalDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getGoals(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.SavingsGoal>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getGoalById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.domain.model.SavingsGoal> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getActiveGoals(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.SavingsGoal>>> $completion) {
        return null;
    }
}