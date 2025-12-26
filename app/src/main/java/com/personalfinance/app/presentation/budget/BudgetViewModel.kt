package com.personalfinance.app.presentation.budget

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personalfinance.app.domain.model.Budget
import com.personalfinance.app.domain.model.BudgetPeriod
import com.personalfinance.app.domain.repository.BudgetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject

@HiltViewModel
class BudgetViewModel @Inject constructor(
    private val budgetRepository: BudgetRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(BudgetUiState())
    val uiState: StateFlow<BudgetUiState> = _uiState.asStateFlow()
    
    init {
        loadBudgets()
    }
    
    fun loadBudgets() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            budgetRepository.getBudgets()
                .catch { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = exception.message ?: "Failed to load budgets"
                    )
                }
                .collect { budgets ->
                    // For each budget, we would calculate current spending
                    // For now, using mock data
                    val budgetSpending = budgets.associate { budget ->
                        budget.id to (budget.amount * 0.6) // Mock 60% spending
                    }
                    
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        budgets = budgets,
                        budgetSpending = budgetSpending,
                        errorMessage = null
                    )
                }
        }
    }
    
    fun addBudget(categoryId: String, amount: Double) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
            val budget = Budget(
                categoryId = categoryId,
                amount = amount,
                period = BudgetPeriod.MONTHLY,
                startDate = now.date,
                userId = "", // Will be updated when auth is integrated
                alertThreshold = 0.8
            )
            
            budgetRepository.createBudget(budget)
                .onSuccess {
                    loadBudgets() // Reload to get updated list
                }
                .onFailure { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = exception.message ?: "Failed to create budget"
                    )
                }
        }
    }
    
    fun deleteBudget(budgetId: Long) {
        viewModelScope.launch {
            budgetRepository.deleteBudget(budgetId)
                .onSuccess {
                    loadBudgets() // Reload to get updated list
                }
                .onFailure { exception ->
                    _uiState.value = _uiState.value.copy(
                        errorMessage = exception.message ?: "Failed to delete budget"
                    )
                }
        }
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(errorMessage = null)
    }
}

data class BudgetUiState(
    val isLoading: Boolean = false,
    val budgets: List<Budget> = emptyList(),
    val budgetSpending: Map<Long, Double> = emptyMap(),
    val errorMessage: String? = null
)