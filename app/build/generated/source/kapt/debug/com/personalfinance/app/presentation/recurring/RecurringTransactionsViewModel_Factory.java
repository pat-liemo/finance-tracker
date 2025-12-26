package com.personalfinance.app.presentation.recurring;

import com.personalfinance.app.domain.repository.RecurringTransactionRepository;
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
public final class RecurringTransactionsViewModel_Factory implements Factory<RecurringTransactionsViewModel> {
  private final Provider<RecurringTransactionRepository> recurringTransactionRepositoryProvider;

  public RecurringTransactionsViewModel_Factory(
      Provider<RecurringTransactionRepository> recurringTransactionRepositoryProvider) {
    this.recurringTransactionRepositoryProvider = recurringTransactionRepositoryProvider;
  }

  @Override
  public RecurringTransactionsViewModel get() {
    return newInstance(recurringTransactionRepositoryProvider.get());
  }

  public static RecurringTransactionsViewModel_Factory create(
      Provider<RecurringTransactionRepository> recurringTransactionRepositoryProvider) {
    return new RecurringTransactionsViewModel_Factory(recurringTransactionRepositoryProvider);
  }

  public static RecurringTransactionsViewModel newInstance(
      RecurringTransactionRepository recurringTransactionRepository) {
    return new RecurringTransactionsViewModel(recurringTransactionRepository);
  }
}
