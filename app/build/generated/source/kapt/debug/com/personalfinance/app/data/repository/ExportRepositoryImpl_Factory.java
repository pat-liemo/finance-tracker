package com.personalfinance.app.data.repository;

import com.personalfinance.app.data.local.dao.CategoryDao;
import com.personalfinance.app.data.local.dao.TransactionDao;
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
public final class ExportRepositoryImpl_Factory implements Factory<ExportRepositoryImpl> {
  private final Provider<TransactionDao> transactionDaoProvider;

  private final Provider<CategoryDao> categoryDaoProvider;

  public ExportRepositoryImpl_Factory(Provider<TransactionDao> transactionDaoProvider,
      Provider<CategoryDao> categoryDaoProvider) {
    this.transactionDaoProvider = transactionDaoProvider;
    this.categoryDaoProvider = categoryDaoProvider;
  }

  @Override
  public ExportRepositoryImpl get() {
    return newInstance(transactionDaoProvider.get(), categoryDaoProvider.get());
  }

  public static ExportRepositoryImpl_Factory create(Provider<TransactionDao> transactionDaoProvider,
      Provider<CategoryDao> categoryDaoProvider) {
    return new ExportRepositoryImpl_Factory(transactionDaoProvider, categoryDaoProvider);
  }

  public static ExportRepositoryImpl newInstance(TransactionDao transactionDao,
      CategoryDao categoryDao) {
    return new ExportRepositoryImpl(transactionDao, categoryDao);
  }
}
