package com.personalfinance.app.presentation.theme;

import com.personalfinance.app.data.preferences.ThemePreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class ThemeManager_Factory implements Factory<ThemeManager> {
  private final Provider<ThemePreferences> themePreferencesProvider;

  public ThemeManager_Factory(Provider<ThemePreferences> themePreferencesProvider) {
    this.themePreferencesProvider = themePreferencesProvider;
  }

  @Override
  public ThemeManager get() {
    return newInstance(themePreferencesProvider.get());
  }

  public static ThemeManager_Factory create(Provider<ThemePreferences> themePreferencesProvider) {
    return new ThemeManager_Factory(themePreferencesProvider);
  }

  public static ThemeManager newInstance(ThemePreferences themePreferences) {
    return new ThemeManager(themePreferences);
  }
}
