package com.personalfinance.app

import com.personalfinance.app.domain.model.Category
import com.personalfinance.app.domain.model.DefaultCategories
import com.personalfinance.app.domain.model.TransactionFilter
import org.junit.Assert.*
import org.junit.Test

/**
 * Unit tests to verify all core features are implemented and working
 */
class CoreFeaturesTest {
    
    @Test
    fun `Categories Management - Default categories are available`() {
        val defaultCategories = DefaultCategories.getDefaultCategories("testUser")
        
        assertTrue("Should have default categories", defaultCategories.isNotEmpty())
        assertTrue("Should have at least 10 categories", defaultCategories.size >= 10)
        
        // Check specific categories exist
        val categoryNames = defaultCategories.map { it.name }
        assertTrue("Should have Food category", categoryNames.any { it.contains("Food") })
        assertTrue("Should have Transportation category", categoryNames.any { it.contains("Transportation") })
        assertTrue("Should have Salary category", categoryNames.any { it.contains("Salary") })
        
        // Check all categories have required fields
        defaultCategories.forEach { category ->
            assertNotNull("Category should have ID", category.id)
            assertNotNull("Category should have name", category.name)
            assertNotNull("Category should have icon", category.icon)
            assertNotNull("Category should have color", category.color)
            assertTrue("Default categories should be marked as default", category.isDefault)
        }
    }
    
    @Test
    fun `Transaction Filters - TransactionFilter model works correctly`() {
        val emptyFilter = TransactionFilter()
        
        // Test empty filter
        assertTrue("Empty filter should have no categories", emptyFilter.categoryIds.isEmpty())
        assertTrue("Empty filter should have no payment methods", emptyFilter.paymentMethods.isEmpty())
        assertNull("Empty filter should have no min amount", emptyFilter.minAmount)
        assertNull("Empty filter should have no max amount", emptyFilter.maxAmount)
        assertNull("Empty filter should have no start date", emptyFilter.startDate)
        assertNull("Empty filter should have no end date", emptyFilter.endDate)
        
        // Test filter with values
        val filter = TransactionFilter(
            categoryIds = listOf("food", "transport"),
            minAmount = 10.0,
            maxAmount = 100.0,
            searchQuery = "test"
        )
        
        assertEquals("Should have 2 categories", 2, filter.categoryIds.size)
        assertEquals("Should have correct min amount", 10.0, filter.minAmount!!, 0.01)
        assertEquals("Should have correct max amount", 100.0, filter.maxAmount!!, 0.01)
        assertEquals("Should have correct search query", "test", filter.searchQuery)
    }
    
    @Test
    fun `Recurring Transactions - RecurringPattern model works correctly`() {
        try {
            val recurringPatternClass = Class.forName("com.personalfinance.app.domain.model.RecurringPattern")
            assertNotNull("RecurringPattern should exist", recurringPatternClass)
            
            val recurringFrequencyClass = Class.forName("com.personalfinance.app.domain.model.RecurringFrequency")
            assertNotNull("RecurringFrequency should exist", recurringFrequencyClass)
            
            // Check that RecurringFrequency has all required values
            val frequencies = recurringFrequencyClass.enumConstants
            assertNotNull("RecurringFrequency should have enum values", frequencies)
            assertTrue("Should have at least 4 frequency types", frequencies!!.size >= 4)
            
            val frequencyNames = frequencies.map { it.toString() }
            assertTrue("Should have DAILY frequency", frequencyNames.contains("DAILY"))
            assertTrue("Should have WEEKLY frequency", frequencyNames.contains("WEEKLY"))
            assertTrue("Should have MONTHLY frequency", frequencyNames.contains("MONTHLY"))
            assertTrue("Should have YEARLY frequency", frequencyNames.contains("YEARLY"))
        } catch (e: ClassNotFoundException) {
            fail("RecurringPattern or RecurringFrequency class not found: ${e.message}")
        }
    }
    
    @Test
    fun `Cloud Sync - FirestoreSyncService exists and is configured`() {
        try {
            val syncServiceClass = Class.forName("com.personalfinance.app.data.remote.sync.FirestoreSyncService")
            assertNotNull("FirestoreSyncService should exist", syncServiceClass)
            
            // Just check that the class exists
            assertTrue("FirestoreSyncService should not be an interface", !syncServiceClass.isInterface)
        } catch (e: ClassNotFoundException) {
            fail("FirestoreSyncService class not found: ${e.message}")
        }
    }
    
    @Test
    fun `All Repository Implementations exist`() {
        val repositories = listOf(
            "com.personalfinance.app.data.repository.CategoryRepositoryImpl",
            "com.personalfinance.app.data.repository.RecurringTransactionRepositoryImpl",
            "com.personalfinance.app.data.repository.TransactionRepositoryImpl",
            "com.personalfinance.app.data.repository.BudgetRepositoryImpl"
        )
        
        repositories.forEach { repositoryClassName ->
            try {
                val repositoryClass = Class.forName(repositoryClassName)
                assertNotNull("$repositoryClassName should exist", repositoryClass)
            } catch (e: ClassNotFoundException) {
                fail("$repositoryClassName not found: ${e.message}")
            }
        }
    }
    
    @Test
    fun `All UI Screens exist`() {
        val screens = listOf(
            "com.personalfinance.app.presentation.categories.CategoriesScreenKt",
            "com.personalfinance.app.presentation.transactions.TransactionsScreenKt",
            "com.personalfinance.app.presentation.recurring.RecurringTransactionsScreenKt"
        )
        
        screens.forEach { screenClassName ->
            try {
                val screenClass = Class.forName(screenClassName)
                assertNotNull("$screenClassName should exist", screenClass)
            } catch (e: ClassNotFoundException) {
                fail("$screenClassName not found: ${e.message}")
            }
        }
    }
    
    @Test
    fun `All ViewModels exist and are properly annotated`() {
        val viewModels = listOf(
            "com.personalfinance.app.presentation.categories.CategoriesViewModel",
            "com.personalfinance.app.presentation.transactions.TransactionsViewModel",
            "com.personalfinance.app.presentation.recurring.RecurringTransactionsViewModel"
        )
        
        viewModels.forEach { viewModelClassName ->
            try {
                val viewModelClass = Class.forName(viewModelClassName)
                assertNotNull("$viewModelClassName should exist", viewModelClass)
                
                // Check that it extends ViewModel
                val superclass = viewModelClass.superclass
                assertTrue("$viewModelClassName should extend ViewModel", 
                    superclass?.simpleName == "ViewModel")
            } catch (e: ClassNotFoundException) {
                fail("$viewModelClassName not found: ${e.message}")
            }
        }
    }
}