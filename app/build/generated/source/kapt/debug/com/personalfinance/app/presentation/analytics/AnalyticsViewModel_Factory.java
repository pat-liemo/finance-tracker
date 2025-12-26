package com.personalfinance.app.presentation.analytics;

import com.personalfinance.app.domain.repository.AnalyticsRepository;
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
public final class AnalyticsViewModel_Factory implements Factory<AnalyticsViewModel> {
  private final Provider<AnalyticsRepository> analyticsRepositoryProvider;

  public AnalyticsViewModel_Factory(Provider<AnalyticsRepository> analyticsRepositoryProvider) {
    this.analyticsRepositoryProvider = analyticsRepositoryProvider;
  }

  @Override
  public AnalyticsViewModel get() {
    return newInstance(analyticsRepositoryProvider.get());
  }

  public static AnalyticsViewModel_Factory create(
      Provider<AnalyticsRepository> analyticsRepositoryProvider) {
    return new AnalyticsViewModel_Factory(analyticsRepositoryProvider);
  }

  public static AnalyticsViewModel newInstance(AnalyticsRepository analyticsRepository) {
    return new AnalyticsViewModel(analyticsRepository);
  }
}
