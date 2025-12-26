package com.personalfinance.app.data.remote.storage;

import com.google.firebase.storage.FirebaseStorage;
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
public final class FirebaseStorageService_Factory implements Factory<FirebaseStorageService> {
  private final Provider<FirebaseStorage> storageProvider;

  public FirebaseStorageService_Factory(Provider<FirebaseStorage> storageProvider) {
    this.storageProvider = storageProvider;
  }

  @Override
  public FirebaseStorageService get() {
    return newInstance(storageProvider.get());
  }

  public static FirebaseStorageService_Factory create(Provider<FirebaseStorage> storageProvider) {
    return new FirebaseStorageService_Factory(storageProvider);
  }

  public static FirebaseStorageService newInstance(FirebaseStorage storage) {
    return new FirebaseStorageService(storage);
  }
}
