package com.personalfinance.app.presentation.recurring

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personalfinance.app.domain.model.Transaction
import com.personalfinance.app.domain.repository.RecurringTransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecurringTransactionsViewModel @Inject constructor(
    private val recurringTransactionRepository: RecurringTransactionRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(RecurringTransactionsUiState())
    val uiState: StateFlow<RecurringTransactionsUiState> = _uiState.asStateFlow()
    
    fun loadRecurringTransactions() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            recurringTransactionRepository.getRecurringTransactions()
                .catch { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = exception.message ?: "Failed to load recurring transactions"
                    )
                }
                .collect { transactions ->
                    val nextDueTransactions = recurringTransactionRepository.getNextDueTransactions()
                    
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        recurringTransactions = transactions,
                        nextDueTransactions = nextDueTransactions,
                        errorMessage = null
                    )
                }
        }
    }
    
    fun processRecurringTransactions() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            recurringTransactionRepository.processRecurringTransactions()
                .onSuccess { newTransactions ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = if (newTransactions.isNotEmpty()) {
                            "Created ${newTransactions.size} new transactions"
                        } else {
                            "No transactions were due"
                        }
                    )
                    loadRecurringTransactions() // Reload to get updated data
                }
                .onFailure { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = exception.message ?: "Failed to process recurring transactions"
                    )
                }
        }
    }
    
    fun deleteRecurringTransaction(transactionId: Long) {
        viewModelScope.launch {
            recurringTransactionRepository.deleteRecurringTransaction(transactionId)
                .onSuccess {
                    loadRecurringTransactions() // Reload to get updated list
                }
                .onFailure { exception ->
                    _uiState.value = _uiState.value.copy(
                        errorMessage = exception.message ?: "Failed to delete recurring transaction"
                    )
                }
        }
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(errorMessage = null)
    }
}

data class RecurringTransactionsUiState(
    val isLoading: Boolean = false,
    val recurringTransactions: List<Transaction> = emptyList(),
    val nextDueTransactions: List<Transaction> = emptyList(),
    val errorMessage: String? = null
)