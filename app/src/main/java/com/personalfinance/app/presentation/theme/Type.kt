package com.personalfinance.app.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Default Typography
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp,
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
)

// Large Text Typography for Accessibility
val LargeTextTypography = Typography(
    displayLarge = Typography.displayLarge.copy(fontSize = 64.sp, lineHeight = 72.sp),
    displayMedium = Typography.displayMedium.copy(fontSize = 50.sp, lineHeight = 58.sp),
    displaySmall = Typography.displaySmall.copy(fontSize = 40.sp, lineHeight = 48.sp),
    headlineLarge = Typography.headlineLarge.copy(fontSize = 36.sp, lineHeight = 44.sp),
    headlineMedium = Typography.headlineMedium.copy(fontSize = 32.sp, lineHeight = 40.sp),
    headlineSmall = Typography.headlineSmall.copy(fontSize = 28.sp, lineHeight = 36.sp),
    titleLarge = Typography.titleLarge.copy(fontSize = 26.sp, lineHeight = 32.sp),
    titleMedium = Typography.titleMedium.copy(fontSize = 20.sp, lineHeight = 28.sp),
    titleSmall = Typography.titleSmall.copy(fontSize = 18.sp, lineHeight = 24.sp),
    bodyLarge = Typography.bodyLarge.copy(fontSize = 20.sp, lineHeight = 28.sp),
    bodyMedium = Typography.bodyMedium.copy(fontSize = 18.sp, lineHeight = 24.sp),
    bodySmall = Typography.bodySmall.copy(fontSize = 16.sp, lineHeight = 20.sp),
    labelLarge = Typography.labelLarge.copy(fontSize = 18.sp, lineHeight = 24.sp),
    labelMedium = Typography.labelMedium.copy(fontSize = 16.sp, lineHeight = 20.sp),
    labelSmall = Typography.labelSmall.copy(fontSize = 14.sp, lineHeight = 20.sp),
)

@Composable
fun getTypography(largeText: Boolean = false): Typography {
    return if (largeText) LargeTextTypography else Typography
}