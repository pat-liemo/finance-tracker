package com.personalfinance.app.data.repository;

import com.personalfinance.app.data.local.dao.BudgetDao;
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
public final class AnalyticsRepositoryImpl_Factory implements Factory<AnalyticsRepositoryImpl> {
  private final Provider<TransactionDao> transactionDaoProvider;

  private final Provider<CategoryDao> categoryDaoProvider;

  private final Provider<BudgetDao> budgetDaoProvider;

  public AnalyticsRepositoryImpl_Factory(Provider<TransactionDao> transactionDaoProvider,
      Provider<CategoryDao> categoryDaoProvider, Provider<BudgetDao> budgetDaoProvider) {
    this.transactionDaoProvider = transactionDaoProvider;
    this.categoryDaoProvider = categoryDaoProvider;
    this.budgetDaoProvider = budgetDaoProvider;
  }

  @Override
  public AnalyticsRepositoryImpl get() {
    return newInstance(transactionDaoProvider.get(), categoryDaoProvider.get(), budgetDaoProvider.get());
  }

  public static AnalyticsRepositoryImpl_Factory create(
      Provider<TransactionDao> transactionDaoProvider, Provider<CategoryDao> categoryDaoProvider,
      Provider<BudgetDao> budgetDaoProvider) {
    return new AnalyticsRepositoryImpl_Factory(transactionDaoProvider, categoryDaoProvider, budgetDaoProvider);
  }

  public static AnalyticsRepositoryImpl newInstance(TransactionDao transactionDao,
      CategoryDao categoryDao, BudgetDao budgetDao) {
    return new AnalyticsRepositoryImpl(transactionDao, categoryDao, budgetDao);
  }
}
