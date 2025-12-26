package com.personalfinance.app.presentation.transactions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personalfinance.app.domain.model.Category
import com.personalfinance.app.domain.model.Transaction
import com.personalfinance.app.domain.model.TransactionFilter
import com.personalfinance.app.domain.repository.CategoryRepository
import com.personalfinance.app.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository,
    private val categoryRepository: CategoryRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(TransactionsUiState())
    val uiState: StateFlow<TransactionsUiState> = _uiState.asStateFlow()
    
    private val _currentFilter = MutableStateFlow(TransactionFilter())
    private val _searchQuery = MutableStateFlow("")
    
    init {
        loadCategories()
    }
    
    fun loadTransactions() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            combine(
                transactionRepository.getTransactions(TransactionFilter()),
                _currentFilter,
                _searchQuery
            ) { transactions, filter, searchQuery ->
                Triple(transactions, filter, searchQuery)
            }
                .catch { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = exception.message ?: "Failed to load transactions"
                    )
                }
                .collect { (transactions, filter, searchQuery) ->
                    val filteredTransactions = applyFiltersAndSearch(transactions, filter, searchQuery)
                    
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        allTransactions = transactions,
                        filteredTransactions = filteredTransactions,
                        currentFilter = filter,
                        hasActiveFilters = hasActiveFilters(filter, searchQuery),
                        errorMessage = null
                    )
                }
        }
    }
    
    private fun loadCategories() {
        viewModelScope.launch {
            categoryRepository.getCategories()
                .catch { exception ->
                    // Handle error silently for categories
                }
                .collect { categories ->
                    _uiState.value = _uiState.value.copy(
                        availableCategories = categories
                    )
                }
        }
    }
    
    fun applyFilter(filter: TransactionFilter) {
        _currentFilter.value = filter
    }
    
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
    
    fun clearFilters() {
        _currentFilter.value = TransactionFilter()
        _searchQuery.value = ""
    }
    
    private fun applyFiltersAndSearch(
        transactions: List<Transaction>,
        filter: TransactionFilter,
        searchQuery: String
    ): List<Transaction> {
        var filtered = transactions
        
        // Apply search query
        if (searchQuery.isNotBlank()) {
            filtered = filtered.filter { transaction ->
                transaction.description.contains(searchQuery, ignoreCase = true) ||
                transaction.categoryId.contains(searchQuery, ignoreCase = true)
            }
        }
        
        // Apply category filter
        if (filter.categoryIds.isNotEmpty()) {
            filtered = filtered.filter { transaction ->
                filter.categoryIds.contains(transaction.categoryId)
            }
        }
        
        // Apply amount range filter
        if (filter.minAmount != null) {
            filtered = filtered.filter { transaction ->
                kotlin.math.abs(transaction.amount) >= filter.minAmount
            }
        }
        
        if (filter.maxAmount != null) {
            filtered = filtered.filter { transaction ->
                kotlin.math.abs(transaction.amount) <= filter.maxAmount
            }
        }
        
        // Apply payment method filter
        if (filter.paymentMethods.isNotEmpty()) {
            filtered = filtered.filter { transaction ->
                filter.paymentMethods.contains(transaction.paymentMethod)
            }
        }
        
        // Apply date range filter
        if (filter.startDate != null) {
            filtered = filtered.filter { transaction ->
                transaction.date >= filter.startDate
            }
        }
        
        if (filter.endDate != null) {
            filtered = filtered.filter { transaction ->
                transaction.date <= filter.endDate
            }
        }
        
        return filtered.sortedByDescending { it.date }
    }
    
    private fun hasActiveFilters(filter: TransactionFilter, searchQuery: String): Boolean {
        return searchQuery.isNotBlank() ||
               filter.categoryIds.isNotEmpty() ||
               filter.paymentMethods.isNotEmpty() ||
               filter.minAmount != null ||
               filter.maxAmount != null ||
               filter.startDate != null ||
               filter.endDate != null
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(errorMessage = null)
    }
}

data class TransactionsUiState(
    val isLoading: Boolean = false,
    val allTransactions: List<Transaction> = emptyList(),
    val filteredTransactions: List<Transaction> = emptyList(),
    val availableCategories: List<Category> = emptyList(),
    val currentFilter: TransactionFilter = TransactionFilter(),
    val hasActiveFilters: Boolean = false,
    val errorMessage: String? = null
)