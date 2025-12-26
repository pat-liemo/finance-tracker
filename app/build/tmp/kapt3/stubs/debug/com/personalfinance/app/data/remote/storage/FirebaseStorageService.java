package com.personalfinance.app.data.remote.storage;

import android.net.Uri;
import com.google.firebase.storage.FirebaseStorage;
import java.io.File;
import java.util.*;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ4\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J4\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0018"}, d2 = {"Lcom/personalfinance/app/data/remote/storage/FirebaseStorageService;", "", "storage", "Lcom/google/firebase/storage/FirebaseStorage;", "(Lcom/google/firebase/storage/FirebaseStorage;)V", "getStorageUsage", "Lcom/personalfinance/app/data/remote/storage/StorageUsage;", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadExportedFile", "Lkotlin/Result;", "file", "Ljava/io/File;", "fileName", "uploadExportedFile-BWLJW6A", "(Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadReceipt", "imageUri", "Landroid/net/Uri;", "transactionId", "", "uploadReceipt-BWLJW6A", "(Ljava/lang/String;Landroid/net/Uri;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class FirebaseStorageService {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.storage.FirebaseStorage storage = null;
    
    @javax.inject.Inject()
    public FirebaseStorageService(@org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.FirebaseStorage storage) {
        super();
    }
    
    /**
     * Get storage usage information
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getStorageUsage(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.data.remote.storage.StorageUsage> $completion) {
        return null;
    }
}