package com.personalfinance.app.data.local.dao;

import androidx.room.*;
import com.personalfinance.app.data.local.entity.CategoryEntity;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u0015\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/personalfinance/app/data/local/dao/CategoryDao;", "", "deleteAllCategories", "", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCategory", "category", "Lcom/personalfinance/app/data/local/entity/CategoryEntity;", "(Lcom/personalfinance/app/data/local/entity/CategoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCategoryById", "id", "getAllCategories", "Lkotlinx/coroutines/flow/Flow;", "", "getCategoryById", "getDefaultCategories", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserCategories", "insertCategory", "updateCategory", "app_debug"})
@androidx.room.Dao()
public abstract interface CategoryDao {
    
    @androidx.room.Query(value = "SELECT * FROM categories WHERE userId = :userId OR isDefault = 1 ORDER BY name ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.CategoryEntity>> getAllCategories(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Query(value = "SELECT * FROM categories WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCategoryById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.data.local.entity.CategoryEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM categories WHERE isDefault = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDefaultCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.personalfinance.app.data.local.entity.CategoryEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM categories WHERE userId = :userId AND isDefault = 0")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.personalfinance.app.data.local.entity.CategoryEntity>> getUserCategories(@org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertCategory(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.CategoryEntity category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateCategory(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.CategoryEntity category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteCategory(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.entity.CategoryEntity category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM categories WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteCategoryById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM categories WHERE userId = :userId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllCategories(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}