package com.personalfinance.app.di

import android.content.Context
import com.personalfinance.app.data.preferences.ThemePreferences
import com.personalfinance.app.presentation.theme.ThemeManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Provides
    @Singleton
    fun provideThemePreferences(
        @ApplicationContext context: Context
    ): ThemePreferences {
        return ThemePreferences(context)
    }

    @Provides
    @Singleton
    fun provideThemeManager(
        themePreferences: ThemePreferences
    ): ThemeManager {
        return ThemeManager(themePreferences)
    }
}