package com.personalfinance.app.data.local.dao;

import androidx.room.*;
import com.personalfinance.app.data.local.entity.SavingsGoalEntity;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/personalfinance/app/data/local/dao/SavingsGoalDao;", "", "deleteGoal", "", "goal", "Lcom/personalfinance/app/data/local/entity/SavingsGoalEntity;", "(Lcom/personalfinance/app/data/local/entity/SavingsGoalEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteGoalById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveGoals", "Lkotlinx/coroutines/flow/Flow;", "", "userId", "", "getAllGoals", "getGoalById", "insertGoal", "updateGoal", "app_debug"})
@androidx.room.Dao()
public abstract interface SavingsGoalDao {
    
    @androidx.room.Query(value = "SELECT * FROM savings_goals WHERE userId = :userId ORDER BY targetDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.SavingsGoalEntity>> getAllGoals(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Query(value = "SELECT * FROM savings_goals WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGoalById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.data.local.entity.SavingsGoalEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM savings_goals WHERE userId = :userId AND isCompleted = 0 ORDER BY targetDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.SavingsGoalEntity>> getActiveGoals(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertGoal(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.SavingsGoalEntity goal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateGoal(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.SavingsGoalEntity goal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteGoal(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.SavingsGoalEntity goal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM savings_goals WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteGoalById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}