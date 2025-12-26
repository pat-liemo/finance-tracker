package com.personalfinance.app.data.repository;

import com.personalfinance.app.data.local.dao.TransactionDao;
import com.personalfinance.app.data.local.entity.TransactionEntity;
import com.personalfinance.app.domain.model.Transaction;
import com.personalfinance.app.domain.model.TransactionFilter;
import com.personalfinance.app.domain.repository.TransactionRepository;
import kotlinx.coroutines.flow.Flow;
import kotlinx.datetime.LocalDateTime;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\u0010J\"\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@\u00a2\u0006\u0002\u0010\u0017J\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00140\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@\u00a2\u0006\u0002\u0010\u001bJ*\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00140\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0096@\u00a2\u0006\u0002\u0010 J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\u0006H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\"\u0010#J$\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b%\u0010\u000bJ\f\u0010&\u001a\u00020\'*\u00020\u0016H\u0002J\f\u0010(\u001a\u00020\t*\u00020)H\u0002J\f\u0010*\u001a\u00020)*\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006+"}, d2 = {"Lcom/personalfinance/app/data/repository/TransactionRepositoryImpl;", "Lcom/personalfinance/app/domain/repository/TransactionRepository;", "transactionDao", "Lcom/personalfinance/app/data/local/dao/TransactionDao;", "(Lcom/personalfinance/app/data/local/dao/TransactionDao;)V", "addTransaction", "Lkotlin/Result;", "", "transaction", "Lcom/personalfinance/app/domain/model/Transaction;", "addTransaction-gIAlu-s", "(Lcom/personalfinance/app/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTransaction", "", "id", "deleteTransaction-gIAlu-s", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransactionById", "getTransactions", "Lkotlinx/coroutines/flow/Flow;", "", "filter", "Lcom/personalfinance/app/domain/model/TransactionFilter;", "(Lcom/personalfinance/app/domain/model/TransactionFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransactionsByCategory", "categoryId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransactionsByDateRange", "startDate", "Lkotlinx/datetime/LocalDateTime;", "endDate", "(Lkotlinx/datetime/LocalDateTime;Lkotlinx/datetime/LocalDateTime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncTransactions", "syncTransactions-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTransaction", "updateTransaction-gIAlu-s", "isEmpty", "", "toDomain", "Lcom/personalfinance/app/data/local/entity/TransactionEntity;", "toEntity", "app_debug"})
public final class TransactionRepositoryImpl implements com.personalfinance.app.domain.repository.TransactionRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.TransactionDao transactionDao = null;
    
    @javax.inject.Inject()
    public TransactionRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.TransactionDao transactionDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTransactions(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.TransactionFilter filter, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Transaction>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTransactionById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.domain.model.Transaction> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTransactionsByDateRange(@org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime startDate, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Transaction>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTransactionsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Transaction>>> $completion) {
        return null;
    }
    
    private final com.personalfinance.app.data.local.entity.TransactionEntity toEntity(com.personalfinance.app.domain.model.Transaction $this$toEntity) {
        return null;
    }
    
    private final com.personalfinance.app.domain.model.Transaction toDomain(com.personalfinance.app.data.local.entity.TransactionEntity $this$toDomain) {
        return null;
    }
    
    private final boolean isEmpty(com.personalfinance.app.domain.model.TransactionFilter $this$isEmpty) {
        return false;
    }
}