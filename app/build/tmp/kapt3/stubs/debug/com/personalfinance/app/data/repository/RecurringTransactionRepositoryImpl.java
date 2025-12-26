package com.personalfinance.app.data.repository;

import com.personalfinance.app.data.local.dao.TransactionDao;
import com.personalfinance.app.data.local.entity.TransactionEntity;
import com.personalfinance.app.domain.model.RecurringFrequency;
import com.personalfinance.app.domain.model.Transaction;
import com.personalfinance.app.domain.repository.RecurringTransactionRepository;
import com.personalfinance.app.domain.repository.TransactionRepository;
import kotlinx.coroutines.flow.Flow;
import kotlinx.datetime.Clock;
import kotlinx.datetime.DatePeriod;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0002J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0006\u0010\u0013\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0017H\u0096@\u00a2\u0006\u0002\u0010\u0018J\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00170\u001aH\u0096@\u00a2\u0006\u0002\u0010\u0018J\"\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00170\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001c\u0010\u0018J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u0010J\f\u0010\u001f\u001a\u00020\n*\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006!"}, d2 = {"Lcom/personalfinance/app/data/repository/RecurringTransactionRepositoryImpl;", "Lcom/personalfinance/app/domain/repository/RecurringTransactionRepository;", "transactionDao", "Lcom/personalfinance/app/data/local/dao/TransactionDao;", "transactionRepository", "Lcom/personalfinance/app/domain/repository/TransactionRepository;", "(Lcom/personalfinance/app/data/local/dao/TransactionDao;Lcom/personalfinance/app/domain/repository/TransactionRepository;)V", "calculateNextDueDate", "Lkotlinx/datetime/LocalDateTime;", "transaction", "Lcom/personalfinance/app/domain/model/Transaction;", "fromDate", "createRecurringTransaction", "Lkotlin/Result;", "", "createRecurringTransaction-gIAlu-s", "(Lcom/personalfinance/app/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecurringTransaction", "", "id", "deleteRecurringTransaction-gIAlu-s", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNextDueTransactions", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecurringTransactions", "Lkotlinx/coroutines/flow/Flow;", "processRecurringTransactions", "processRecurringTransactions-IoAF18A", "updateRecurringTransaction", "updateRecurringTransaction-gIAlu-s", "toDomain", "Lcom/personalfinance/app/data/local/entity/TransactionEntity;", "app_debug"})
public final class RecurringTransactionRepositoryImpl implements com.personalfinance.app.domain.repository.RecurringTransactionRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.TransactionDao transactionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.domain.repository.TransactionRepository transactionRepository = null;
    
    @javax.inject.Inject()
    public RecurringTransactionRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.TransactionDao transactionDao, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.repository.TransactionRepository transactionRepository) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getRecurringTransactions(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Transaction>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getNextDueTransactions(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.personalfinance.app.domain.model.Transaction>> $completion) {
        return null;
    }
    
    private final kotlinx.datetime.LocalDateTime calculateNextDueDate(com.personalfinance.app.domain.model.Transaction transaction, kotlinx.datetime.LocalDateTime fromDate) {
        return null;
    }
    
    private final com.personalfinance.app.domain.model.Transaction toDomain(com.personalfinance.app.data.local.entity.TransactionEntity $this$toDomain) {
        return null;
    }
}