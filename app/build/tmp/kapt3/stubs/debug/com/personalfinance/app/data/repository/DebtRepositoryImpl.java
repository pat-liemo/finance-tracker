package com.personalfinance.app.data.repository;

import com.personalfinance.app.data.local.dao.DebtDao;
import com.personalfinance.app.domain.model.Debt;
import com.personalfinance.app.domain.repository.DebtRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\u0010J\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00140\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00140\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0015J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001f"}, d2 = {"Lcom/personalfinance/app/data/repository/DebtRepositoryImpl;", "Lcom/personalfinance/app/domain/repository/DebtRepository;", "debtDao", "Lcom/personalfinance/app/data/local/dao/DebtDao;", "(Lcom/personalfinance/app/data/local/dao/DebtDao;)V", "addDebt", "Lkotlin/Result;", "", "debt", "Lcom/personalfinance/app/domain/model/Debt;", "addDebt-gIAlu-s", "(Lcom/personalfinance/app/domain/model/Debt;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDebt", "", "id", "deleteDebt-gIAlu-s", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDebtById", "getDebts", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUpcomingPayments", "makePayment", "debtId", "amount", "", "makePayment-0E7RQCE", "(JDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDebt", "updateDebt-gIAlu-s", "app_debug"})
public final class DebtRepositoryImpl implements com.personalfinance.app.domain.repository.DebtRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.DebtDao debtDao = null;
    
    @javax.inject.Inject()
    public DebtRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.DebtDao debtDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getDebts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Debt>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getDebtById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.domain.model.Debt> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getUpcomingPayments(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Debt>>> $completion) {
        return null;
    }
}