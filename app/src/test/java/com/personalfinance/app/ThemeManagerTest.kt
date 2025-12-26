package com.personalfinance.app

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.personalfinance.app.data.preferences.ThemeMode
import com.personalfinance.app.data.preferences.ThemePreferences
import com.personalfinance.app.presentation.theme.ThemeManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ThemeManagerTest {

    private lateinit var context: Context
    private lateinit var themePreferences: ThemePreferences
    private lateinit var themeManager: ThemeManager

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        themePreferences = ThemePreferences(context)
        themeManager = ThemeManager(themePreferences)
    }

    @Test
    fun `default theme mode should be SYSTEM`() = runTest {
        val defaultThemeMode = themePreferences.themeMode.first()
        assertEquals(ThemeMode.SYSTEM, defaultThemeMode)
    }

    @Test
    fun `setting theme mode should persist the value`() = runTest {
        // Set to DARK mode
        themeManager.setThemeMode(ThemeMode.DARK)
        val darkMode = themePreferences.themeMode.first()
        assertEquals(ThemeMode.DARK, darkMode)

        // Set to LIGHT mode
        themeManager.setThemeMode(ThemeMode.LIGHT)
        val lightMode = themePreferences.themeMode.first()
        assertEquals(ThemeMode.LIGHT, lightMode)

        // Set back to SYSTEM mode
        themeManager.setThemeMode(ThemeMode.SYSTEM)
        val systemMode = themePreferences.themeMode.first()
        assertEquals(ThemeMode.SYSTEM, systemMode)
    }
}