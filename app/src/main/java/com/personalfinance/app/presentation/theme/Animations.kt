package com.personalfinance.app.presentation.theme

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

// Animation durations
object AnimationDurations {
    const val Fast = 150
    const val Normal = 300
    const val Slow = 500
}

// Common easing curves
object AnimationEasing {
    val FastOutSlowIn = CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f)
    val LinearOutSlowIn = CubicBezierEasing(0.0f, 0.0f, 0.2f, 1.0f)
    val FastOutLinearIn = CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f)
    val Standard = CubicBezierEasing(0.2f, 0.0f, 0.0f, 1.0f)
}

// Slide animations
@Composable
fun slideInFromRight(): EnterTransition {
    return slideInHorizontally(
        initialOffsetX = { fullWidth -> fullWidth },
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    ) + fadeIn(
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    )
}

@Composable
fun slideOutToLeft(): ExitTransition {
    return slideOutHorizontally(
        targetOffsetX = { fullWidth -> -fullWidth },
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    ) + fadeOut(
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    )
}

@Composable
fun slideInFromLeft(): EnterTransition {
    return slideInHorizontally(
        initialOffsetX = { fullWidth -> -fullWidth },
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    ) + fadeIn(
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    )
}

@Composable
fun slideOutToRight(): ExitTransition {
    return slideOutHorizontally(
        targetOffsetX = { fullWidth -> fullWidth },
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    ) + fadeOut(
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    )
}

// Fade animations
@Composable
fun fadeInAnimation(): EnterTransition {
    return fadeIn(
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    )
}

@Composable
fun fadeOutAnimation(): ExitTransition {
    return fadeOut(
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    )
}

// Scale animations
@Composable
fun scaleInAnimation(): EnterTransition {
    return scaleIn(
        initialScale = 0.8f,
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    ) + fadeIn(
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    )
}

@Composable
fun scaleOutAnimation(): ExitTransition {
    return scaleOut(
        targetScale = 0.8f,
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    ) + fadeOut(
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    )
}

// Slide up/down animations
@Composable
fun slideInFromBottom(): EnterTransition {
    return slideInVertically(
        initialOffsetY = { fullHeight -> fullHeight },
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    ) + fadeIn(
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    )
}

@Composable
fun slideOutToBottom(): ExitTransition {
    return slideOutVertically(
        targetOffsetY = { fullHeight -> fullHeight },
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    ) + fadeOut(
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    )
}

// Shared axis transitions (Material Design)
@Composable
fun sharedXAxisEnter(): EnterTransition {
    return slideInHorizontally(
        initialOffsetX = { fullWidth -> fullWidth / 4 },
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    ) + fadeIn(
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    )
}

@Composable
fun sharedXAxisExit(): ExitTransition {
    return slideOutHorizontally(
        targetOffsetX = { fullWidth -> -fullWidth / 4 },
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    ) + fadeOut(
        animationSpec = tween(
            durationMillis = AnimationDurations.Normal,
            easing = AnimationEasing.Standard
        )
    )
}

// Elevation animation specs
fun elevationAnimationSpec() = tween<Dp>(
    durationMillis = AnimationDurations.Fast,
    easing = AnimationEasing.FastOutSlowIn
)

// Content size animation spec
fun contentSizeAnimationSpec() = tween<IntSize>(
    durationMillis = AnimationDurations.Normal,
    easing = AnimationEasing.Standard
)