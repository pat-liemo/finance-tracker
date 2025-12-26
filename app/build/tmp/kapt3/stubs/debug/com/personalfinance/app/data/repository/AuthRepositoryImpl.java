package com.personalfinance.app.data.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.personalfinance.app.data.local.dao.UserDao;
import com.personalfinance.app.data.local.entity.UserEntity;
import com.personalfinance.app.domain.model.User;
import com.personalfinance.app.domain.repository.AuthRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0082@\u00a2\u0006\u0002\u0010\u0019J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\b2\u0006\u0010\u0015\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ,\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001f\u0010 J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\"\u0010\u000bJ\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b$\u0010\u000bJ,\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b&\u0010 J0\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00170\b2\b\u0010(\u001a\u0004\u0018\u00010\r2\b\u0010)\u001a\u0004\u0018\u00010\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b*\u0010 J\f\u0010+\u001a\u00020\u0011*\u00020,H\u0002J\f\u0010+\u001a\u00020\u0011*\u00020-H\u0002J\f\u0010.\u001a\u00020-*\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006/"}, d2 = {"Lcom/personalfinance/app/data/repository/AuthRepositoryImpl;", "Lcom/personalfinance/app/domain/repository/AuthRepository;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "userDao", "Lcom/personalfinance/app/data/local/dao/UserDao;", "(Lcom/google/firebase/auth/FirebaseAuth;Lcom/personalfinance/app/data/local/dao/UserDao;)V", "enableBiometricAuth", "Lkotlin/Result;", "", "enableBiometricAuth-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthErrorMessage", "", "exception", "Lcom/google/firebase/auth/FirebaseAuthException;", "getCurrentUser", "Lcom/personalfinance/app/domain/model/User;", "getCurrentUserFlow", "Lkotlinx/coroutines/flow/Flow;", "isValidEmail", "email", "saveUserLocally", "", "user", "(Lcom/personalfinance/app/domain/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPasswordResetEmail", "sendPasswordResetEmail-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signInWithEmail", "password", "signInWithEmail-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signInWithGoogle", "signInWithGoogle-IoAF18A", "signOut", "signOut-IoAF18A", "signUp", "signUp-0E7RQCE", "updateProfile", "displayName", "photoUrl", "updateProfile-0E7RQCE", "toDomainModel", "Lcom/google/firebase/auth/FirebaseUser;", "Lcom/personalfinance/app/data/local/entity/UserEntity;", "toEntity", "app_debug"})
public final class AuthRepositoryImpl implements com.personalfinance.app.domain.repository.AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth firebaseAuth = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.UserDao userDao = null;
    
    @javax.inject.Inject()
    public AuthRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth firebaseAuth, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.UserDao userDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.domain.model.User> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.personalfinance.app.domain.model.User> getCurrentUserFlow() {
        return null;
    }
    
    private final boolean isValidEmail(java.lang.String email) {
        return false;
    }
    
    private final java.lang.String getAuthErrorMessage(com.google.firebase.auth.FirebaseAuthException exception) {
        return null;
    }
    
    private final java.lang.Object saveUserLocally(com.personalfinance.app.domain.model.User user, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.personalfinance.app.domain.model.User toDomainModel(com.google.firebase.auth.FirebaseUser $this$toDomainModel) {
        return null;
    }
    
    private final com.personalfinance.app.data.local.entity.UserEntity toEntity(com.personalfinance.app.domain.model.User $this$toEntity) {
        return null;
    }
    
    private final com.personalfinance.app.domain.model.User toDomainModel(com.personalfinance.app.data.local.entity.UserEntity $this$toDomainModel) {
        return null;
    }
}