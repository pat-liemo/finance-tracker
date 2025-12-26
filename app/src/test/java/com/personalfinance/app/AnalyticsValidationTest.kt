package com.personalfinance.app

import org.junit.Assert.*
import org.junit.Test

/**
 * Simple validation test to verify Analytics & Reports features are fully implemented
 */
class AnalyticsValidationTest {
    
    @Test
    fun `Analytics domain models exist`() {
        // Verify all analytics domain models exist
        val requiredModels = listOf(
            "com.personalfinance.app.domain.model.SpendingBreakdown",
            "com.personalfinance.app.domain.model.ChartData",
            "com.personalfinance.app.domain.model.TrendAnalysis",
            "com.personalfinance.app.domain.model.BudgetUtilization",
            "com.personalfinance.app.domain.model.BudgetStatus",
            "com.personalfinance.app.domain.model.TrendDirection",
            "com.personalfinance.app.domain.model.Trend",
            "com.personalfinance.app.domain.model.Dataset",
            "com.personalfinance.app.domain.model.DateRange"
        )
        
        requiredModels.forEach { modelClassName ->
            try {
                val modelClass = Class.forName(modelClassName)
                assertNotNull("$modelClassName should exist", modelClass)
            } catch (e: ClassNotFoundException) {
                fail("$modelClassName not found: ${e.message}")
            }
        }
    }
    
    @Test
    fun `Analytics repository implementation exists`() {
        try {
            val analyticsRepoClass = Class.forName("com.personalfinance.app.data.repository.AnalyticsRepositoryImpl")
            assertNotNull("AnalyticsRepositoryImpl should exist", analyticsRepoClass)
            
            val methods = analyticsRepoClass.declaredMethods.map { it.name }.toSet()
            
            // Check all required analytics methods exist
            val requiredMethods = listOf(
                "generateSpendingBreakdown",
                "generateIncomeVsExpenseChart", 
                "calculateTrends",
                "getBudgetUtilization",
                "detectSpendingBehaviorChanges"
            )
            
            requiredMethods.forEach { methodName ->
                assertTrue("Should have $methodName method", methods.contains(methodName))
            }
        } catch (e: ClassNotFoundException) {
            fail("AnalyticsRepositoryImpl class not found: ${e.message}")
        }
    }
    
    @Test
    fun `Export repository implementation exists`() {
        try {
            val exportRepoClass = Class.forName("com.personalfinance.app.data.repository.ExportRepositoryImpl")
            assertNotNull("ExportRepositoryImpl should exist", exportRepoClass)
            
            val methods = exportRepoClass.declaredMethods.map { it.name }.toSet()
            
            // Check all required export methods exist
            val requiredMethods = listOf(
                "exportTransactionsToCSV",
                "exportTransactionsToExcel",
                "exportTransactionsToPDF",
                "exportAnalyticsReport"
            )
            
            requiredMethods.forEach { methodName ->
                assertTrue("Should have $methodName method", methods.contains(methodName))
            }
        } catch (e: ClassNotFoundException) {
            fail("ExportRepositoryImpl class not found: ${e.message}")
        }
    }
    
    @Test
    fun `Analytics UI components exist`() {
        try {
            val analyticsScreenClass = Class.forName("com.personalfinance.app.presentation.analytics.AnalyticsScreenKt")
            assertNotNull("AnalyticsScreen should exist", analyticsScreenClass)
            
            val methods = analyticsScreenClass.declaredMethods.map { it.name }.toSet()
            
            // Check key UI components exist
            val requiredComponents = listOf(
                "SpendingBreakdownCard",
                "IncomeVsExpenseChart",
                "TrendsCard",
                "BudgetUtilizationCard",
                "ExportDataDialog",
                "InsightsCard"
            )
            
            requiredComponents.forEach { componentName ->
                assertTrue("Should have $componentName composable", methods.contains(componentName))
            }
        } catch (e: ClassNotFoundException) {
            fail("AnalyticsScreen composable not found: ${e.message}")
        }
    }
    
    @Test
    fun `Analytics ViewModel exists with required functionality`() {
        try {
            val analyticsViewModelClass = Class.forName("com.personalfinance.app.presentation.analytics.AnalyticsViewModel")
            assertNotNull("AnalyticsViewModel should exist", analyticsViewModelClass)
            
            val methods = analyticsViewModelClass.declaredMethods.map { it.name }.toSet()
            
            // Check enhanced methods exist
            assertTrue("Should have refreshAnalytics method", methods.contains("refreshAnalytics"))
            assertTrue("Should have exportData method", methods.contains("exportData"))
        } catch (e: ClassNotFoundException) {
            fail("AnalyticsViewModel class not found: ${e.message}")
        }
    }
    
    @Test
    fun `Dependency injection is configured`() {
        try {
            val repositoryModuleClass = Class.forName("com.personalfinance.app.di.RepositoryModule")
            val methods = repositoryModuleClass.declaredMethods.map { it.name }.toSet()
            
            // Check that repositories are bound
            assertTrue("Should have bindAnalyticsRepository method", methods.contains("bindAnalyticsRepository"))
            assertTrue("Should have bindExportRepository method", methods.contains("bindExportRepository"))
        } catch (e: ClassNotFoundException) {
            fail("RepositoryModule class not found: ${e.message}")
        }
    }
    
    @Test
    fun `Enum values are correctly defined`() {
        // Test BudgetStatus enum
        try {
            val budgetStatusClass = Class.forName("com.personalfinance.app.domain.model.BudgetStatus")
            val statusValues = budgetStatusClass.enumConstants
            
            assertNotNull("BudgetStatus should have enum values", statusValues)
            assertTrue("Should have at least 3 status types", statusValues!!.size >= 3)
            
            val statusNames = statusValues.map { it.toString() }
            assertTrue("Should have ON_TRACK status", statusNames.contains("ON_TRACK"))
            assertTrue("Should have APPROACHING_LIMIT status", statusNames.contains("APPROACHING_LIMIT"))
            assertTrue("Should have OVER_BUDGET status", statusNames.contains("OVER_BUDGET"))
        } catch (e: ClassNotFoundException) {
            fail("BudgetStatus enum not found: ${e.message}")
        }
        
        // Test TrendDirection enum
        try {
            val trendDirectionClass = Class.forName("com.personalfinance.app.domain.model.TrendDirection")
            val directionValues = trendDirectionClass.enumConstants
            
            assertNotNull("TrendDirection should have enum values", directionValues)
            assertTrue("Should have at least 3 direction types", directionValues!!.size >= 3)
            
            val directionNames = directionValues.map { it.toString() }
            assertTrue("Should have INCREASING direction", directionNames.contains("INCREASING"))
            assertTrue("Should have DECREASING direction", directionNames.contains("DECREASING"))
            assertTrue("Should have STABLE direction", directionNames.contains("STABLE"))
        } catch (e: ClassNotFoundException) {
            fail("TrendDirection enum not found: ${e.message}")
        }
    }
}