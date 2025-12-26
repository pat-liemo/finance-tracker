package com.personalfinance.app.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.personalfinance.app.data.preferences.ThemeMode
import com.personalfinance.app.data.preferences.ThemePreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThemeManager @Inject constructor(
    private val themePreferences: ThemePreferences
) {
    @Composable
    fun isDarkTheme(): Boolean {
        val themeMode by themePreferences.themeMode.collectAsState(initial = ThemeMode.SYSTEM)
        val systemDarkTheme = isSystemInDarkTheme()
        
        return when (themeMode) {
            ThemeMode.LIGHT -> false
            ThemeMode.DARK -> true
            ThemeMode.SYSTEM -> systemDarkTheme
        }
    }
    
    @Composable
    fun isDynamicColorEnabled(): Boolean {
        val dynamicColorEnabled by themePreferences.dynamicColorEnabled.collectAsState(initial = true)
        return dynamicColorEnabled
    }
    
    @Composable
    fun isLargeTextEnabled(): Boolean {
        val largeTextEnabled by themePreferences.largeTextEnabled.collectAsState(initial = false)
        return largeTextEnabled
    }
    
    @Composable
    fun isHighContrastEnabled(): Boolean {
        val highContrastEnabled by themePreferences.highContrastEnabled.collectAsState(initial = false)
        return highContrastEnabled
    }
    
    suspend fun setThemeMode(mode: ThemeMode) {
        themePreferences.setThemeMode(mode)
    }
}