package com.personalfinance.app;

import com.personalfinance.app.domain.model.User;
import com.personalfinance.app.domain.repository.AuthRepository;
import kotlinx.coroutines.flow.Flow;
import java.util.UUID;

/**
 * Fake implementation of AuthRepository for testing purposes.
 * Simulates authentication behavior without Firebase dependencies.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0096@\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\bJ\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\bH\u0002J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0017\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b!\u0010\u0010J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b#\u0010\u0010J,\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b%\u0010\u001fJ0\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\u0010\'\u001a\u0004\u0018\u00010\b2\b\u0010(\u001a\u0004\u0018\u00010\bH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b)\u0010\u001fR\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006+"}, d2 = {"Lcom/personalfinance/app/FakeAuthRepository;", "Lcom/personalfinance/app/domain/repository/AuthRepository;", "()V", "_currentUser", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/personalfinance/app/domain/model/User;", "users", "", "", "Lcom/personalfinance/app/FakeAuthRepository$StoredUser;", "clearAllUsers", "", "enableBiometricAuth", "Lkotlin/Result;", "", "enableBiometricAuth-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUser", "getCurrentUserFlow", "Lkotlinx/coroutines/flow/Flow;", "getUserCount", "", "hasUser", "email", "isValidEmail", "sendPasswordResetEmail", "sendPasswordResetEmail-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signInWithEmail", "password", "signInWithEmail-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signInWithGoogle", "signInWithGoogle-IoAF18A", "signOut", "signOut-IoAF18A", "signUp", "signUp-0E7RQCE", "updateProfile", "displayName", "photoUrl", "updateProfile-0E7RQCE", "StoredUser", "app_debugUnitTest"})
public final class FakeAuthRepository implements com.personalfinance.app.domain.repository.AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, com.personalfinance.app.FakeAuthRepository.StoredUser> users = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.personalfinance.app.domain.model.User> _currentUser = null;
    
    public FakeAuthRepository() {
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
    
    public final void clearAllUsers() {
    }
    
    public final int getUserCount() {
        return 0;
    }
    
    public final boolean hasUser(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/personalfinance/app/FakeAuthRepository$StoredUser;", "", "email", "", "password", "user", "Lcom/personalfinance/app/domain/model/User;", "(Ljava/lang/String;Ljava/lang/String;Lcom/personalfinance/app/domain/model/User;)V", "getEmail", "()Ljava/lang/String;", "getPassword", "getUser", "()Lcom/personalfinance/app/domain/model/User;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debugUnitTest"})
    public static final class StoredUser {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String email = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String password = null;
        @org.jetbrains.annotations.NotNull()
        private final com.personalfinance.app.domain.model.User user = null;
        
        public StoredUser(@org.jetbrains.annotations.NotNull()
        java.lang.String email, @org.jetbrains.annotations.NotNull()
        java.lang.String password, @org.jetbrains.annotations.NotNull()
        com.personalfinance.app.domain.model.User user) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEmail() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPassword() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.personalfinance.app.domain.model.User getUser() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.personalfinance.app.domain.model.User component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.personalfinance.app.FakeAuthRepository.StoredUser copy(@org.jetbrains.annotations.NotNull()
        java.lang.String email, @org.jetbrains.annotations.NotNull()
        java.lang.String password, @org.jetbrains.annotations.NotNull()
        com.personalfinance.app.domain.model.User user) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}