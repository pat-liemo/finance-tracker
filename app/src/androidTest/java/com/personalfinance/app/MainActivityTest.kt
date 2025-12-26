package com.personalfinance.app

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.personalfinance.app.presentation.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test to verify MainActivity and Compose setup
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    
    @Test
    fun mainActivityDisplaysGreeting() {
        // Verify that the main activity displays the greeting text
        composeTestRule.onNodeWithText("Hello Personal Finance App!").assertExists()
    }
}