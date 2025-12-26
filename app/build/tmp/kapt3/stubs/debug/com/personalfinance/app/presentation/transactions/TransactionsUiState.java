package com.personalfinance.app.presentation.transactions;

import androidx.lifecycle.ViewModel;
import com.personalfinance.app.domain.model.Category;
import com.personalfinance.app.domain.model.Transaction;
import com.personalfinance.app.domain.model.TransactionFilter;
import com.personalfinance.app.domain.repository.CategoryRepository;
import com.personalfinance.app.domain.repository.TransactionRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000eH\u00c6\u0003Jc\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00c6\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001J\t\u0010&\u001a\u00020\u000eH\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0019\u00a8\u0006\'"}, d2 = {"Lcom/personalfinance/app/presentation/transactions/TransactionsUiState;", "", "isLoading", "", "allTransactions", "", "Lcom/personalfinance/app/domain/model/Transaction;", "filteredTransactions", "availableCategories", "Lcom/personalfinance/app/domain/model/Category;", "currentFilter", "Lcom/personalfinance/app/domain/model/TransactionFilter;", "hasActiveFilters", "errorMessage", "", "(ZLjava/util/List;Ljava/util/List;Ljava/util/List;Lcom/personalfinance/app/domain/model/TransactionFilter;ZLjava/lang/String;)V", "getAllTransactions", "()Ljava/util/List;", "getAvailableCategories", "getCurrentFilter", "()Lcom/personalfinance/app/domain/model/TransactionFilter;", "getErrorMessage", "()Ljava/lang/String;", "getFilteredTransactions", "getHasActiveFilters", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class TransactionsUiState {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.personalfinance.app.domain.model.Transaction> allTransactions = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.personalfinance.app.domain.model.Transaction> filteredTransactions = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.personalfinance.app.domain.model.Category> availableCategories = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.domain.model.TransactionFilter currentFilter = null;
    private final boolean hasActiveFilters = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String errorMessage = null;
    
    public TransactionsUiState(boolean isLoading, @org.jetbrains.annotations.NotNull()
    java.util.List<com.personalfinance.app.domain.model.Transaction> allTransactions, @org.jetbrains.annotations.NotNull()
    java.util.List<com.personalfinance.app.domain.model.Transaction> filteredTransactions, @org.jetbrains.annotations.NotNull()
    java.util.List<com.personalfinance.app.domain.model.Category> availableCategories, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.TransactionFilter currentFilter, boolean hasActiveFilters, @org.jetbrains.annotations.Nullable()
    java.lang.String errorMessage) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.personalfinance.app.domain.model.Transaction> getAllTransactions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.personalfinance.app.domain.model.Transaction> getFilteredTransactions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.personalfinance.app.domain.model.Category> getAvailableCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.TransactionFilter getCurrentFilter() {
        return null;
    }
    
    public final boolean getHasActiveFilters() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getErrorMessage() {
        return null;
    }
    
    public TransactionsUiState() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.personalfinance.app.domain.model.Transaction> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.personalfinance.app.domain.model.Transaction> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.personalfinance.app.domain.model.Category> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.TransactionFilter component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.presentation.transactions.TransactionsUiState copy(boolean isLoading, @org.jetbrains.annotations.NotNull()
    java.util.List<com.personalfinance.app.domain.model.Transaction> allTransactions, @org.jetbrains.annotations.NotNull()
    java.util.List<com.personalfinance.app.domain.model.Transaction> filteredTransactions, @org.jetbrains.annotations.NotNull()
    java.util.List<com.personalfinance.app.domain.model.Category> availableCategories, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.TransactionFilter currentFilter, boolean hasActiveFilters, @org.jetbrains.annotations.Nullable()
    java.lang.String errorMessage) {
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