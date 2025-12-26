package com.personalfinance.app.presentation.recurring;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import com.personalfinance.app.domain.model.Transaction;
import java.time.format.DateTimeFormatter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\u001e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a.\u0010\b\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u00a8\u0006\u0014"}, d2 = {"EmptyRecurringTransactionsState", "", "onAddRecurringTransaction", "Lkotlin/Function0;", "RecurringTransactionCard", "transaction", "Lcom/personalfinance/app/domain/model/Transaction;", "onDeleteTransaction", "RecurringTransactionsScreen", "onNavigateBack", "onNavigateToAddTransaction", "viewModel", "Lcom/personalfinance/app/presentation/recurring/RecurringTransactionsViewModel;", "formatAmount", "", "amount", "", "formatDate", "date", "Lkotlinx/datetime/LocalDateTime;", "app_debug"})
public final class RecurringTransactionsScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void RecurringTransactionsScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToAddTransaction, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.presentation.recurring.RecurringTransactionsViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EmptyRecurringTransactionsState(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddRecurringTransaction) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void RecurringTransactionCard(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteTransaction) {
    }
    
    private static final java.lang.String formatDate(kotlinx.datetime.LocalDateTime date) {
        return null;
    }
    
    private static final java.lang.String formatAmount(double amount) {
        return null;
    }
}