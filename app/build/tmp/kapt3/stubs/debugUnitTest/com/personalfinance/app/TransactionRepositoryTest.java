package com.personalfinance.app;

import com.personalfinance.app.data.local.dao.TransactionDao;
import com.personalfinance.app.data.local.entity.TransactionEntity;
import com.personalfinance.app.data.repository.TransactionRepositoryImpl;
import com.personalfinance.app.domain.model.*;
import kotlinx.datetime.LocalDateTime;
import org.junit.Test;
import org.mockito.kotlin.*;

/**
 * Unit tests for TransactionRepository implementation
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0007J\n\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0007J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00140\u0013H\u0007J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00140\u0013H\u0007J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00140\u0013H\u0007J\b\u0010\u0017\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/personalfinance/app/TransactionRepositoryTest;", "", "()V", "mockDao", "Lcom/personalfinance/app/data/local/dao/TransactionDao;", "repository", "Lcom/personalfinance/app/data/repository/TransactionRepositoryImpl;", "addTransaction should insert transaction and return id", "", "createSampleTransaction", "Lcom/personalfinance/app/domain/model/Transaction;", "id", "createSampleTransactionEntity", "Lcom/personalfinance/app/data/local/entity/TransactionEntity;", "deleteTransaction should call dao delete", "", "getTransactionById should return null when not found", "getTransactionById should return transaction when found", "getTransactions with category filter should use category query", "Lkotlinx/coroutines/flow/Flow;", "", "getTransactions with date range filter should use date range query", "getTransactions with empty filter should return all transactions", "updateTransaction should call dao update", "app_debugUnitTest"})
public final class TransactionRepositoryTest {
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.TransactionDao mockDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.repository.TransactionRepositoryImpl repository = null;
    
    public TransactionRepositoryTest() {
        super();
    }
    
    private final com.personalfinance.app.domain.model.Transaction createSampleTransaction(long id) {
        return null;
    }
    
    private final com.personalfinance.app.data.local.entity.TransactionEntity createSampleTransactionEntity(long id) {
        return null;
    }
}