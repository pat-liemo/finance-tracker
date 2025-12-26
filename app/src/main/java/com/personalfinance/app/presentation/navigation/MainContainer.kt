package com.personalfinance.app.presentation.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContainer(
    navController: NavController,
    content: @Composable (PaddingValues) -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    val showBottomNav = shouldShowBottomNav(currentRoute)
    val showFab = shouldShowFab(currentRoute)
    
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                visible = showBottomNav
            )
        },
        floatingActionButton = {
            AnimatedVisibility(
                visible = showFab,
                enter = scaleIn(
                    animationSpec = tween(300),
                    initialScale = 0.8f
                ) + fadeIn(animationSpec = tween(300)),
                exit = scaleOut(
                    animationSpec = tween(300),
                    targetScale = 0.8f
                ) + fadeOut(animationSpec = tween(300))
            ) {
                FloatingActionButton(
                    onClick = {
                        navController.navigate(Screen.AddTransaction.route)
                    },
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    elevation = FloatingActionButtonDefaults.elevation(
                        defaultElevation = 6.dp,
                        pressedElevation = 12.dp
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Transaction"
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        content(paddingValues)
    }
}

fun shouldShowFab(route: String?): Boolean {
    return when (route) {
        Screen.Home.route,
        Screen.Analytics.route,
        Screen.Budget.route -> true
        else -> false
    }
}