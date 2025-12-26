package com.personalfinance.app.domain.repository

import com.personalfinance.app.domain.model.SpendingBreakdown
import com.personalfinance.app.domain.model.ChartData
import com.personalfinance.app.domain.model.TrendAnalysis
import com.personalfinance.app.domain.model.BudgetUtilization
import com.personalfinance.app.domain.model.DateRange

interface AnalyticsRepository {
    suspend fun generateSpendingBreakdown(period: DateRange): Result<SpendingBreakdown>
    suspend fun generateIncomeVsExpenseChart(period: DateRange): Result<ChartData>
    suspend fun calculateTrends(period: DateRange): Result<TrendAnalysis>
    suspend fun getBudgetUtilization(): Result<List<BudgetUtilization>>
    suspend fun detectSpendingBehaviorChanges(period: DateRange): Result<List<String>>
}