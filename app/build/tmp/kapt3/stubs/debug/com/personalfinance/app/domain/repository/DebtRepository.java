package com.personalfinance.app.domain.repository;

import com.personalfinance.app.domain.model.Debt;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\rJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u0010H\u00a6@\u00a2\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u0010H\u00a6@\u00a2\u0006\u0002\u0010\u0012J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001c"}, d2 = {"Lcom/personalfinance/app/domain/repository/DebtRepository;", "", "addDebt", "Lkotlin/Result;", "", "debt", "Lcom/personalfinance/app/domain/model/Debt;", "addDebt-gIAlu-s", "(Lcom/personalfinance/app/domain/model/Debt;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDebt", "", "id", "deleteDebt-gIAlu-s", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDebtById", "getDebts", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUpcomingPayments", "makePayment", "debtId", "amount", "", "makePayment-0E7RQCE", "(JDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDebt", "updateDebt-gIAlu-s", "app_debug"})
public abstract interface DebtRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDebts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Debt>>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDebtById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.domain.model.Debt> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUpcomingPayments(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Debt>>> $completion);
}