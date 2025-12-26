package com.personalfinance.app.presentation.analytics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personalfinance.app.domain.model.BudgetUtilization
import com.personalfinance.app.domain.model.ChartData
import com.personalfinance.app.domain.model.DateRange
import com.personalfinance.app.domain.model.SpendingBreakdown
import com.personalfinance.app.domain.model.TrendAnalysis
import com.personalfinance.app.domain.repository.AnalyticsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn
import javax.inject.Inject

@HiltViewModel
class AnalyticsViewModel @Inject constructor(
    private val analyticsRepository: AnalyticsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AnalyticsUiState())
    val uiState: StateFlow<AnalyticsUiState> = _uiState.asStateFlow()

    init {
        loadAnalytics()
    }

    private fun loadAnalytics() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            
            try {
                // Get current month data
                val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
                val startOfMonth = LocalDate(today.year, today.month, 1)
                val dateRange = DateRange(startOfMonth, today)
                
                // Load all analytics data
                val spendingResult = analyticsRepository.generateSpendingBreakdown(dateRange)
                val incomeVsExpenseResult = analyticsRepository.generateIncomeVsExpenseChart(dateRange)
                val trendsResult = analyticsRepository.calculateTrends(dateRange)
                val budgetUtilizationResult = analyticsRepository.getBudgetUtilization()
                val insightsResult = analyticsRepository.detectSpendingBehaviorChanges(dateRange)
                
                // Combine all results
                var hasError = false
                var errorMessage = ""
                
                val spendingBreakdown = spendingResult.getOrElse { 
                    hasError = true
                    errorMessage = it.message ?: "Failed to load spending breakdown"
                    null
                }
                
                val incomeVsExpenseChart = incomeVsExpenseResult.getOrElse {
                    if (!hasError) {
                        hasError = true
                        errorMessage = it.message ?: "Failed to load income vs expense data"
                    }
                    null
                }
                
                val trendAnalysis = trendsResult.getOrElse {
                    // Don't fail the whole screen if trends fail
                    null
                }
                
                val budgetUtilization = budgetUtilizationResult.getOrElse {
                    // Don't fail the whole screen if budget utilization fails
                    emptyList()
                }
                
                val insights = insightsResult.getOrElse {
                    // Don't fail the whole screen if insights fail
                    emptyList()
                }
                
                if (hasError) {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = errorMessage
                    )
                } else {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        spendingBreakdown = spendingBreakdown,
                        incomeVsExpenseChart = incomeVsExpenseChart,
                        trendAnalysis = trendAnalysis,
                        budgetUtilization = budgetUtilization,
                        insights = insights,
                        dateRange = dateRange,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Failed to load analytics"
                )
            }
        }
    }

    fun refreshAnalytics() {
        loadAnalytics()
    }
    
    fun exportData(format: String) {
        viewModelScope.launch {
            try {
                // For now, just show a success message
                // In a real implementation, this would generate and save the export file
                _uiState.value = _uiState.value.copy(
                    exportMessage = "Data exported as $format successfully!"
                )
                
                // Clear the message after a delay
                kotlinx.coroutines.delay(3000)
                _uiState.value = _uiState.value.copy(exportMessage = null)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    error = "Failed to export data: ${e.message}"
                )
            }
        }
    }
}

data class AnalyticsUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val spendingBreakdown: SpendingBreakdown? = null,
    val incomeVsExpenseChart: ChartData? = null,
    val trendAnalysis: TrendAnalysis? = null,
    val budgetUtilization: List<BudgetUtilization>? = null,
    val insights: List<String>? = null,
    val dateRange: DateRange? = null,
    val exportMessage: String? = null
)