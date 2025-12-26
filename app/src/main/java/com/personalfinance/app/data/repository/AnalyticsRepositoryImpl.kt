package com.personalfinance.app.data.repository

import com.personalfinance.app.data.local.dao.BudgetDao
import com.personalfinance.app.data.local.dao.CategoryDao
import com.personalfinance.app.data.local.dao.TransactionDao
import com.personalfinance.app.domain.model.*
import com.personalfinance.app.domain.repository.AnalyticsRepository
import kotlinx.coroutines.flow.first
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.atTime
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject
import kotlin.math.abs

class AnalyticsRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDao,
    private val categoryDao: CategoryDao,
    private val budgetDao: BudgetDao
) : AnalyticsRepository {
    
    override suspend fun generateSpendingBreakdown(period: DateRange): Result<SpendingBreakdown> {
        return try {
            val startDateTime = period.startDate.atStartOfDayIn(TimeZone.currentSystemDefault()).toLocalDateTime(TimeZone.currentSystemDefault())
            val endDateTime = period.endDate.atTime(23, 59, 59)
            
            // Get all transactions in the period (using empty userId for now)
            val transactions = transactionDao.getTransactionsByDateRange("", startDateTime, endDateTime).first()
            
            // Filter only expenses (negative amounts)
            val expenses = transactions.filter { it.amount < 0 }
            
            // Calculate total expenses
            val totalExpenses = expenses.sumOf { abs(it.amount) }
            
            // Group by category and calculate amounts
            val categoryBreakdown = mutableMapOf<String, Double>()
            val categoryNames = mutableMapOf<String, String>()
            
            for (expense in expenses) {
                val categoryId = expense.categoryId
                val amount = abs(expense.amount)
                
                // Get category name
                val category = categoryDao.getCategoryById(categoryId)
                val categoryName = category?.name ?: categoryId
                categoryNames[categoryId] = categoryName
                
                categoryBreakdown[categoryName] = categoryBreakdown.getOrDefault(categoryName, 0.0) + amount
            }
            
            // Calculate percentages
            val percentageBreakdown = if (totalExpenses > 0) {
                categoryBreakdown.mapValues { (_, amount) -> (amount / totalExpenses) * 100 }
            } else {
                emptyMap()
            }
            
            val spendingBreakdown = SpendingBreakdown(
                totalAmount = totalExpenses,
                categoryBreakdown = categoryBreakdown,
                percentageBreakdown = percentageBreakdown
            )
            
            Result.success(spendingBreakdown)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun generateIncomeVsExpenseChart(period: DateRange): Result<ChartData> {
        return try {
            val startDateTime = period.startDate.atStartOfDayIn(TimeZone.currentSystemDefault()).toLocalDateTime(TimeZone.currentSystemDefault())
            val endDateTime = period.endDate.atTime(23, 59, 59)
            
            // Get all transactions in the period
            val transactions = transactionDao.getTransactionsByDateRange("", startDateTime, endDateTime).first()
            
            // Calculate total income (positive amounts) and expenses (negative amounts)
            val totalIncome = transactions.filter { it.amount > 0 }.sumOf { it.amount }
            val totalExpenses = abs(transactions.filter { it.amount < 0 }.sumOf { it.amount })
            
            val chartData = ChartData(
                labels = listOf("Income", "Expenses"),
                datasets = listOf(
                    Dataset(
                        label = "Amount",
                        data = listOf(totalIncome, totalExpenses),
                        color = "#4CAF50" // Green for income, will be handled in UI for expenses
                    )
                )
            )
            
            Result.success(chartData)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun calculateTrends(period: DateRange): Result<TrendAnalysis> {
        return try {
            val trends = mutableListOf<Trend>()
            
            // Calculate spending trends by comparing current period with previous period
            val currentPeriodStart = period.startDate.atStartOfDayIn(TimeZone.currentSystemDefault()).toLocalDateTime(TimeZone.currentSystemDefault())
            val currentPeriodEnd = period.endDate.atTime(23, 59, 59)
            
            // Calculate previous period (same duration)
            val periodDays = period.endDate.toEpochDays() - period.startDate.toEpochDays()
            val previousPeriodEnd = LocalDate.fromEpochDays(period.startDate.toEpochDays() - 1)
            val previousPeriodStart = LocalDate.fromEpochDays(previousPeriodEnd.toEpochDays() - periodDays)
            
            val previousStartDateTime = previousPeriodStart.atStartOfDayIn(TimeZone.currentSystemDefault()).toLocalDateTime(TimeZone.currentSystemDefault())
            val previousEndDateTime = previousPeriodEnd.atTime(23, 59, 59)
            
            // Get transactions for both periods
            val currentTransactions = transactionDao.getTransactionsByDateRange("", currentPeriodStart, currentPeriodEnd).first()
            val previousTransactions = transactionDao.getTransactionsByDateRange("", previousStartDateTime, previousEndDateTime).first()
            
            // Calculate current and previous spending
            val currentSpending = abs(currentTransactions.filter { it.amount < 0 }.sumOf { it.amount })
            val previousSpending = abs(previousTransactions.filter { it.amount < 0 }.sumOf { it.amount })
            
            // Calculate trend
            val spendingTrend = when {
                previousSpending == 0.0 && currentSpending > 0.0 -> Trend(
                    category = "Overall Spending",
                    direction = TrendDirection.INCREASING,
                    changePercentage = 100.0,
                    description = "Spending has increased significantly"
                )
                previousSpending == 0.0 -> Trend(
                    category = "Overall Spending",
                    direction = TrendDirection.STABLE,
                    changePercentage = 0.0,
                    description = "No spending recorded in either period"
                )
                else -> {
                    val changePercentage = ((currentSpending - previousSpending) / previousSpending) * 100
                    val direction = when {
                        changePercentage > 5 -> TrendDirection.INCREASING
                        changePercentage < -5 -> TrendDirection.DECREASING
                        else -> TrendDirection.STABLE
                    }
                    val description = when (direction) {
                        TrendDirection.INCREASING -> "Spending has increased by ${String.format("%.1f", changePercentage)}%"
                        TrendDirection.DECREASING -> "Spending has decreased by ${String.format("%.1f", abs(changePercentage))}%"
                        TrendDirection.STABLE -> "Spending patterns are stable"
                    }
                    Trend(
                        category = "Overall Spending",
                        direction = direction,
                        changePercentage = changePercentage,
                        description = description
                    )
                }
            }
            trends.add(spendingTrend)
            
            // Generate insights based on trends
            val insights = mutableListOf<String>()
            when (spendingTrend.direction) {
                TrendDirection.INCREASING -> {
                    insights.add("Your spending has increased. Consider reviewing your budget.")
                    insights.add("Look for areas where you can reduce expenses.")
                }
                TrendDirection.DECREASING -> {
                    insights.add("Great job! Your spending has decreased.")
                    insights.add("Keep up the good financial habits.")
                }
                TrendDirection.STABLE -> {
                    insights.add("Your spending patterns are consistent.")
                    insights.add("Consider setting savings goals to improve your financial health.")
                }
            }
            
            val trendAnalysis = TrendAnalysis(
                period = period,
                trends = trends,
                insights = insights
            )
            
            Result.success(trendAnalysis)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getBudgetUtilization(): Result<List<BudgetUtilization>> {
        return try {
            val budgets = budgetDao.getAllBudgets("").first()
            val budgetUtilizations = mutableListOf<BudgetUtilization>()
            
            for (budget in budgets) {
                // Calculate current month spending for this category
                val today = kotlinx.datetime.Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
                val startOfMonth = LocalDate(today.year, today.month, 1)
                val startDateTime = startOfMonth.atStartOfDayIn(TimeZone.currentSystemDefault()).toLocalDateTime(TimeZone.currentSystemDefault())
                val endDateTime = today.atTime(23, 59, 59)
                
                val categoryTransactions = transactionDao.getTransactionsByCategory("", budget.categoryId).first()
                val monthlySpending = abs(categoryTransactions
                    .filter { it.date >= startDateTime && it.date <= endDateTime && it.amount < 0 }
                    .sumOf { it.amount })
                
                val utilizationPercentage = if (budget.amount > 0) {
                    (monthlySpending / budget.amount) * 100
                } else {
                    0.0
                }
                
                val remainingAmount = budget.amount - monthlySpending
                
                val status = when {
                    utilizationPercentage >= 100 -> BudgetStatus.OVER_BUDGET
                    utilizationPercentage >= budget.alertThreshold * 100 -> BudgetStatus.APPROACHING_LIMIT
                    else -> BudgetStatus.ON_TRACK
                }
                
                // Get category name
                val category = categoryDao.getCategoryById(budget.categoryId)
                val categoryName = category?.name ?: budget.categoryId
                
                budgetUtilizations.add(
                    BudgetUtilization(
                        budgetId = budget.id,
                        categoryId = budget.categoryId,
                        categoryName = categoryName,
                        budgetAmount = budget.amount,
                        spentAmount = monthlySpending,
                        utilizationPercentage = utilizationPercentage,
                        remainingAmount = remainingAmount,
                        status = status
                    )
                )
            }
            
            Result.success(budgetUtilizations)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun detectSpendingBehaviorChanges(period: DateRange): Result<List<String>> {
        return try {
            val insights = mutableListOf<String>()
            
            val startDateTime = period.startDate.atStartOfDayIn(TimeZone.currentSystemDefault()).toLocalDateTime(TimeZone.currentSystemDefault())
            val endDateTime = period.endDate.atTime(23, 59, 59)
            
            val transactions = transactionDao.getTransactionsByDateRange("", startDateTime, endDateTime).first()
            val expenses = transactions.filter { it.amount < 0 }
            
            if (expenses.isEmpty()) {
                insights.add("No expenses recorded in this period")
                return Result.success(insights)
            }
            
            // Analyze spending patterns
            val categorySpending = expenses.groupBy { it.categoryId }
                .mapValues { (_, transactions) -> abs(transactions.sumOf { it.amount }) }
            
            val totalSpending = categorySpending.values.sum()
            val topCategory = categorySpending.maxByOrNull { it.value }
            
            topCategory?.let { (categoryId, amount) ->
                val category = categoryDao.getCategoryById(categoryId)
                val categoryName = category?.name ?: categoryId
                val percentage = (amount / totalSpending) * 100
                
                insights.add("Your highest spending category is $categoryName (${String.format("%.1f", percentage)}%)")
                
                if (percentage > 40) {
                    insights.add("Consider reviewing your $categoryName expenses as they represent a large portion of your spending")
                }
            }
            
            // Check for unusual spending patterns
            val averageTransactionAmount = abs(expenses.sumOf { it.amount }) / expenses.size
            val largeTransactions = expenses.filter { abs(it.amount) > averageTransactionAmount * 2 }
            
            if (largeTransactions.isNotEmpty()) {
                insights.add("You had ${largeTransactions.size} unusually large transactions this period")
            }
            
            // Provide general insights
            insights.add("Track your expenses regularly to maintain financial health")
            insights.add("Consider setting budgets for your top spending categories")
            
            Result.success(insights)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}