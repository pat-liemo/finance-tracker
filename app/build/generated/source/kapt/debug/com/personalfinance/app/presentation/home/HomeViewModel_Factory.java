package com.personalfinance.app.presentation.home;

import com.personalfinance.app.domain.repository.TransactionRepository;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<TransactionRepository> transactionRepositoryProvider;

  public HomeViewModel_Factory(Provider<TransactionRepository> transactionRepositoryProvider) {
    this.transactionRepositoryProvider = transactionRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(transactionRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<TransactionRepository> transactionRepositoryProvider) {
    return new HomeViewModel_Factory(transactionRepositoryProvider);
  }

  public static HomeViewModel newInstance(TransactionRepository transactionRepository) {
    return new HomeViewModel(transactionRepository);
  }
}
