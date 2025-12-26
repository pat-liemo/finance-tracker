package com.personalfinance.app.data.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.personalfinance.app.data.local.dao.UserDao;
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
public final class AuthRepositoryImpl_Factory implements Factory<AuthRepositoryImpl> {
  private final Provider<FirebaseAuth> firebaseAuthProvider;

  private final Provider<UserDao> userDaoProvider;

  public AuthRepositoryImpl_Factory(Provider<FirebaseAuth> firebaseAuthProvider,
      Provider<UserDao> userDaoProvider) {
    this.firebaseAuthProvider = firebaseAuthProvider;
    this.userDaoProvider = userDaoProvider;
  }

  @Override
  public AuthRepositoryImpl get() {
    return newInstance(firebaseAuthProvider.get(), userDaoProvider.get());
  }

  public static AuthRepositoryImpl_Factory create(Provider<FirebaseAuth> firebaseAuthProvider,
      Provider<UserDao> userDaoProvider) {
    return new AuthRepositoryImpl_Factory(firebaseAuthProvider, userDaoProvider);
  }

  public static AuthRepositoryImpl newInstance(FirebaseAuth firebaseAuth, UserDao userDao) {
    return new AuthRepositoryImpl(firebaseAuth, userDao);
  }
}
