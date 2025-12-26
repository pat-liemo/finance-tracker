package com.personalfinance.app.data.remote.sync;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;
import com.personalfinance.app.data.local.dao.TransactionDao;
import com.personalfinance.app.data.local.dao.BudgetDao;
import com.personalfinance.app.data.local.dao.CategoryDao;
import com.personalfinance.app.data.local.entity.TransactionEntity;
import com.personalfinance.app.data.local.entity.BudgetEntity;
import com.personalfinance.app.data.local.entity.CategoryEntity;
import com.personalfinance.app.domain.model.SyncStatus;
import kotlinx.coroutines.Dispatchers;
import kotlinx.datetime.Clock;
import kotlinx.datetime.TimeZone;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0010J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@\u00a2\u0006\u0002\u0010\u0015J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001a\u0010\u0015J\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001dH\u0002J\f\u0010\u001e\u001a\u00020\u001f*\u00020\u001dH\u0002J\u0018\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010!*\u00020\u001cH\u0002J\u0018\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010!*\u00020\u001fH\u0002J\u0018\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010!*\u00020\"H\u0002J\f\u0010#\u001a\u00020\"*\u00020\u001dH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006$"}, d2 = {"Lcom/personalfinance/app/data/remote/sync/FirestoreSyncService;", "", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "transactionDao", "Lcom/personalfinance/app/data/local/dao/TransactionDao;", "budgetDao", "Lcom/personalfinance/app/data/local/dao/BudgetDao;", "categoryDao", "Lcom/personalfinance/app/data/local/dao/CategoryDao;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/personalfinance/app/data/local/dao/TransactionDao;Lcom/personalfinance/app/data/local/dao/BudgetDao;Lcom/personalfinance/app/data/local/dao/CategoryDao;)V", "budgetListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "categoryListener", "transactionListener", "startRealtimeSync", "", "userId", "", "stopRealtimeSync", "syncBudgets", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncCategories", "syncTransactions", "syncUserData", "Lkotlin/Result;", "syncUserData-gIAlu-s", "toBudgetEntity", "Lcom/personalfinance/app/data/local/entity/BudgetEntity;", "Lcom/google/firebase/firestore/DocumentSnapshot;", "toCategoryEntity", "Lcom/personalfinance/app/data/local/entity/CategoryEntity;", "toFirestoreMap", "", "Lcom/personalfinance/app/data/local/entity/TransactionEntity;", "toTransactionEntity", "app_debug"})
public final class FirestoreSyncService {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.TransactionDao transactionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.BudgetDao budgetDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.CategoryDao categoryDao = null;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.firestore.ListenerRegistration transactionListener;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.firestore.ListenerRegistration budgetListener;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.firestore.ListenerRegistration categoryListener;
    
    @javax.inject.Inject()
    public FirestoreSyncService(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore firestore, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.TransactionDao transactionDao, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.BudgetDao budgetDao, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.CategoryDao categoryDao) {
        super();
    }
    
    private final java.lang.Object syncTransactions(java.lang.String userId, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object syncBudgets(java.lang.String userId, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object syncCategories(java.lang.String userId, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void startRealtimeSync(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
    }
    
    public final void stopRealtimeSync() {
    }
    
    private final java.util.Map<java.lang.String, java.lang.Object> toFirestoreMap(com.personalfinance.app.data.local.entity.TransactionEntity $this$toFirestoreMap) {
        return null;
    }
    
    private final com.personalfinance.app.data.local.entity.TransactionEntity toTransactionEntity(com.google.firebase.firestore.DocumentSnapshot $this$toTransactionEntity) {
        return null;
    }
    
    private final java.util.Map<java.lang.String, java.lang.Object> toFirestoreMap(com.personalfinance.app.data.local.entity.BudgetEntity $this$toFirestoreMap) {
        return null;
    }
    
    private final com.personalfinance.app.data.local.entity.BudgetEntity toBudgetEntity(com.google.firebase.firestore.DocumentSnapshot $this$toBudgetEntity) {
        return null;
    }
    
    private final java.util.Map<java.lang.String, java.lang.Object> toFirestoreMap(com.personalfinance.app.data.local.entity.CategoryEntity $this$toFirestoreMap) {
        return null;
    }
    
    private final com.personalfinance.app.data.local.entity.CategoryEntity toCategoryEntity(com.google.firebase.firestore.DocumentSnapshot $this$toCategoryEntity) {
        return null;
    }
}