package com.personalfinance.app.presentation.navigation;

import androidx.compose.runtime.Composable;
import androidx.navigation.NavHostController;
import com.personalfinance.app.presentation.auth.AuthViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u000b\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u00a8\u0006\u001d"}, d2 = {"Lcom/personalfinance/app/presentation/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "AddTransaction", "Analytics", "Budget", "Categories", "Home", "Login", "Onboarding", "RecurringTransactions", "Settings", "SignUp", "Transactions", "Lcom/personalfinance/app/presentation/navigation/Screen$AddTransaction;", "Lcom/personalfinance/app/presentation/navigation/Screen$Analytics;", "Lcom/personalfinance/app/presentation/navigation/Screen$Budget;", "Lcom/personalfinance/app/presentation/navigation/Screen$Categories;", "Lcom/personalfinance/app/presentation/navigation/Screen$Home;", "Lcom/personalfinance/app/presentation/navigation/Screen$Login;", "Lcom/personalfinance/app/presentation/navigation/Screen$Onboarding;", "Lcom/personalfinance/app/presentation/navigation/Screen$RecurringTransactions;", "Lcom/personalfinance/app/presentation/navigation/Screen$Settings;", "Lcom/personalfinance/app/presentation/navigation/Screen$SignUp;", "Lcom/personalfinance/app/presentation/navigation/Screen$Transactions;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/personalfinance/app/presentation/navigation/Screen$AddTransaction;", "Lcom/personalfinance/app/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class AddTransaction extends com.personalfinance.app.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.personalfinance.app.presentation.navigation.Screen.AddTransaction INSTANCE = null;
        
        private AddTransaction() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/personalfinance/app/presentation/navigation/Screen$Analytics;", "Lcom/personalfinance/app/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Analytics extends com.personalfinance.app.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.personalfinance.app.presentation.navigation.Screen.Analytics INSTANCE = null;
        
        private Analytics() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/personalfinance/app/presentation/navigation/Screen$Budget;", "Lcom/personalfinance/app/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Budget extends com.personalfinance.app.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.personalfinance.app.presentation.navigation.Screen.Budget INSTANCE = null;
        
        private Budget() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/personalfinance/app/presentation/navigation/Screen$Categories;", "Lcom/personalfinance/app/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Categories extends com.personalfinance.app.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.personalfinance.app.presentation.navigation.Screen.Categories INSTANCE = null;
        
        private Categories() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/personalfinance/app/presentation/navigation/Screen$Home;", "Lcom/personalfinance/app/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Home extends com.personalfinance.app.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.personalfinance.app.presentation.navigation.Screen.Home INSTANCE = null;
        
        private Home() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/personalfinance/app/presentation/navigation/Screen$Login;", "Lcom/personalfinance/app/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Login extends com.personalfinance.app.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.personalfinance.app.presentation.navigation.Screen.Login INSTANCE = null;
        
        private Login() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/personalfinance/app/presentation/navigation/Screen$Onboarding;", "Lcom/personalfinance/app/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Onboarding extends com.personalfinance.app.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.personalfinance.app.presentation.navigation.Screen.Onboarding INSTANCE = null;
        
        private Onboarding() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/personalfinance/app/presentation/navigation/Screen$RecurringTransactions;", "Lcom/personalfinance/app/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class RecurringTransactions extends com.personalfinance.app.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.personalfinance.app.presentation.navigation.Screen.RecurringTransactions INSTANCE = null;
        
        private RecurringTransactions() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/personalfinance/app/presentation/navigation/Screen$Settings;", "Lcom/personalfinance/app/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Settings extends com.personalfinance.app.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.personalfinance.app.presentation.navigation.Screen.Settings INSTANCE = null;
        
        private Settings() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/personalfinance/app/presentation/navigation/Screen$SignUp;", "Lcom/personalfinance/app/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class SignUp extends com.personalfinance.app.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.personalfinance.app.presentation.navigation.Screen.SignUp INSTANCE = null;
        
        private SignUp() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/personalfinance/app/presentation/navigation/Screen$Transactions;", "Lcom/personalfinance/app/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Transactions extends com.personalfinance.app.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.personalfinance.app.presentation.navigation.Screen.Transactions INSTANCE = null;
        
        private Transactions() {
        }
    }
}