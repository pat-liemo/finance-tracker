package com.personalfinance.app.presentation.home;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.personalfinance.app.domain.model.Transaction;
import com.personalfinance.app.presentation.auth.AuthViewModel;
import java.time.format.DateTimeFormatter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003\u001a\u00a6\u0001\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007\u001a\u001a\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003\u001a \u0010\u0017\u001a\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00192\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u001a\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002\u00a8\u0006!"}, d2 = {"EmptyTransactionState", "", "onAddTransaction", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "HomeScreen", "onSignOut", "onNavigateToAnalytics", "onNavigateToSettings", "onNavigateToBudgets", "onNavigateToCategories", "onNavigateToTransactions", "onNavigateToRecurring", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "authViewModel", "Lcom/personalfinance/app/presentation/auth/AuthViewModel;", "homeViewModel", "Lcom/personalfinance/app/presentation/home/HomeViewModel;", "TransactionItem", "transaction", "Lcom/personalfinance/app/domain/model/Transaction;", "TransactionList", "transactions", "", "formatAmount", "", "amount", "", "formatDate", "date", "Lkotlinx/datetime/LocalDateTime;", "app_debug"})
public final class HomeScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSignOut, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddTransaction, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToAnalytics, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToSettings, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToBudgets, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToCategories, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToTransactions, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToRecurring, @org.jetbrains.annotations.Nullable()
    androidx.compose.foundation.layout.PaddingValues paddingValues, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.presentation.auth.AuthViewModel authViewModel, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.presentation.home.HomeViewModel homeViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void EmptyTransactionState(kotlin.jvm.functions.Function0<kotlin.Unit> onAddTransaction, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TransactionList(java.util.List<com.personalfinance.app.domain.model.Transaction> transactions, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TransactionItem(com.personalfinance.app.domain.model.Transaction transaction, androidx.compose.ui.Modifier modifier) {
    }
    
    private static final java.lang.String formatDate(kotlinx.datetime.LocalDateTime date) {
        return null;
    }
    
    private static final java.lang.String formatAmount(double amount) {
        return null;
    }
}