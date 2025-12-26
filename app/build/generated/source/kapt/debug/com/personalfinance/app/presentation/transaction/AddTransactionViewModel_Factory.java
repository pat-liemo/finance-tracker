package com.personalfinance.app.presentation.transaction;

import com.personalfinance.app.domain.repository.AuthRepository;
import com.personalfinance.app.domain.repository.CategoryRepository;
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
public final class AddTransactionViewModel_Factory implements Factory<AddTransactionViewModel> {
  private final Provider<TransactionRepository> transactionRepositoryProvider;

  private final Provider<CategoryRepository> categoryRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public AddTransactionViewModel_Factory(
      Provider<TransactionRepository> transactionRepositoryProvider,
      Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.transactionRepositoryProvider = transactionRepositoryProvider;
    this.categoryRepositoryProvider = categoryRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public AddTransactionViewModel get() {
    return newInstance(transactionRepositoryProvider.get(), categoryRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static AddTransactionViewModel_Factory create(
      Provider<TransactionRepository> transactionRepositoryProvider,
      Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new AddTransactionViewModel_Factory(transactionRepositoryProvider, categoryRepositoryProvider, authRepositoryProvider);
  }

  public static AddTransactionViewModel newInstance(TransactionRepository transactionRepository,
      CategoryRepository categoryRepository, AuthRepository authRepository) {
    return new AddTransactionViewModel(transactionRepository, categoryRepository, authRepository);
  }
}
