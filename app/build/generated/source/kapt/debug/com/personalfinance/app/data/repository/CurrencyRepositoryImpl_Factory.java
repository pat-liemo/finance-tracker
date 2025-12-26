package com.personalfinance.app.data.repository;

import com.personalfinance.app.data.remote.api.CurrencyApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class CurrencyRepositoryImpl_Factory implements Factory<CurrencyRepositoryImpl> {
  private final Provider<CurrencyApiService> currencyApiServiceProvider;

  public CurrencyRepositoryImpl_Factory(Provider<CurrencyApiService> currencyApiServiceProvider) {
    this.currencyApiServiceProvider = currencyApiServiceProvider;
  }

  @Override
  public CurrencyRepositoryImpl get() {
    return newInstance(currencyApiServiceProvider.get());
  }

  public static CurrencyRepositoryImpl_Factory create(
      Provider<CurrencyApiService> currencyApiServiceProvider) {
    return new CurrencyRepositoryImpl_Factory(currencyApiServiceProvider);
  }

  public static CurrencyRepositoryImpl newInstance(CurrencyApiService currencyApiService) {
    return new CurrencyRepositoryImpl(currencyApiService);
  }
}
