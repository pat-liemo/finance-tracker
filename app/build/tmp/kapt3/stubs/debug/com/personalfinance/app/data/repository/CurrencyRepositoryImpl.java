package com.personalfinance.app.data.repository;

import com.personalfinance.app.data.remote.api.CurrencyApiService;
import com.personalfinance.app.domain.model.CurrencyConversion;
import com.personalfinance.app.domain.model.ExchangeRate;
import com.personalfinance.app.domain.repository.CurrencyRepository;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J4\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0096@\u00a2\u0006\u0002\u0010\u0012J*\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00062\u0006\u0010\u0014\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0019\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001a"}, d2 = {"Lcom/personalfinance/app/data/repository/CurrencyRepositoryImpl;", "Lcom/personalfinance/app/domain/repository/CurrencyRepository;", "currencyApiService", "Lcom/personalfinance/app/data/remote/api/CurrencyApiService;", "(Lcom/personalfinance/app/data/remote/api/CurrencyApiService;)V", "convertCurrency", "Lkotlin/Result;", "Lcom/personalfinance/app/domain/model/CurrencyConversion;", "amount", "", "fromCurrency", "", "toCurrency", "convertCurrency-BWLJW6A", "(DLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedRates", "", "Lcom/personalfinance/app/domain/model/ExchangeRate;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExchangeRates", "baseCurrency", "getExchangeRates-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateExchangeRates", "", "updateExchangeRates-IoAF18A", "app_debug"})
public final class CurrencyRepositoryImpl implements com.personalfinance.app.domain.repository.CurrencyRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.remote.api.CurrencyApiService currencyApiService = null;
    
    @javax.inject.Inject()
    public CurrencyRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.remote.api.CurrencyApiService currencyApiService) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCachedRates(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.personalfinance.app.domain.model.ExchangeRate>> $completion) {
        return null;
    }
}