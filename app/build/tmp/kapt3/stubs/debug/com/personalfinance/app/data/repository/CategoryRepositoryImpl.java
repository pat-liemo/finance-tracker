package com.personalfinance.app.data.repository;

import com.personalfinance.app.data.local.dao.CategoryDao;
import com.personalfinance.app.data.local.entity.CategoryEntity;
import com.personalfinance.app.domain.model.Category;
import com.personalfinance.app.domain.model.DefaultCategories;
import com.personalfinance.app.domain.repository.CategoryRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00140\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010\u0011J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0006H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0019\u0010\u0015J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u000bJ\f\u0010\u001c\u001a\u00020\t*\u00020\u001dH\u0002J\f\u0010\u001e\u001a\u00020\u001d*\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001f"}, d2 = {"Lcom/personalfinance/app/data/repository/CategoryRepositoryImpl;", "Lcom/personalfinance/app/domain/repository/CategoryRepository;", "categoryDao", "Lcom/personalfinance/app/data/local/dao/CategoryDao;", "(Lcom/personalfinance/app/data/local/dao/CategoryDao;)V", "createCategory", "Lkotlin/Result;", "", "category", "Lcom/personalfinance/app/domain/model/Category;", "createCategory-gIAlu-s", "(Lcom/personalfinance/app/domain/model/Category;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCategory", "", "id", "", "deleteCategory-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategories", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategoryById", "getDefaultCategories", "initializeDefaultCategories", "initializeDefaultCategories-IoAF18A", "updateCategory", "updateCategory-gIAlu-s", "toDomain", "Lcom/personalfinance/app/data/local/entity/CategoryEntity;", "toEntity", "app_debug"})
public final class CategoryRepositoryImpl implements com.personalfinance.app.domain.repository.CategoryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.local.dao.CategoryDao categoryDao = null;
    
    @javax.inject.Inject()
    public CategoryRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.local.dao.CategoryDao categoryDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.personalfinance.app.domain.model.Category>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCategoryById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.personalfinance.app.domain.model.Category> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getDefaultCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.personalfinance.app.domain.model.Category>> $completion) {
        return null;
    }
    
    private final com.personalfinance.app.data.local.entity.CategoryEntity toEntity(com.personalfinance.app.domain.model.Category $this$toEntity) {
        return null;
    }
    
    private final com.personalfinance.app.domain.model.Category toDomain(com.personalfinance.app.data.local.entity.CategoryEntity $this$toDomain) {
        return null;
    }
}