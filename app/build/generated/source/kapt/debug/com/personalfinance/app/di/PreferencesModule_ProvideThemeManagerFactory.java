package com.personalfinance.app.di;

import com.personalfinance.app.data.preferences.ThemePreferences;
import com.personalfinance.app.presentation.theme.ThemeManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class PreferencesModule_ProvideThemeManagerFactory implements Factory<ThemeManager> {
  private final Provider<ThemePreferences> themePreferencesProvider;

  public PreferencesModule_ProvideThemeManagerFactory(
      Provider<ThemePreferences> themePreferencesProvider) {
    this.themePreferencesProvider = themePreferencesProvider;
  }

  @Override
  public ThemeManager get() {
    return provideThemeManager(themePreferencesProvider.get());
  }

  public static PreferencesModule_ProvideThemeManagerFactory create(
      Provider<ThemePreferences> themePreferencesProvider) {
    return new PreferencesModule_ProvideThemeManagerFactory(themePreferencesProvider);
  }

  public static ThemeManager provideThemeManager(ThemePreferences themePreferences) {
    return Preconditions.checkNotNullFromProvides(PreferencesModule.INSTANCE.provideThemeManager(themePreferences));
  }
}
