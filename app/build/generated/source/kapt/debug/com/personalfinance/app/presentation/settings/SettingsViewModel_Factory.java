package com.personalfinance.app.presentation.settings;

import com.personalfinance.app.data.preferences.ThemePreferences;
import com.personalfinance.app.presentation.theme.ThemeManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<ThemeManager> themeManagerProvider;

  private final Provider<ThemePreferences> themePreferencesProvider;

  public SettingsViewModel_Factory(Provider<ThemeManager> themeManagerProvider,
      Provider<ThemePreferences> themePreferencesProvider) {
    this.themeManagerProvider = themeManagerProvider;
    this.themePreferencesProvider = themePreferencesProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(themeManagerProvider.get(), themePreferencesProvider.get());
  }

  public static SettingsViewModel_Factory create(Provider<ThemeManager> themeManagerProvider,
      Provider<ThemePreferences> themePreferencesProvider) {
    return new SettingsViewModel_Factory(themeManagerProvider, themePreferencesProvider);
  }

  public static SettingsViewModel newInstance(ThemeManager themeManager,
      ThemePreferences themePreferences) {
    return new SettingsViewModel(themeManager, themePreferences);
  }
}
