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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tJ,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\u0006\u0010\u001f\u001a\u00020\u0013J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u000bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\""}, d2 = {"Lcom/personalfinance/app/presentation/transactions/TransactionsViewModel;", "Landroidx/lifecycle/ViewModel;", "transactionRepository", "Lcom/personalfinance/app/domain/repository/TransactionRepository;", "categoryRepository", "Lcom/personalfinance/app/domain/repository/CategoryRepository;", "(Lcom/personalfinance/app/domain/repository/TransactionRepository;Lcom/personalfinance/app/domain/repository/CategoryRepository;)V", "_currentFilter", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/personalfinance/app/domain/model/TransactionFilter;", "_searchQuery", "", "_uiState", "Lcom/personalfinance/app/presentation/transactions/TransactionsUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "applyFilter", "", "filter", "applyFiltersAndSearch", "", "Lcom/personalfinance/app/domain/model/Transaction;", "transactions", "searchQuery", "clearError", "clearFilters", "hasActiveFilters", "", "loadCategories", "loadTransactions", "updateSearchQuery", "query", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class TransactionsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.domain.repository.TransactionRepository transactionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.domain.repository.CategoryRepository categoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.personalfinance.app.presentation.transactions.TransactionsUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.personalfinance.app.presentation.transactions.TransactionsUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.personalfinance.app.domain.model.TransactionFilter> _currentFilter = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    
    @javax.inject.Inject()
    public TransactionsViewModel(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.repository.TransactionRepository transactionRepository, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.repository.CategoryRepository categoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.personalfinance.app.presentation.transactions.TransactionsUiState> getUiState() {
        return null;
    }
    
    public final void loadTransactions() {
    }
    
    private final void loadCategories() {
    }
    
    public final void applyFilter(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.TransactionFilter filter) {
    }
    
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void clearFilters() {
    }
    
    private final java.util.List<com.personalfinance.app.domain.model.Transaction> applyFiltersAndSearch(java.util.List<com.personalfinance.app.domain.model.Transaction> transactions, com.personalfinance.app.domain.model.TransactionFilter filter, java.lang.String searchQuery) {
        return null;
    }
    
    private final boolean hasActiveFilters(com.personalfinance.app.domain.model.TransactionFilter filter, java.lang.String searchQuery) {
        return false;
    }
    
    public final void clearError() {
    }
}