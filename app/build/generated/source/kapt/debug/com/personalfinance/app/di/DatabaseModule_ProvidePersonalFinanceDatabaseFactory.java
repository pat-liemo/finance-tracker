package com.personalfinance.app.di;

import android.content.Context;
import com.personalfinance.app.data.local.database.PersonalFinanceDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DatabaseModule_ProvidePersonalFinanceDatabaseFactory implements Factory<PersonalFinanceDatabase> {
  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvidePersonalFinanceDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public PersonalFinanceDatabase get() {
    return providePersonalFinanceDatabase(contextProvider.get());
  }

  public static DatabaseModule_ProvidePersonalFinanceDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvidePersonalFinanceDatabaseFactory(contextProvider);
  }

  public static PersonalFinanceDatabase providePersonalFinanceDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.providePersonalFinanceDatabase(context));
  }
}
