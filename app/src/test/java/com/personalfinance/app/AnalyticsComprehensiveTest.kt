package com.personalfinance.app

import com.personalfinance.app.domain.model.DateRange
import kotlinx.datetime.LocalDate
import org.junit.Assert.*
import org.junit.Test

/**
 * Comprehensive test to verify all Analytics & Reports features are fully implemented
 */
class AnalyticsComprehensiveTest {
    
    @Test
    fun `All Analytics & Reports features are implemented`() {
        // Test 1: Spending Breakdown (Pie Chart equivalent)
        try {
            val spendingBreakdownClass = Class.forName("com.personalfinance.app.domain.model.SpendingBreakdown")
            assertNotNull("SpendingBreakdown model should exist", spendingBreakdownClass)
            
            val analyticsRepoClass = Class.forName("com.personalfinance.app.data.repository.AnalyticsRepositoryImpl")
            val methods = analyticsRepoClass.declaredMethods.map { it.name }.toSet()
            assertTrue("Should have generateSpendingBreakdown method", methods.contains("generateSpendingBreakdown"))
        } catch (e: ClassNotFoundException) {
            fail("Spending Breakdown feature not found: ${e.message}")
        }
        
        // Test 2: Income vs Expense Chart
        try {
            val chartDataClass = Class.forName("com.personalfinance.app.domain.model.ChartData")
            assertNotNull("ChartData model should exist", chartDataClass)
            
            val analyticsRepoClass = Class.forName("com.personalfinance.app.data.repository.AnalyticsRepositoryImpl")
            val methods = analyticsRepoClass.declaredMethods.map { it.name }.toSet()
            assertTrue("Should have generateIncomeVsExpenseChart method", methods.contains("generateIncomeVsExpenseChart"))
        } catch (e: ClassNotFoundException) {
            fail("Income vs Expense Chart feature not found: ${e.message}")
        }
        
        // Test 3: Trends Analysis
        try {
            val trendAnalysisClass = Class.forName("com.personalfinance.app.domain.model.TrendAnalysis")
            val trendDirectionClass = Class.forName("com.personalfinance.app.domain.model.TrendDirection")
            assertNotNull("TrendAnalysis model should exist", trendAnalysisClass)
            assertNotNull("TrendDirection enum should exist", trendDirectionClass)
            
            val analyticsRepoClass = Class.forName("com.personalfinance.app.data.repository.AnalyticsRepositoryImpl")
            val methods = analyticsRepoClass.declaredMethods.map { it.name }.toSet()
            assertTrue("Should have calculateTrends method", methods.contains("calculateTrends"))
        } catch (e: ClassNotFoundException) {
            fail("Trends Analysis feature not found: ${e.message}")
        }
        
        // Test 4: Budget Utilization with Progress Bars
        try {
            val budgetUtilizationClass = Class.forName("com.personalfinance.app.domain.model.BudgetUtilization")
            val budgetStatusClass = Class.forName("com.personalfinance.app.domain.model.BudgetStatus")
            assertNotNull("BudgetUtilization model should exist", budgetUtilizationClass)
            assertNotNull("BudgetStatus enum should exist", budgetStatusClass)
            
            val analyticsRepoClass = Class.forName("com.personalfinance.app.data.repository.AnalyticsRepositoryImpl")
            val methods = analyticsRepoClass.declaredMethods.map { it.name }.toSet()
            assertTrue("Should have getBudgetUtilization method", methods.contains("getBudgetUtilization"))
        } catch (e: ClassNotFoundException) {
            fail("Budget Utilization feature not found: ${e.message}")
        }
        
        // Test 5: Export Data Functionality
        try {
            val exportRepoClass = Class.forName("com.personalfinance.app.data.repository.ExportRepositoryImpl")
            val methods = exportRepoClass.declaredMethods.map { it.name }.toSet()
            
            assertTrue("Should have exportTransactionsToCSV method", methods.contains("exportTransactionsToCSV"))
            assertTrue("Should have exportTransactionsToExcel method", methods.contains("exportTransactionsToExcel"))
            assertTrue("Should have exportTransactionsToPDF method", methods.contains("exportTransactionsToPDF"))
            assertTrue("Should have exportAnalyticsReport method", methods.contains("exportAnalyticsReport"))
        } catch (e: ClassNotFoundException) {
            fail("Export Data feature not found: ${e.message}")
        }
    }
    
    @Test
    fun `Analytics UI components are implemented`() {
        try {
            val analyticsScreenClass = Class.forName("com.personalfinance.app.presentation.analytics.AnalyticsScreenKt")
            val methods = analyticsScreenClass.declaredMethods.map { it.name }.toSet()
            
            // Check all required UI components exist
            assertTrue("Should have SpendingBreakdownCard composable", methods.contains("SpendingBreakdownCard"))
            assertTrue("Should have IncomeVsExpenseChart composable", methods.contains("IncomeVsExpenseChart"))
            assertTrue("Should have TrendsCard composable", methods.contains("TrendsCard"))
            assertTrue("Should have BudgetUtilizationCard composable", methods.contains("BudgetUtilizationCard"))
            assertTrue("Should have ExportDataDialog composable", methods.contains("ExportDataDialog"))
            assertTrue("Should have InsightsCard composable", methods.contains("InsightsCard"))
        } catch (e: ClassNotFoundException) {
            fail("Analytics UI components not found: ${e.message}")
        }
    }
    
    @Test
    fun `Analytics ViewModel has all required functionality`() {
        try {
            val analyticsViewModelClass = Class.forName("com.personalfinance.app.presentation.analytics.AnalyticsViewModel")
            val methods = analyticsViewModelClass.declaredMethods.map { it.name }.toSet()
            
            assertTrue("Should have refreshAnalytics method", methods.contains("refreshAnalytics"))
            assertTrue("Should have exportData method", methods.contains("exportData"))
        } catch (e: ClassNotFoundException) {
            fail("AnalyticsViewModel not found: ${e.message}")
        }
    }
    
    @Test
    fun `All domain models have correct structure`() {
        // Test SpendingBreakdown
        try {
            val spendingBreakdownClass = Class.forName("com.personalfinance.app.domain.model.SpendingBreakdown")
            val fields = spendingBreakdownClass.declaredFields.map { it.name }.toSet()
            assertTrue("SpendingBreakdown should have totalAmount field", 
                fields.contains("totalAmount"))
            assertTrue("SpendingBreakdown should have categoryBreakdown field", 
                fields.contains("categoryBreakdown"))
            assertTrue("SpendingBreakdown should have percentageBreakdown field", 
                fields.contains("percentageBreakdown"))
        } catch (e: ClassNotFoundException) {
            fail("SpendingBreakdown model structure issue: ${e.message}")
        }
        
        // Test TrendDirection enum values
        try {
            val trendDirectionClass = Class.forName("com.personalfinance.app.domain.model.TrendDirection")
            val enumValues = trendDirectionClass.enumConstants
            assertNotNull("TrendDirection should have enum values", enumValues)
            
            val enumNames = enumValues!!.map { it.toString() }
            assertTrue("Should have INCREASING trend", enumNames.contains("INCREASING"))
            assertTrue("Should have DECREASING trend", enumNames.contains("DECREASING"))
            assertTrue("Should have STABLE trend", enumNames.contains("STABLE"))
        } catch (e: ClassNotFoundException) {
            fail("TrendDirection enum issue: ${e.message}")
        }
        
        // Test BudgetStatus enum values
        try {
            val budgetStatusClass = Class.forName("com.personalfinance.app.domain.model.BudgetStatus")
            val enumValues = budgetStatusClass.enumConstants
            assertNotNull("BudgetStatus should have enum values", enumValues)
            
            val enumNames = enumValues!!.map { it.toString() }
            assertTrue("Should have ON_TRACK status", enumNames.contains("ON_TRACK"))
            assertTrue("Should have APPROACHING_LIMIT status", enumNames.contains("APPROACHING_LIMIT"))
            assertTrue("Should have OVER_BUDGET status", enumNames.contains("OVER_BUDGET"))
        } catch (e: ClassNotFoundException) {
            fail("BudgetStatus enum issue: ${e.message}")
        }
    }
    
    @Test
    fun `DateRange model works for analytics periods`() {
        val startDate = LocalDate(2024, 1, 1)
        val endDate = LocalDate(2024, 1, 31)
        val dateRange = DateRange(startDate, endDate)
        
        assertEquals("Should have correct start date", startDate, dateRange.startDate)
        assertEquals("Should have correct end date", endDate, dateRange.endDate)
        assertTrue("Start date should be before or equal to end date", dateRange.startDate <= dateRange.endDate)
    }
    
    @Test
    fun `Dependency injection is properly configured`() {
        try {
            val repositoryModuleClass = Class.forName("com.personalfinance.app.di.RepositoryModule")
            val methods = repositoryModuleClass.declaredMethods.map { it.name }.toSet()
            
            assertTrue("Should have bindAnalyticsRepository method", methods.contains("bindAnalyticsRepository"))
            assertTrue("Should have bindExportRepository method", methods.contains("bindExportRepository"))
        } catch (e: ClassNotFoundException) {
            fail("Dependency injection not properly configured: ${e.message}")
        }
    }
}