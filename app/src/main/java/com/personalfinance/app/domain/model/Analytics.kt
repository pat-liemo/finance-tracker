package com.personalfinance.app.domain.model

import kotlinx.datetime.LocalDate

data class DateRange(
    val startDate: LocalDate,
    val endDate: LocalDate
)

data class SpendingBreakdown(
    val totalAmount: Double,
    val categoryBreakdown: Map<String, Double>,
    val percentageBreakdown: Map<String, Double>
)

data class ChartData(
    val labels: List<String>,
    val datasets: List<Dataset>
)

data class Dataset(
    val label: String,
    val data: List<Double>,
    val color: String
)

data class TrendAnalysis(
    val period: DateRange,
    val trends: List<Trend>,
    val insights: List<String>
)

data class Trend(
    val category: String,
    val direction: TrendDirection,
    val changePercentage: Double,
    val description: String
)

enum class TrendDirection {
    INCREASING,
    DECREASING,
    STABLE
}

data class BudgetUtilization(
    val budgetId: Long,
    val categoryId: String,
    val categoryName: String,
    val budgetAmount: Double,
    val spentAmount: Double,
    val utilizationPercentage: Double,
    val remainingAmount: Double,
    val status: BudgetStatus
)

enum class BudgetStatus {
    ON_TRACK,
    APPROACHING_LIMIT,
    OVER_BUDGET
}