package com.personalfinance.app.domain.repository;

import com.personalfinance.app.domain.model.Transaction;
import com.personalfinance.app.domain.model.TransactionFilter;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\rJ\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u00a6@\u00a2\u0006\u0002\u0010\u0014J\"\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u00a6@\u00a2\u0006\u0002\u0010\u0018J*\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u00a6@\u00a2\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001f\u0010 J$\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\"\u0010\b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006#"}, d2 = {"Lcom/personalfinance/app/domain/repository/TransactionRepository;", "", "addTransaction", "Lkotlin/Result;", "", "transaction", "Lcom/personalfinance/app/domain/model/Transaction;", "addTransaction-gIAlu-s", "(Lcom/personalfinance/app/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTransaction", "", "id", "deleteTransaction-gIAlu-s", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransactionById", "getTransactions", "Lkotlinx/coroutines/flow/Flow;", "", "filter", "Lcom/personalfinance/app/domain/model/TransactionFilter;", "(Lcom/personalfinance/app/domain/model/TransactionFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransactionsByCategory", "categoryId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransactionsByDateRange", "startDate", "Lkotlinx/datetime/LocalDateTime;", "endDate", "(Lkotlinx/datetime/LocalDateTime;Lkotlinx/datetime/LocalDateTime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncTransactions", "syncTransactions-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTransaction", "updateTransaction-gIAlu-s", "app_debug"})
public abstract interface TransactionRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactions(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.TransactionFilter filter, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Transaction>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.domain.model.Transaction> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionsByDateRange(@org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime startDate, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Transaction>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Transaction>>> $completion);
}