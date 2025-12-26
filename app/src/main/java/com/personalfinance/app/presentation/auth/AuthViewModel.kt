package com.personalfinance.app.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personalfinance.app.domain.model.User
import com.personalfinance.app.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()
    
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()
    
    init {
        // Check if user is already authenticated
        viewModelScope.launch {
            _currentUser.value = authRepository.getCurrentUser()
        }
        
        // Observe auth state changes
        viewModelScope.launch {
            authRepository.getCurrentUserFlow().collect { user ->
                _currentUser.value = user
            }
        }
    }
    
    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)
            
            val result = authRepository.signInWithEmail(email, password)
            result.fold(
                onSuccess = { user ->
                    _currentUser.value = user
                    _uiState.value = _uiState.value.copy(isLoading = false)
                },
                onFailure = { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = exception.message ?: "Sign in failed"
                    )
                }
            )
        }
    }
    
    fun signUp(email: String, password: String, confirmPassword: String) {
        viewModelScope.launch {
            // Validate passwords match
            if (password != confirmPassword) {
                _uiState.value = _uiState.value.copy(
                    errorMessage = "Passwords do not match"
                )
                return@launch
            }
            
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)
            
            val result = authRepository.signUp(email, password)
            result.fold(
                onSuccess = { user ->
                    _currentUser.value = user
                    _uiState.value = _uiState.value.copy(isLoading = false)
                },
                onFailure = { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = exception.message ?: "Sign up failed"
                    )
                }
            )
        }
    }
    
    fun signOut() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            val result = authRepository.signOut()
            result.fold(
                onSuccess = {
                    _currentUser.value = null
                    _uiState.value = _uiState.value.copy(isLoading = false)
                },
                onFailure = { exception ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = exception.message ?: "Sign out failed"
                    )
                }
            )
        }
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(errorMessage = null)
    }
}

data class AuthUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)