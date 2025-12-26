package com.personalfinance.app.data.local.dao;

import androidx.room.*;
import com.personalfinance.app.data.local.entity.TransactionEntity;
import com.personalfinance.app.domain.model.PaymentMethod;
import kotlinx.coroutines.flow.Flow;
import kotlinx.datetime.LocalDateTime;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ,\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\'J$\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\'J,\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\'J$\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\'J\u0016\u0010#\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ$\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00110\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\'J\u0016\u0010&\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\'"}, d2 = {"Lcom/personalfinance/app/data/local/dao/TransactionDao;", "", "deleteAllTransactions", "", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTransaction", "transaction", "Lcom/personalfinance/app/data/local/entity/TransactionEntity;", "(Lcom/personalfinance/app/data/local/entity/TransactionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTransactionById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTransactions", "Lkotlinx/coroutines/flow/Flow;", "", "getPendingTransactions", "getRecurringTransactionsFlow", "getRecurringTransactionsList", "getTransactionById", "getTransactionsByAmountRange", "minAmount", "", "maxAmount", "getTransactionsByCategory", "categoryId", "getTransactionsByDateRange", "startDate", "Lkotlinx/datetime/LocalDateTime;", "endDate", "getTransactionsByPaymentMethod", "paymentMethod", "Lcom/personalfinance/app/domain/model/PaymentMethod;", "insertTransaction", "searchTransactions", "searchQuery", "updateTransaction", "app_debug"})
@androidx.room.Dao()
public abstract interface TransactionDao {
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE userId = :userId ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.TransactionEntity>> getAllTransactions(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.data.local.entity.TransactionEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE userId = :userId AND date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.TransactionEntity>> getTransactionsByDateRange(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime startDate, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime endDate);
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE userId = :userId AND categoryId = :categoryId ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.TransactionEntity>> getTransactionsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String categoryId);
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE userId = :userId AND amount BETWEEN :minAmount AND :maxAmount ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.TransactionEntity>> getTransactionsByAmountRange(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, double minAmount, double maxAmount);
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE userId = :userId AND paymentMethod = :paymentMethod ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.TransactionEntity>> getTransactionsByPaymentMethod(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.PaymentMethod paymentMethod);
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE userId = :userId AND description LIKE \'%\' || :searchQuery || \'%\' ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.TransactionEntity>> searchTransactions(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTransaction(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.TransactionEntity transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateTransaction(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.TransactionEntity transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTransaction(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.TransactionEntity transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE userId = :userId AND syncStatus = \'PENDING\'")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPendingTransactions(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.personalfinance.app.data.local.entity.TransactionEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE isRecurring = 1 AND userId = :userId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.TransactionEntity>> getRecurringTransactionsFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE isRecurring = 1 AND userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRecurringTransactionsList(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.personalfinance.app.data.local.entity.TransactionEntity>> $completion);
    
    @androidx.room.Query(value = "DELETE FROM transactions WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTransactionById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM transactions WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllTransactions(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}