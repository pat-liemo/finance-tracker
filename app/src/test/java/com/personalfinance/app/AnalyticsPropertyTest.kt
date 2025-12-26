package com.personalfinance.app

import com.personalfinance.app.data.local.dao.BudgetDao
import com.personalfinance.app.data.local.dao.CategoryDao
import com.personalfinance.app.data.local.dao.TransactionDao
import com.personalfinance.app.data.local.entity.CategoryEntity
import com.personalfinance.app.data.local.entity.TransactionEntity
import com.personalfinance.app.data.repository.AnalyticsRepositoryImpl
import com.personalfinance.app.domain.model.*
import io.kotest.property.Arb
import io.kotest.property.arbitrary.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import org.junit.Test
import org.junit.Assert.*
import org.mockito.kotlin.*
import kotlin.math.abs

/**
 * Property-based tests for analytics functionality
 * **Feature: personal-finance-app, Property 3: Analytics calculation accuracy**
 * **Validates: Requirements 7.1**
 */
class AnalyticsPropertyTest {

    @Test
    fun `Property 3 - Analytics calculation accuracy for spending breakdown`() = runTest {
        // Test with multiple sets of transaction data
        val testCases = generateTestCases()
        
        testCases.forEach { testCase ->
            val (transactions, categories, expectedTotalExpenses, expectedCategoryBreakdown) = testCase
            
            // Create mocks
            val transactionDao = mock<TransactionDao>()
            val categoryDao = mock<CategoryDao>()
            val budgetDao = mock<BudgetDao>()
            
            // Setup mock behavior
            whenever(transactionDao.getTransactionsByDateRange(any(), any(), any()))
                .thenReturn(flowOf(transactions))
            
            // Setup category lookup
            categories.forEach { category ->
                whenever(categoryDao.getCategoryById(category.id))
                    .thenReturn(category)
            }
            
            val analyticsRepository = AnalyticsRepositoryImpl(transactionDao, categoryDao, budgetDao)
            
            // Create test date range
            val dateRange = DateRange(
                LocalDate(2024, 1, 1),
                LocalDate(2024, 1, 31)
            )
            
            // When: generating spending breakdown
            val result = analyticsRepository.generateSpendingBreakdown(dateRange)
            
            // Then: result should be successful
            assertTrue("Analytics calculation should succeed", result.isSuccess)
            
            val spendingBreakdown = result.getOrNull()
            assertNotNull("Spending breakdown should not be null", spendingBreakdown)
            
            // Verify total expenses calculation
            assertEquals(
                "Total expenses should match expected value",
                expectedTotalExpenses,
                spendingBreakdown!!.totalAmount,
                0.01 // Allow small floating point differences
            )
            
            // Verify category breakdown
            expectedCategoryBreakdown.forEach { (categoryName, expectedAmount) ->
                val actualAmount = spendingBreakdown.categoryBreakdown[categoryName] ?: 0.0
                assertEquals(
                    "Category '$categoryName' amount should match expected",
                    expectedAmount,
                    actualAmount,
                    0.01
                )
            }
            
            // Verify percentage calculations
            if (expectedTotalExpenses > 0) {
                expectedCategoryBreakdown.forEach { (categoryName, expectedAmount) ->
                    val expectedPercentage = (expectedAmount / expectedTotalExpenses) * 100
                    val actualPercentage = spendingBreakdown.percentageBreakdown[categoryName] ?: 0.0
                    assertEquals(
                        "Category '$categoryName' percentage should match expected",
                        expectedPercentage,
                        actualPercentage,
                        0.01
                    )
                }
            }
            
            // Verify percentages sum to 100% (within tolerance)
            val totalPercentage = spendingBreakdown.percentageBreakdown.values.sum()
            if (expectedTotalExpenses > 0) {
                assertEquals(
                    "Total percentages should sum to 100%",
                    100.0,
                    totalPercentage,
                    0.01
                )
            } else {
                assertEquals(
                    "Total percentages should be 0% when no expenses",
                    0.0,
                    totalPercentage,
                    0.01
                )
            }
        }
    }
    
    @Test
    fun `Property 3 - Income vs expense chart accuracy`() = runTest {
        val testCases = generateIncomeExpenseTestCases()
        
        testCases.forEach { testCase ->
            val (transactions, expectedIncome, expectedExpenses) = testCase
            
            // Create mocks
            val transactionDao = mock<TransactionDao>()
            val categoryDao = mock<CategoryDao>()
            val budgetDao = mock<BudgetDao>()
            
            // Setup mock behavior
            whenever(transactionDao.getTransactionsByDateRange(any(), any(), any()))
                .thenReturn(flowOf(transactions))
            
            val analyticsRepository = AnalyticsRepositoryImpl(transactionDao, categoryDao, budgetDao)
            
            // Create test date range
            val dateRange = DateRange(
                LocalDate(2024, 1, 1),
                LocalDate(2024, 1, 31)
            )
            
            // When: generating income vs expense chart
            val result = analyticsRepository.generateIncomeVsExpenseChart(dateRange)
            
            // Then: result should be successful
            assertTrue("Income vs expense calculation should succeed", result.isSuccess)
            
            val chartData = result.getOrNull()
            assertNotNull("Chart data should not be null", chartData)
            
            // Verify chart structure
            assertEquals("Chart should have 2 labels", 2, chartData!!.labels.size)
            assertEquals("First label should be Income", "Income", chartData.labels[0])
            assertEquals("Second label should be Expenses", "Expenses", chartData.labels[1])
            
            assertEquals("Chart should have 1 dataset", 1, chartData.datasets.size)
            val dataset = chartData.datasets[0]
            assertEquals("Dataset should have 2 data points", 2, dataset.data.size)
            
            // Verify income calculation
            assertEquals(
                "Income should match expected value",
                expectedIncome,
                dataset.data[0],
                0.01
            )
            
            // Verify expense calculation
            assertEquals(
                "Expenses should match expected value",
                expectedExpenses,
                dataset.data[1],
                0.01
            )
        }
    }
    
    @Test
    fun `Property 3 - Empty transaction list handling`() = runTest {
        // Create mocks
        val transactionDao = mock<TransactionDao>()
        val categoryDao = mock<CategoryDao>()
        val budgetDao = mock<BudgetDao>()
        
        // Setup mock behavior for empty list
        whenever(transactionDao.getTransactionsByDateRange(any(), any(), any()))
            .thenReturn(flowOf(emptyList()))
        
        val analyticsRepository = AnalyticsRepositoryImpl(transactionDao, categoryDao, budgetDao)
        
        val dateRange = DateRange(
            LocalDate(2024, 1, 1),
            LocalDate(2024, 1, 31)
        )
        
        // When: generating spending breakdown with no transactions
        val spendingResult = analyticsRepository.generateSpendingBreakdown(dateRange)
        
        // Then: should handle empty case gracefully
        assertTrue("Spending breakdown should succeed with empty data", spendingResult.isSuccess)
        val spendingBreakdown = spendingResult.getOrNull()!!
        
        assertEquals("Total amount should be 0", 0.0, spendingBreakdown.totalAmount, 0.01)
        assertTrue("Category breakdown should be empty", spendingBreakdown.categoryBreakdown.isEmpty())
        assertTrue("Percentage breakdown should be empty", spendingBreakdown.percentageBreakdown.isEmpty())
        
        // When: generating income vs expense chart with no transactions
        val chartResult = analyticsRepository.generateIncomeVsExpenseChart(dateRange)
        
        // Then: should handle empty case gracefully
        assertTrue("Chart generation should succeed with empty data", chartResult.isSuccess)
        val chartData = chartResult.getOrNull()!!
        
        assertEquals("Income should be 0", 0.0, chartData.datasets[0].data[0], 0.01)
        assertEquals("Expenses should be 0", 0.0, chartData.datasets[0].data[1], 0.01)
    }
    
    private fun generateTestCases(): List<TestCase> {
        return listOf(
            // Test case 1: Simple case with different categories
            TestCase(
                transactions = listOf(
                    createTransaction(amount = -100.0, categoryId = "food"),
                    createTransaction(amount = -50.0, categoryId = "transport"),
                    createTransaction(amount = -30.0, categoryId = "food"),
                    createTransaction(amount = 200.0, categoryId = "salary") // Income, should be ignored
                ),
                categories = listOf(
                    createCategory(id = "food", name = "Food"),
                    createCategory(id = "transport", name = "Transport"),
                    createCategory(id = "salary", name = "Salary")
                ),
                expectedTotalExpenses = 180.0,
                expectedCategoryBreakdown = mapOf(
                    "Food" to 130.0,
                    "Transport" to 50.0
                )
            ),
            
            // Test case 2: Single category
            TestCase(
                transactions = listOf(
                    createTransaction(amount = -75.0, categoryId = "entertainment"),
                    createTransaction(amount = -25.0, categoryId = "entertainment")
                ),
                categories = listOf(
                    createCategory(id = "entertainment", name = "Entertainment")
                ),
                expectedTotalExpenses = 100.0,
                expectedCategoryBreakdown = mapOf(
                    "Entertainment" to 100.0
                )
            ),
            
            // Test case 3: Multiple categories with various amounts
            TestCase(
                transactions = listOf(
                    createTransaction(amount = -200.0, categoryId = "rent"),
                    createTransaction(amount = -80.0, categoryId = "groceries"),
                    createTransaction(amount = -40.0, categoryId = "utilities"),
                    createTransaction(amount = -60.0, categoryId = "groceries"),
                    createTransaction(amount = 1000.0, categoryId = "salary") // Income
                ),
                categories = listOf(
                    createCategory(id = "rent", name = "Rent"),
                    createCategory(id = "groceries", name = "Groceries"),
                    createCategory(id = "utilities", name = "Utilities"),
                    createCategory(id = "salary", name = "Salary")
                ),
                expectedTotalExpenses = 380.0,
                expectedCategoryBreakdown = mapOf(
                    "Rent" to 200.0,
                    "Groceries" to 140.0,
                    "Utilities" to 40.0
                )
            ),
            
            // Test case 4: Only income transactions (no expenses)
            TestCase(
                transactions = listOf(
                    createTransaction(amount = 1000.0, categoryId = "salary"),
                    createTransaction(amount = 500.0, categoryId = "bonus")
                ),
                categories = listOf(
                    createCategory(id = "salary", name = "Salary"),
                    createCategory(id = "bonus", name = "Bonus")
                ),
                expectedTotalExpenses = 0.0,
                expectedCategoryBreakdown = emptyMap()
            )
        )
    }
    
    private fun generateIncomeExpenseTestCases(): List<IncomeExpenseTestCase> {
        return listOf(
            // Test case 1: Mixed income and expenses
            IncomeExpenseTestCase(
                transactions = listOf(
                    createTransaction(amount = 1000.0, categoryId = "salary"),
                    createTransaction(amount = 500.0, categoryId = "freelance"),
                    createTransaction(amount = -200.0, categoryId = "rent"),
                    createTransaction(amount = -100.0, categoryId = "food"),
                    createTransaction(amount = -50.0, categoryId = "transport")
                ),
                expectedIncome = 1500.0,
                expectedExpenses = 350.0
            ),
            
            // Test case 2: Only income
            IncomeExpenseTestCase(
                transactions = listOf(
                    createTransaction(amount = 2000.0, categoryId = "salary"),
                    createTransaction(amount = 300.0, categoryId = "bonus")
                ),
                expectedIncome = 2300.0,
                expectedExpenses = 0.0
            ),
            
            // Test case 3: Only expenses
            IncomeExpenseTestCase(
                transactions = listOf(
                    createTransaction(amount = -150.0, categoryId = "groceries"),
                    createTransaction(amount = -80.0, categoryId = "utilities"),
                    createTransaction(amount = -200.0, categoryId = "rent")
                ),
                expectedIncome = 0.0,
                expectedExpenses = 430.0
            ),
            
            // Test case 4: Empty transactions
            IncomeExpenseTestCase(
                transactions = emptyList(),
                expectedIncome = 0.0,
                expectedExpenses = 0.0
            )
        )
    }
    
    private fun createTransaction(
        amount: Double,
        categoryId: String,
        id: Long = 0L
    ): TransactionEntity {
        return TransactionEntity(
            id = id,
            amount = amount,
            categoryId = categoryId,
            date = LocalDateTime(2024, 1, 15, 12, 0),
            description = "Test transaction",
            paymentMethod = PaymentMethod.CASH,
            tags = emptyList(),
            userId = "test-user",
            createdAt = System.currentTimeMillis(),
            updatedAt = System.currentTimeMillis()
        )
    }
    
    private fun createCategory(
        id: String,
        name: String
    ): CategoryEntity {
        return CategoryEntity(
            id = id,
            name = name,
            icon = "default",
            color = "#000000",
            isDefault = true,
            userId = "test-user",
            createdAt = System.currentTimeMillis(),
            updatedAt = System.currentTimeMillis()
        )
    }
    
    data class TestCase(
        val transactions: List<TransactionEntity>,
        val categories: List<CategoryEntity>,
        val expectedTotalExpenses: Double,
        val expectedCategoryBreakdown: Map<String, Double>
    )
    
    data class IncomeExpenseTestCase(
        val transactions: List<TransactionEntity>,
        val expectedIncome: Double,
        val expectedExpenses: Double
    )
}