package com.personalfinance.app.presentation.transactions;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import com.personalfinance.app.domain.model.PaymentMethod;
import com.personalfinance.app.domain.model.Transaction;
import java.time.format.DateTimeFormatter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u001e\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u001a\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003\u001a \u0010\u000e\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u00a8\u0006\u0019"}, d2 = {"ActiveFiltersRow", "", "uiState", "Lcom/personalfinance/app/presentation/transactions/TransactionsUiState;", "onClearFilters", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "EmptyTransactionsState", "hasFilters", "", "TransactionItem", "transaction", "Lcom/personalfinance/app/domain/model/Transaction;", "TransactionsScreen", "onNavigateBack", "viewModel", "Lcom/personalfinance/app/presentation/transactions/TransactionsViewModel;", "formatAmount", "", "amount", "", "formatDate", "date", "Lkotlinx/datetime/LocalDateTime;", "app_debug"})
public final class TransactionsScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void TransactionsScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.presentation.transactions.TransactionsViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ActiveFiltersRow(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.presentation.transactions.TransactionsUiState uiState, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClearFilters, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EmptyTransactionsState(boolean hasFilters, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClearFilters) {
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