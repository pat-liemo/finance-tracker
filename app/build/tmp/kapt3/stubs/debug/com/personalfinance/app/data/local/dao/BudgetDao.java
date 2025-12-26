package com.personalfinance.app.data.local.dao;

import androidx.room.*;
import com.personalfinance.app.data.local.entity.BudgetEntity;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ$\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\'J\u0016\u0010\u0016\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/personalfinance/app/data/local/dao/BudgetDao;", "", "deleteAllBudgets", "", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBudget", "budget", "Lcom/personalfinance/app/data/local/entity/BudgetEntity;", "(Lcom/personalfinance/app/data/local/entity/BudgetEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBudgetById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveBudgets", "Lkotlinx/coroutines/flow/Flow;", "", "getAllBudgets", "getBudgetById", "getBudgetsByCategory", "categoryId", "insertBudget", "updateBudget", "app_debug"})
@androidx.room.Dao()
public abstract interface BudgetDao {
    
    @androidx.room.Query(value = "SELECT * FROM budgets WHERE userId = :userId ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.BudgetEntity>> getAllBudgets(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Query(value = "SELECT * FROM budgets WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBudgetById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.data.local.entity.BudgetEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM budgets WHERE userId = :userId AND categoryId = :categoryId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.BudgetEntity>> getBudgetsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String categoryId);
    
    @androidx.room.Query(value = "SELECT * FROM budgets WHERE userId = :userId AND isActive = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.BudgetEntity>> getActiveBudgets(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertBudget(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.BudgetEntity budget, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateBudget(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.BudgetEntity budget, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteBudget(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.BudgetEntity budget, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM budgets WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteBudgetById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM budgets WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllBudgets(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}