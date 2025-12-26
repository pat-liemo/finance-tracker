package com.personalfinance.app.data.local.dao;

import androidx.room.*;
import com.personalfinance.app.data.local.entity.DebtEntity;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/personalfinance/app/data/local/dao/DebtDao;", "", "deleteDebt", "", "debt", "Lcom/personalfinance/app/data/local/entity/DebtEntity;", "(Lcom/personalfinance/app/data/local/entity/DebtEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDebtById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveDebts", "Lkotlinx/coroutines/flow/Flow;", "", "userId", "", "getAllDebts", "getDebtById", "insertDebt", "updateDebt", "app_debug"})
@androidx.room.Dao()
public abstract interface DebtDao {
    
    @androidx.room.Query(value = "SELECT * FROM debts WHERE userId = :userId ORDER BY dueDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.DebtEntity>> getAllDebts(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Query(value = "SELECT * FROM debts WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDebtById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.data.local.entity.DebtEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM debts WHERE userId = :userId AND isActive = 1 ORDER BY dueDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.DebtEntity>> getActiveDebts(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertDebt(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.DebtEntity debt, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateDebt(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.DebtEntity debt, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteDebt(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.DebtEntity debt, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM debts WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteDebtById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}