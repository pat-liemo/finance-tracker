package com.personalfinance.app.presentation.analytics;

import androidx.lifecycle.ViewModel;
import com.personalfinance.app.domain.model.BudgetUtilization;
import com.personalfinance.app.domain.model.ChartData;
import com.personalfinance.app.domain.model.DateRange;
import com.personalfinance.app.domain.model.SpendingBreakdown;
import com.personalfinance.app.domain.model.TrendAnalysis;
import com.personalfinance.app.domain.repository.AnalyticsRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.datetime.Clock;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.TimeZone;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0013J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u00c6\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rH\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u007f\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010/\u001a\u000200H\u00d6\u0001J\t\u00101\u001a\u00020\u0005H\u00d6\u0001R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\u00a8\u00062"}, d2 = {"Lcom/personalfinance/app/presentation/analytics/AnalyticsUiState;", "", "isLoading", "", "error", "", "spendingBreakdown", "Lcom/personalfinance/app/domain/model/SpendingBreakdown;", "incomeVsExpenseChart", "Lcom/personalfinance/app/domain/model/ChartData;", "trendAnalysis", "Lcom/personalfinance/app/domain/model/TrendAnalysis;", "budgetUtilization", "", "Lcom/personalfinance/app/domain/model/BudgetUtilization;", "insights", "dateRange", "Lcom/personalfinance/app/domain/model/DateRange;", "exportMessage", "(ZLjava/lang/String;Lcom/personalfinance/app/domain/model/SpendingBreakdown;Lcom/personalfinance/app/domain/model/ChartData;Lcom/personalfinance/app/domain/model/TrendAnalysis;Ljava/util/List;Ljava/util/List;Lcom/personalfinance/app/domain/model/DateRange;Ljava/lang/String;)V", "getBudgetUtilization", "()Ljava/util/List;", "getDateRange", "()Lcom/personalfinance/app/domain/model/DateRange;", "getError", "()Ljava/lang/String;", "getExportMessage", "getIncomeVsExpenseChart", "()Lcom/personalfinance/app/domain/model/ChartData;", "getInsights", "()Z", "getSpendingBreakdown", "()Lcom/personalfinance/app/domain/model/SpendingBreakdown;", "getTrendAnalysis", "()Lcom/personalfinance/app/domain/model/TrendAnalysis;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class AnalyticsUiState {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    @org.jetbrains.annotations.Nullable()
    private final com.personalfinance.app.domain.model.SpendingBreakdown spendingBreakdown = null;
    @org.jetbrains.annotations.Nullable()
    private final com.personalfinance.app.domain.model.ChartData incomeVsExpenseChart = null;
    @org.jetbrains.annotations.Nullable()
    private final com.personalfinance.app.domain.model.TrendAnalysis trendAnalysis = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.personalfinance.app.domain.model.BudgetUtilization> budgetUtilization = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> insights = null;
    @org.jetbrains.annotations.Nullable()
    private final com.personalfinance.app.domain.model.DateRange dateRange = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String exportMessage = null;
    
    public AnalyticsUiState(boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, @org.jetbrains.annotations.Nullable()
    com.personalfinance.app.domain.model.SpendingBreakdown spendingBreakdown, @org.jetbrains.annotations.Nullable()
    com.personalfinance.app.domain.model.ChartData incomeVsExpenseChart, @org.jetbrains.annotations.Nullable()
    com.personalfinance.app.domain.model.TrendAnalysis trendAnalysis, @org.jetbrains.annotations.Nullable()
    java.util.List<com.personalfinance.app.domain.model.BudgetUtilization> budgetUtilization, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> insights, @org.jetbrains.annotations.Nullable()
    com.personalfinance.app.domain.model.DateRange dateRange, @org.jetbrains.annotations.Nullable()
    java.lang.String exportMessage) {
        super();
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.personalfinance.app.domain.model.SpendingBreakdown getSpendingBreakdown() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.personalfinance.app.domain.model.ChartData getIncomeVsExpenseChart() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.personalfinance.app.domain.model.TrendAnalysis getTrendAnalysis() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.personalfinance.app.domain.model.BudgetUtilization> getBudgetUtilization() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getInsights() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.personalfinance.app.domain.model.DateRange getDateRange() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getExportMessage() {
        return null;
    }
    
    public AnalyticsUiState() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.personalfinance.app.domain.model.SpendingBreakdown component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.personalfinance.app.domain.model.ChartData component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.personalfinance.app.domain.model.TrendAnalysis component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.personalfinance.app.domain.model.BudgetUtilization> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.personalfinance.app.domain.model.DateRange component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.presentation.analytics.AnalyticsUiState copy(boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, @org.jetbrains.annotations.Nullable()
    com.personalfinance.app.domain.model.SpendingBreakdown spendingBreakdown, @org.jetbrains.annotations.Nullable()
    com.personalfinance.app.domain.model.ChartData incomeVsExpenseChart, @org.jetbrains.annotations.Nullable()
    com.personalfinance.app.domain.model.TrendAnalysis trendAnalysis, @org.jetbrains.annotations.Nullable()
    java.util.List<com.personalfinance.app.domain.model.BudgetUtilization> budgetUtilization, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> insights, @org.jetbrains.annotations.Nullable()
    com.personalfinance.app.domain.model.DateRange dateRange, @org.jetbrains.annotations.Nullable()
    java.lang.String exportMessage) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}