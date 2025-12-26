package com.personalfinance.app.data.remote.sync;

import com.google.firebase.firestore.FirebaseFirestore;
import com.personalfinance.app.data.local.dao.BudgetDao;
import com.personalfinance.app.data.local.dao.CategoryDao;
import com.personalfinance.app.data.local.dao.TransactionDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class FirestoreSyncService_Factory implements Factory<FirestoreSyncService> {
  private final Provider<FirebaseFirestore> firestoreProvider;

  private final Provider<TransactionDao> transactionDaoProvider;

  private final Provider<BudgetDao> budgetDaoProvider;

  private final Provider<CategoryDao> categoryDaoProvider;

  public FirestoreSyncService_Factory(Provider<FirebaseFirestore> firestoreProvider,
      Provider<TransactionDao> transactionDaoProvider, Provider<BudgetDao> budgetDaoProvider,
      Provider<CategoryDao> categoryDaoProvider) {
    this.firestoreProvider = firestoreProvider;
    this.transactionDaoProvider = transactionDaoProvider;
    this.budgetDaoProvider = budgetDaoProvider;
    this.categoryDaoProvider = categoryDaoProvider;
  }

  @Override
  public FirestoreSyncService get() {
    return newInstance(firestoreProvider.get(), transactionDaoProvider.get(), budgetDaoProvider.get(), categoryDaoProvider.get());
  }

  public static FirestoreSyncService_Factory create(Provider<FirebaseFirestore> firestoreProvider,
      Provider<TransactionDao> transactionDaoProvider, Provider<BudgetDao> budgetDaoProvider,
      Provider<CategoryDao> categoryDaoProvider) {
    return new FirestoreSyncService_Factory(firestoreProvider, transactionDaoProvider, budgetDaoProvider, categoryDaoProvider);
  }

  public static FirestoreSyncService newInstance(FirebaseFirestore firestore,
      TransactionDao transactionDao, BudgetDao budgetDao, CategoryDao categoryDao) {
    return new FirestoreSyncService(firestore, transactionDao, budgetDao, categoryDao);
  }
}
