package com.personalfinance.app.presentation.analytics;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer;
import kotlinx.datetime.LocalDate;
import java.text.NumberFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0016\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0003\u001a*\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000eH\u0003\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0003\u001a\u0016\u0010\u0013\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0003\u001a\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0017H\u0003\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0003\u001a\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u001a\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0002\u00a8\u0006!"}, d2 = {"AnalyticsScreen", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "viewModel", "Lcom/personalfinance/app/presentation/analytics/AnalyticsViewModel;", "BudgetUtilizationCard", "budgetUtilizations", "", "Lcom/personalfinance/app/domain/model/BudgetUtilization;", "ExportDataDialog", "onDismiss", "Lkotlin/Function0;", "onExport", "Lkotlin/Function1;", "", "IncomeVsExpenseChart", "chartData", "Lcom/personalfinance/app/domain/model/ChartData;", "InsightsCard", "insights", "SpendingBreakdownCard", "breakdown", "Lcom/personalfinance/app/domain/model/SpendingBreakdown;", "TrendsCard", "trends", "Lcom/personalfinance/app/domain/model/TrendAnalysis;", "formatCurrency", "amount", "", "formatDate", "date", "Lkotlinx/datetime/LocalDate;", "app_debug"})
public final class AnalyticsScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void AnalyticsScreen(@org.jetbrains.annotations.Nullable()
    androidx.compose.foundation.layout.PaddingValues paddingValues, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.presentation.analytics.AnalyticsViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void IncomeVsExpenseChart(com.personalfinance.app.domain.model.ChartData chartData) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SpendingBreakdownCard(com.personalfinance.app.domain.model.SpendingBreakdown breakdown) {
    }
    
    private static final java.lang.String formatDate(kotlinx.datetime.LocalDate date) {
        return null;
    }
    
    private static final java.lang.String formatCurrency(double amount) {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TrendsCard(com.personalfinance.app.domain.model.TrendAnalysis trends) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void BudgetUtilizationCard(java.util.List<com.personalfinance.app.domain.model.BudgetUtilization> budgetUtilizations) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void InsightsCard(java.util.List<java.lang.String> insights) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ExportDataDialog(kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onExport) {
    }
}