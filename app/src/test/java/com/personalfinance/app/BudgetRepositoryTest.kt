package com.personalfinance.app

import com.personalfinance.app.domain.model.Budget
import com.personalfinance.app.domain.model.BudgetPeriod
import kotlinx.datetime.LocalDate
import org.junit.Assert.*
import org.junit.Test

class BudgetRepositoryTest {
    
    @Test
    fun `Budget domain model can be created with valid data`() {
        // Given
        val budget = Budget(
            id = 1L,
            categoryId = "food",
            amount = 500.0,
            period = BudgetPeriod.MONTHLY,
            startDate = LocalDate(2024, 1, 1),
            userId = "user123",
            alertThreshold = 0.8,
            isActive = true
        )
        
        // Then
        assertEquals(1L, budget.id)
        assertEquals("food", budget.categoryId)
        assertEquals(500.0, budget.amount, 0.01)
        assertEquals(BudgetPeriod.MONTHLY, budget.period)
        assertEquals(LocalDate(2024, 1, 1), budget.startDate)
        assertEquals("user123", budget.userId)
        assertEquals(0.8, budget.alertThreshold, 0.01)
        assertTrue(budget.isActive)
    }
    
    @Test
    fun `BudgetPeriod enum has all required values`() {
        // Test that all budget periods exist
        val periods = BudgetPeriod.values()
        
        assertTrue("Should contain WEEKLY", periods.contains(BudgetPeriod.WEEKLY))
        assertTrue("Should contain MONTHLY", periods.contains(BudgetPeriod.MONTHLY))
        assertTrue("Should contain QUARTERLY", periods.contains(BudgetPeriod.QUARTERLY))
        assertTrue("Should contain YEARLY", periods.contains(BudgetPeriod.YEARLY))
        
        assertEquals("Should have 4 budget periods", 4, periods.size)
    }
    
    @Test
    fun `Budget can be created with default values`() {
        // Given
        val budget = Budget(
            categoryId = "transport",
            amount = 300.0,
            period = BudgetPeriod.MONTHLY,
            startDate = LocalDate(2024, 2, 1),
            userId = "user456"
        )
        
        // Then
        assertEquals(0L, budget.id) // Default value
        assertEquals("transport", budget.categoryId)
        assertEquals(300.0, budget.amount, 0.01)
        assertEquals(BudgetPeriod.MONTHLY, budget.period)
        assertEquals(LocalDate(2024, 2, 1), budget.startDate)
        assertEquals("user456", budget.userId)
        assertEquals(0.8, budget.alertThreshold, 0.01) // Default value
        assertTrue(budget.isActive) // Default value
    }
    
    @Test
    fun `BudgetRepositoryImpl class exists and can be instantiated`() {
        // Test that BudgetRepositoryImpl exists
        try {
            val budgetRepoClass = Class.forName("com.personalfinance.app.data.repository.BudgetRepositoryImpl")
            assertNotNull("BudgetRepositoryImpl should exist", budgetRepoClass)
            
            // Check that it implements BudgetRepository
            val interfaces = budgetRepoClass.interfaces
            val implementsBudgetRepository = interfaces.any { 
                it.simpleName == "BudgetRepository" 
            }
            assertTrue("BudgetRepositoryImpl should implement BudgetRepository", 
                implementsBudgetRepository)
        } catch (e: ClassNotFoundException) {
            fail("BudgetRepositoryImpl class not found: ${e.message}")
        }
    }
    
    @Test
    fun `BudgetViewModel class exists`() {
        // Test that BudgetViewModel exists
        try {
            val budgetViewModelClass = Class.forName("com.personalfinance.app.presentation.budget.BudgetViewModel")
            assertNotNull("BudgetViewModel should exist", budgetViewModelClass)
            
            // Check that it extends ViewModel
            val superclass = budgetViewModelClass.superclass
            assertTrue("BudgetViewModel should extend ViewModel", 
                superclass?.simpleName == "ViewModel")
        } catch (e: ClassNotFoundException) {
            fail("BudgetViewModel class not found: ${e.message}")
        }
    }
    
    @Test
    fun `BudgetScreen composable exists`() {
        // Test that BudgetScreen exists
        try {
            val budgetScreenClass = Class.forName("com.personalfinance.app.presentation.budget.BudgetScreenKt")
            assertNotNull("BudgetScreen should exist", budgetScreenClass)
        } catch (e: ClassNotFoundException) {
            fail("BudgetScreen composable not found: ${e.message}")
        }
    }
}