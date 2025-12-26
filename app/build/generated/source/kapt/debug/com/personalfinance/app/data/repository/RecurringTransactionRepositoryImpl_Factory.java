package com.personalfinance.app.data.repository;

import com.personalfinance.app.data.local.dao.TransactionDao;
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
public final class RecurringTransactionRepositoryImpl_Factory implements Factory<RecurringTransactionRepositoryImpl> {
  private final Provider<TransactionDao> transactionDaoProvider;

  private final Provider<TransactionRepository> transactionRepositoryProvider;

  public RecurringTransactionRepositoryImpl_Factory(Provider<TransactionDao> transactionDaoProvider,
      Provider<TransactionRepository> transactionRepositoryProvider) {
    this.transactionDaoProvider = transactionDaoProvider;
    this.transactionRepositoryProvider = transactionRepositoryProvider;
  }

  @Override
  public RecurringTransactionRepositoryImpl get() {
    return newInstance(transactionDaoProvider.get(), transactionRepositoryProvider.get());
  }

  public static RecurringTransactionRepositoryImpl_Factory create(
      Provider<TransactionDao> transactionDaoProvider,
      Provider<TransactionRepository> transactionRepositoryProvider) {
    return new RecurringTransactionRepositoryImpl_Factory(transactionDaoProvider, transactionRepositoryProvider);
  }

  public static RecurringTransactionRepositoryImpl newInstance(TransactionDao transactionDao,
      TransactionRepository transactionRepository) {
    return new RecurringTransactionRepositoryImpl(transactionDao, transactionRepository);
  }
}
