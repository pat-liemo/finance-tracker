package com.personalfinance.app.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personalfinance.app.data.preferences.ThemeMode
import com.personalfinance.app.data.preferences.ThemePreferences
import com.personalfinance.app.presentation.theme.ThemeManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SettingsUiState(
    val themeMode: ThemeMode = ThemeMode.SYSTEM,
    val dynamicColorEnabled: Boolean = true,
    val largeTextEnabled: Boolean = false,
    val highContrastEnabled: Boolean = false
)

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val themeManager: ThemeManager,
    private val themePreferences: ThemePreferences
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()
    
    init {
        viewModelScope.launch {
            themePreferences.themeMode.collect { themeMode ->
                _uiState.value = _uiState.value.copy(themeMode = themeMode)
            }
        }
        
        viewModelScope.launch {
            themePreferences.dynamicColorEnabled.collect { enabled ->
                _uiState.value = _uiState.value.copy(dynamicColorEnabled = enabled)
            }
        }
        
        viewModelScope.launch {
            themePreferences.largeTextEnabled.collect { enabled ->
                _uiState.value = _uiState.value.copy(largeTextEnabled = enabled)
            }
        }
        
        viewModelScope.launch {
            themePreferences.highContrastEnabled.collect { enabled ->
                _uiState.value = _uiState.value.copy(highContrastEnabled = enabled)
            }
        }
    }
    
    fun setThemeMode(mode: ThemeMode) {
        viewModelScope.launch {
            themeManager.setThemeMode(mode)
        }
    }
    
    fun setDynamicColor(enabled: Boolean) {
        viewModelScope.launch {
            themePreferences.setDynamicColorEnabled(enabled)
        }
    }
    
    fun setLargeText(enabled: Boolean) {
        viewModelScope.launch {
            themePreferences.setLargeTextEnabled(enabled)
        }
    }
    
    fun setHighContrast(enabled: Boolean) {
        viewModelScope.launch {
            themePreferences.setHighContrastEnabled(enabled)
        }
    }
}