package com.personalfinance.app.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.personalfinance.app.presentation.analytics.AnalyticsScreen
import com.personalfinance.app.presentation.auth.AuthViewModel
import com.personalfinance.app.presentation.auth.LoginScreen
import com.personalfinance.app.presentation.auth.SignUpScreen
import com.personalfinance.app.presentation.budget.BudgetScreen
import com.personalfinance.app.presentation.categories.CategoriesScreen
import com.personalfinance.app.presentation.home.HomeScreen
import com.personalfinance.app.presentation.onboarding.OnboardingScreen
import com.personalfinance.app.presentation.recurring.RecurringTransactionsScreen
import com.personalfinance.app.presentation.settings.SettingsScreen
import com.personalfinance.app.presentation.transaction.AddTransactionScreen
import com.personalfinance.app.presentation.transactions.TransactionsScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val currentUser by authViewModel.currentUser.collectAsState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    val startDestination = if (currentUser != null) {
        Screen.Home.route
    } else {
        Screen.Login.route
    }
    
    // Show main container with bottom nav for main screens
    if (shouldShowBottomNav(currentRoute)) {
        MainContainer(navController = navController) { paddingValues ->
            AppNavHost(
                navController = navController,
                startDestination = startDestination,
                authViewModel = authViewModel,
                paddingValues = paddingValues
            )
        }
    } else {
        AppNavHost(
            navController = navController,
            startDestination = startDestination,
            authViewModel = authViewModel,
            paddingValues = null
        )
    }
}

@Composable
private fun AppNavHost(
    navController: NavHostController,
    startDestination: String,
    authViewModel: AuthViewModel,
    paddingValues: PaddingValues?
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                onComplete = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Screen.Login.route) {
            LoginScreen(
                onNavigateToSignUp = {
                    navController.navigate(Screen.SignUp.route) {
                        popUpTo(Screen.Login.route) { inclusive = false }
                    }
                },
                onLoginSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                viewModel = authViewModel
            )
        }
        
        composable(Screen.SignUp.route) {
            SignUpScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.SignUp.route) { inclusive = true }
                    }
                },
                onSignUpSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.SignUp.route) { inclusive = true }
                    }
                },
                viewModel = authViewModel
            )
        }
        
        composable(Screen.Home.route) {
            HomeScreen(
                onSignOut = {
                    authViewModel.signOut()
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                },
                onAddTransaction = {
                    navController.navigate(Screen.AddTransaction.route)
                },
                onNavigateToAnalytics = {
                    navController.navigate(Screen.Analytics.route)
                },
                onNavigateToSettings = {
                    navController.navigate(Screen.Settings.route)
                },
                onNavigateToBudgets = {
                    navController.navigate(Screen.Budget.route)
                },
                onNavigateToCategories = {
                    navController.navigate(Screen.Categories.route)
                },
                onNavigateToTransactions = {
                    navController.navigate(Screen.Transactions.route)
                },
                onNavigateToRecurring = {
                    navController.navigate(Screen.RecurringTransactions.route)
                },
                paddingValues = paddingValues
            )
        }
        
        composable(Screen.AddTransaction.route) {
            AddTransactionScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.Analytics.route) {
            AnalyticsScreen(
                paddingValues = paddingValues
            )
        }
        
        composable(Screen.Budget.route) {
            BudgetScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                paddingValues = paddingValues
            )
        }
        
        composable(Screen.Categories.route) {
            CategoriesScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.Transactions.route) {
            TransactionsScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.RecurringTransactions.route) {
            RecurringTransactionsScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToAddTransaction = {
                    navController.navigate(Screen.AddTransaction.route)
                }
            )
        }
        
        composable(Screen.Settings.route) {
            SettingsScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                paddingValues = paddingValues
            )
        }
    }
}

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object SignUp : Screen("signup")
    object Home : Screen("home")
    object AddTransaction : Screen("add_transaction")
    object Analytics : Screen("analytics")
    object Budget : Screen("budget")
    object Categories : Screen("categories")
    object Transactions : Screen("transactions")
    object RecurringTransactions : Screen("recurring_transactions")
    object Settings : Screen("settings")
}