package com.personalfinance.app.di;

import com.personalfinance.app.data.local.dao.DebtDao;
import com.personalfinance.app.data.local.database.PersonalFinanceDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideDebtDaoFactory implements Factory<DebtDao> {
  private final Provider<PersonalFinanceDatabase> databaseProvider;

  public DatabaseModule_ProvideDebtDaoFactory(Provider<PersonalFinanceDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public DebtDao get() {
    return provideDebtDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideDebtDaoFactory create(
      Provider<PersonalFinanceDatabase> databaseProvider) {
    return new DatabaseModule_ProvideDebtDaoFactory(databaseProvider);
  }

  public static DebtDao provideDebtDao(PersonalFinanceDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideDebtDao(database));
  }
}
