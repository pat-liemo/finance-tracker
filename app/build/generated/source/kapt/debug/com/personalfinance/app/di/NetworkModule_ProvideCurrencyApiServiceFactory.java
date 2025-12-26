package com.personalfinance.app.di;

import com.personalfinance.app.data.remote.api.CurrencyApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class NetworkModule_ProvideCurrencyApiServiceFactory implements Factory<CurrencyApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideCurrencyApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public CurrencyApiService get() {
    return provideCurrencyApiService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideCurrencyApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideCurrencyApiServiceFactory(retrofitProvider);
  }

  public static CurrencyApiService provideCurrencyApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideCurrencyApiService(retrofit));
  }
}
