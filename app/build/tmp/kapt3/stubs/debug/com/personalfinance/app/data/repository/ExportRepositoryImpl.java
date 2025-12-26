package com.personalfinance.app.data.repository;

import com.personalfinance.app.data.local.dao.TransactionDao;
import com.personalfinance.app.data.local.dao.CategoryDao;
import com.personalfinance.app.domain.model.DateRange;
import com.personalfinance.app.domain.repository.ExportRepository;
import kotlinx.datetime.TimeZone;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0011J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0016"}, d2 = {"Lcom/personalfinance/app/data/repository/ExportRepositoryImpl;", "Lcom/personalfinance/app/domain/repository/ExportRepository;", "transactionDao", "Lcom/personalfinance/app/data/local/dao/TransactionDao;", "categoryDao", "Lcom/personalfinance/app/data/local/dao/CategoryDao;", "(Lcom/personalfinance/app/data/local/dao/TransactionDao;Lcom/personalfinance/app/data/local/dao/CategoryDao;)V", "exportAnalyticsReport", "Lkotlin/Result;", "", "dateRange", "Lcom/personalfinance/app/domain/model/DateRange;", "format", "exportAnalyticsReport-0E7RQCE", "(Lcom/personalfinance/app/domain/model/DateRange;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportTransactionsToCSV", "exportTransactionsToCSV-gIAlu-s", "(Lcom/personalfinance/app/domain/model/DateRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportTransactionsToExcel", "exportTransactionsToExcel-gIAlu-s", "exportTransactionsToPDF", "exportTransactionsToPDF-gIAlu-s", "app_debug"})
public final class ExportRepositoryImpl implements com.personalfinance.app.domain.repository.ExportRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.TransactionDao transactionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.CategoryDao categoryDao = null;
    
    @javax.inject.Inject()
    public ExportRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.TransactionDao transactionDao, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.CategoryDao categoryDao) {
        super();
    }
}