package com.personalfinance.app.presentation.budget;

import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import com.personalfinance.app.domain.model.Budget;
import com.personalfinance.app.domain.model.BudgetPeriod;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a&\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a,\u0010\r\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u0016\u0010\u0013\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u00a8\u0006\u0014"}, d2 = {"AddBudgetDialog", "", "onDismiss", "Lkotlin/Function0;", "onAddBudget", "Lkotlin/Function2;", "", "", "BudgetCard", "budget", "Lcom/personalfinance/app/domain/model/Budget;", "currentSpending", "onDeleteBudget", "BudgetScreen", "onNavigateBack", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "viewModel", "Lcom/personalfinance/app/presentation/budget/BudgetViewModel;", "EmptyBudgetState", "app_debug"})
public final class BudgetScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void BudgetScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack, @org.jetbrains.annotations.Nullable()
    androidx.compose.foundation.layout.PaddingValues paddingValues, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.presentation.budget.BudgetViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EmptyBudgetState(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddBudget) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BudgetCard(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.Budget budget, double currentSpending, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteBudget) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AddBudgetDialog(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Double, kotlin.Unit> onAddBudget) {
    }
}