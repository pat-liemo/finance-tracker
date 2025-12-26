package com.personalfinance.app.presentation.transaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personalfinance.app.domain.model.Category
import com.personalfinance.app.domain.model.PaymentMethod
import com.personalfinance.app.domain.model.RecurringFrequency
import com.personalfinance.app.domain.model.RecurringPattern
import com.personalfinance.app.domain.model.Transaction
import com.personalfinance.app.domain.repository.AuthRepository
import com.personalfinance.app.domain.repository.CategoryRepository
import com.personalfinance.app.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject

@HiltViewModel
class AddTransactionViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository,
    private val categoryRepository: CategoryRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddTransactionUiState())
    val uiState: StateFlow<AddTransactionUiState> = _uiState.asStateFlow()

    init {
        loadCategories()
    }

    private fun loadCategories() {
        viewModelScope.launch {
            categoryRepository.getCategories()
                .catch { exception ->
                    _uiState.value = _uiState.value.copy(
                        error = "Failed to load categories: ${exception.message}"
                    )
                }
                .collect { categories ->
                    _uiState.value = _uiState.value.copy(
                        availableCategories = categories
                    )
                }
        }
    }

    fun updateAmount(amount: String) {
        _uiState.value = _uiState.value.copy(
            amount = amount,
            amountError = null
        )
    }

    fun updateTransactionType(isIncome: Boolean) {
        _uiState.value = _uiState.value.copy(isIncome = isIncome)
    }

    fun updateCategory(categoryId: String) {
        _uiState.value = _uiState.value.copy(
            category = categoryId,
            categoryError = null
        )
    }

    fun updateDate(date: LocalDateTime) {
        _uiState.value = _uiState.value.copy(date = date)
    }

    fun updateNote(note: String) {
        _uiState.value = _uiState.value.copy(note = note)
    }

    fun updatePaymentMethod(paymentMethod: PaymentMethod) {
        _uiState.value = _uiState.value.copy(paymentMethod = paymentMethod)
    }

    fun updateIsRecurring(isRecurring: Boolean) {
        _uiState.value = _uiState.value.copy(isRecurring = isRecurring)
    }

    fun updateRecurringFrequency(frequency: RecurringFrequency) {
        _uiState.value = _uiState.value.copy(recurringFrequency = frequency)
    }

    fun updateRecurringInterval(interval: Int) {
        _uiState.value = _uiState.value.copy(recurringInterval = interval)
    }

    fun saveTransaction(onSuccess: () -> Unit) {
        val currentState = _uiState.value
        
        // Validate form
        val validationErrors = validateForm(currentState)
        if (validationErrors.isNotEmpty()) {
            _uiState.value = currentState.copy(
                amountError = validationErrors["amount"],
                categoryError = validationErrors["category"]
            )
            return
        }

        viewModelScope.launch {
            _uiState.value = currentState.copy(isLoading = true, error = null)
            
            try {
                val currentUser = authRepository.getCurrentUser()
                if (currentUser == null) {
                    _uiState.value = currentState.copy(
                        isLoading = false,
                        error = "User not authenticated"
                    )
                    return@launch
                }

                val amount = currentState.amount.toDoubleOrNull() ?: 0.0
                val finalAmount = if (currentState.isIncome) amount else -amount

                val recurringPattern = if (currentState.isRecurring) {
                    RecurringPattern(
                        frequency = currentState.recurringFrequency,
                        interval = currentState.recurringInterval
                    )
                } else null

                val transaction = Transaction(
                    amount = finalAmount,
                    categoryId = currentState.category,
                    date = currentState.date,
                    description = currentState.note,
                    paymentMethod = currentState.paymentMethod,
                    isRecurring = currentState.isRecurring,
                    recurringPattern = recurringPattern,
                    userId = currentUser.id
                )

                val result = transactionRepository.addTransaction(transaction)
                
                result.fold(
                    onSuccess = {
                        _uiState.value = currentState.copy(isLoading = false)
                        onSuccess()
                    },
                    onFailure = { exception ->
                        _uiState.value = currentState.copy(
                            isLoading = false,
                            error = exception.message ?: "Failed to save transaction"
                        )
                    }
                )
            } catch (e: Exception) {
                _uiState.value = currentState.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to save transaction"
                )
            }
        }
    }

    private fun validateForm(state: AddTransactionUiState): Map<String, String> {
        val errors = mutableMapOf<String, String>()
        
        if (state.amount.isBlank()) {
            errors["amount"] = "Amount is required"
        } else {
            val amount = state.amount.toDoubleOrNull()
            if (amount == null || amount <= 0) {
                errors["amount"] = "Please enter a valid amount greater than 0"
            }
        }
        
        if (state.category.isBlank()) {
            errors["category"] = "Category is required"
        }
        
        return errors
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}

data class AddTransactionUiState(
    val amount: String = "",
    val isIncome: Boolean = false,
    val category: String = "",
    val date: LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
    val note: String = "",
    val paymentMethod: PaymentMethod = PaymentMethod.CASH,
    val isRecurring: Boolean = false,
    val recurringFrequency: RecurringFrequency = RecurringFrequency.MONTHLY,
    val recurringInterval: Int = 1,
    val availableCategories: List<Category> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val amountError: String? = null,
    val categoryError: String? = null
)