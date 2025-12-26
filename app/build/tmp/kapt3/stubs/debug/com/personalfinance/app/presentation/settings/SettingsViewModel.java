package com.personalfinance.app.presentation.settings;

import androidx.lifecycle.ViewModel;
import com.personalfinance.app.data.preferences.ThemeMode;
import com.personalfinance.app.data.preferences.ThemePreferences;
import com.personalfinance.app.presentation.theme.ThemeManager;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/personalfinance/app/presentation/settings/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "themeManager", "Lcom/personalfinance/app/presentation/theme/ThemeManager;", "themePreferences", "Lcom/personalfinance/app/data/preferences/ThemePreferences;", "(Lcom/personalfinance/app/presentation/theme/ThemeManager;Lcom/personalfinance/app/data/preferences/ThemePreferences;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/personalfinance/app/presentation/settings/SettingsUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "setDynamicColor", "", "enabled", "", "setHighContrast", "setLargeText", "setThemeMode", "mode", "Lcom/personalfinance/app/data/preferences/ThemeMode;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.presentation.theme.ThemeManager themeManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.data.preferences.ThemePreferences themePreferences = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.personalfinance.app.presentation.settings.SettingsUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.personalfinance.app.presentation.settings.SettingsUiState> uiState = null;
    
    @javax.inject.Inject()
    public SettingsViewModel(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.presentation.theme.ThemeManager themeManager, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.preferences.ThemePreferences themePreferences) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.personalfinance.app.presentation.settings.SettingsUiState> getUiState() {
        return null;
    }
    
    public final void setThemeMode(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.data.preferences.ThemeMode mode) {
    }
    
    public final void setDynamicColor(boolean enabled) {
    }
    
    public final void setLargeText(boolean enabled) {
    }
    
    public final void setHighContrast(boolean enabled) {
    }
}