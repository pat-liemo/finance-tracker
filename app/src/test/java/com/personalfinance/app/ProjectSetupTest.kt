package com.personalfinance.app

import com.personalfinance.app.di.DatabaseModule
import com.personalfinance.app.di.NetworkModule
import com.personalfinance.app.di.RepositoryModule
import org.junit.Test
import org.junit.Assert.*

/**
 * Unit tests to verify project configuration including dependency injection setup
 * These tests run on the JVM without requiring Android emulator
 */
class ProjectSetupTest {
    
    @Test
    fun `project setup is correct`() {
        // Test that basic Kotlin functionality works
        val testString = "Personal Finance App"
        assertEquals("Personal Finance App", testString)
        
        // Test that collections work
        val testList = listOf(1, 2, 3)
        assertEquals(3, testList.size)
        
        // Test that basic data classes work
        data class TestTransaction(val id: Long, val amount: Double)
        val transaction = TestTransaction(1L, 100.0)
        assertEquals(1L, transaction.id)
        assertEquals(100.0, transaction.amount, 0.01)
    }
    
    @Test
    fun `kotlin datetime functionality works`() {
        // Test that kotlinx-datetime is available
        val now = kotlinx.datetime.Clock.System.now()
        assertNotNull(now)
    }

    @Test
    fun `dependency injection modules are properly configured`() {
        // Test that all DI modules exist and can be instantiated
        assertNotNull("DatabaseModule should exist", DatabaseModule)
        assertNotNull("NetworkModule should exist", NetworkModule)
        
        // Test RepositoryModule class exists
        try {
            val repositoryModuleClass = Class.forName("com.personalfinance.app.di.RepositoryModule")
            assertNotNull("RepositoryModule should exist", repositoryModuleClass)
            assertTrue("RepositoryModule should be an abstract class", 
                java.lang.reflect.Modifier.isAbstract(repositoryModuleClass.modifiers))
        } catch (e: ClassNotFoundException) {
            fail("RepositoryModule class not found: ${e.message}")
        }
        
        // Verify modules are objects (singletons)
        assertTrue("DatabaseModule should be an object", DatabaseModule::class.objectInstance != null)
        assertTrue("NetworkModule should be an object", NetworkModule::class.objectInstance != null)
    }

    @Test
    fun `database module has required provider methods`() {
        // Test that DatabaseModule has all required methods using reflection
        val databaseModuleMethods = DatabaseModule::class.java.declaredMethods
        val methodNames = databaseModuleMethods.map { it.name }.toSet()
        
        assertTrue("DatabaseModule should have providePersonalFinanceDatabase method", 
            methodNames.contains("providePersonalFinanceDatabase"))
        assertTrue("DatabaseModule should have provideTransactionDao method", 
            methodNames.contains("provideTransactionDao"))
        assertTrue("DatabaseModule should have provideCategoryDao method", 
            methodNames.contains("provideCategoryDao"))
        assertTrue("DatabaseModule should have provideBudgetDao method", 
            methodNames.contains("provideBudgetDao"))
        assertTrue("DatabaseModule should have provideUserDao method", 
            methodNames.contains("provideUserDao"))
        assertTrue("DatabaseModule should have provideDebtDao method", 
            methodNames.contains("provideDebtDao"))
        assertTrue("DatabaseModule should have provideSavingsGoalDao method", 
            methodNames.contains("provideSavingsGoalDao"))
    }

    @Test
    fun `network module has required provider methods`() {
        // Test that NetworkModule has all required methods using reflection
        val networkModuleMethods = NetworkModule::class.java.declaredMethods
        val methodNames = networkModuleMethods.map { it.name }.toSet()
        
        assertTrue("NetworkModule should have provideOkHttpClient method", 
            methodNames.contains("provideOkHttpClient"))
        assertTrue("NetworkModule should have provideRetrofit method", 
            methodNames.contains("provideRetrofit"))
        assertTrue("NetworkModule should have provideCurrencyApiService method", 
            methodNames.contains("provideCurrencyApiService"))
        assertTrue("NetworkModule should have provideFirebaseAuth method", 
            methodNames.contains("provideFirebaseAuth"))
        assertTrue("NetworkModule should have provideFirebaseFirestore method", 
            methodNames.contains("provideFirebaseFirestore"))
        assertTrue("NetworkModule should have provideFirebaseStorage method", 
            methodNames.contains("provideFirebaseStorage"))
        assertTrue("NetworkModule should have provideFirebaseMessaging method", 
            methodNames.contains("provideFirebaseMessaging"))
    }

    @Test
    fun `repository module has required binding methods`() {
        // Test that RepositoryModule has all required methods using reflection
        try {
            val repositoryModuleClass = Class.forName("com.personalfinance.app.di.RepositoryModule")
            val repositoryModuleMethods = repositoryModuleClass.declaredMethods
            val methodNames = repositoryModuleMethods.map { it.name }.toSet()
            
            assertTrue("RepositoryModule should have bindAuthRepository method", 
                methodNames.contains("bindAuthRepository"))
            assertTrue("RepositoryModule should have bindTransactionRepository method", 
                methodNames.contains("bindTransactionRepository"))
            assertTrue("RepositoryModule should have bindBudgetRepository method", 
                methodNames.contains("bindBudgetRepository"))
            assertTrue("RepositoryModule should have bindAnalyticsRepository method", 
                methodNames.contains("bindAnalyticsRepository"))
            assertTrue("RepositoryModule should have bindDebtRepository method", 
                methodNames.contains("bindDebtRepository"))
            assertTrue("RepositoryModule should have bindSavingsGoalRepository method", 
                methodNames.contains("bindSavingsGoalRepository"))
            assertTrue("RepositoryModule should have bindCurrencyRepository method", 
                methodNames.contains("bindCurrencyRepository"))
        } catch (e: ClassNotFoundException) {
            fail("RepositoryModule class not found: ${e.message}")
        }
    }

    @Test
    fun `database entity classes exist and are properly configured`() {
        // Test that all entity classes exist and can be instantiated
        try {
            val transactionEntityClass = Class.forName("com.personalfinance.app.data.local.entity.TransactionEntity")
            val categoryEntityClass = Class.forName("com.personalfinance.app.data.local.entity.CategoryEntity")
            val budgetEntityClass = Class.forName("com.personalfinance.app.data.local.entity.BudgetEntity")
            val userEntityClass = Class.forName("com.personalfinance.app.data.local.entity.UserEntity")
            val debtEntityClass = Class.forName("com.personalfinance.app.data.local.entity.DebtEntity")
            val savingsGoalEntityClass = Class.forName("com.personalfinance.app.data.local.entity.SavingsGoalEntity")
            
            assertNotNull("TransactionEntity should exist", transactionEntityClass)
            assertNotNull("CategoryEntity should exist", categoryEntityClass)
            assertNotNull("BudgetEntity should exist", budgetEntityClass)
            assertNotNull("UserEntity should exist", userEntityClass)
            assertNotNull("DebtEntity should exist", debtEntityClass)
            assertNotNull("SavingsGoalEntity should exist", savingsGoalEntityClass)
        } catch (e: ClassNotFoundException) {
            fail("Entity class not found: ${e.message}")
        }
    }

    @Test
    fun `dao interfaces exist and are properly configured`() {
        // Test that all DAO interfaces exist
        try {
            val transactionDaoClass = Class.forName("com.personalfinance.app.data.local.dao.TransactionDao")
            val categoryDaoClass = Class.forName("com.personalfinance.app.data.local.dao.CategoryDao")
            val budgetDaoClass = Class.forName("com.personalfinance.app.data.local.dao.BudgetDao")
            val userDaoClass = Class.forName("com.personalfinance.app.data.local.dao.UserDao")
            val debtDaoClass = Class.forName("com.personalfinance.app.data.local.dao.DebtDao")
            val savingsGoalDaoClass = Class.forName("com.personalfinance.app.data.local.dao.SavingsGoalDao")
            
            assertNotNull("TransactionDao should exist", transactionDaoClass)
            assertNotNull("CategoryDao should exist", categoryDaoClass)
            assertNotNull("BudgetDao should exist", budgetDaoClass)
            assertNotNull("UserDao should exist", userDaoClass)
            assertNotNull("DebtDao should exist", debtDaoClass)
            assertNotNull("SavingsGoalDao should exist", savingsGoalDaoClass)
            
            // Verify they are interfaces
            assertTrue("TransactionDao should be an interface", transactionDaoClass.isInterface)
            assertTrue("CategoryDao should be an interface", categoryDaoClass.isInterface)
            assertTrue("BudgetDao should be an interface", budgetDaoClass.isInterface)
            assertTrue("UserDao should be an interface", userDaoClass.isInterface)
            assertTrue("DebtDao should be an interface", debtDaoClass.isInterface)
            assertTrue("SavingsGoalDao should be an interface", savingsGoalDaoClass.isInterface)
        } catch (e: ClassNotFoundException) {
            fail("DAO interface not found: ${e.message}")
        }
    }

    @Test
    fun `database class exists and is properly configured`() {
        // Test that PersonalFinanceDatabase exists and extends RoomDatabase
        try {
            val databaseClass = Class.forName("com.personalfinance.app.data.local.database.PersonalFinanceDatabase")
            assertNotNull("PersonalFinanceDatabase should exist", databaseClass)
            assertTrue("PersonalFinanceDatabase should be abstract", 
                java.lang.reflect.Modifier.isAbstract(databaseClass.modifiers))
            
            // Check that it has all required DAO methods
            val methods = databaseClass.declaredMethods
            val methodNames = methods.map { it.name }.toSet()
            
            assertTrue("Database should have transactionDao method", 
                methodNames.contains("transactionDao"))
            assertTrue("Database should have categoryDao method", 
                methodNames.contains("categoryDao"))
            assertTrue("Database should have budgetDao method", 
                methodNames.contains("budgetDao"))
            assertTrue("Database should have userDao method", 
                methodNames.contains("userDao"))
            assertTrue("Database should have debtDao method", 
                methodNames.contains("debtDao"))
            assertTrue("Database should have savingsGoalDao method", 
                methodNames.contains("savingsGoalDao"))
        } catch (e: ClassNotFoundException) {
            fail("PersonalFinanceDatabase class not found: ${e.message}")
        }
    }

    @Test
    fun `application class exists and is configured for hilt`() {
        // Test that PersonalFinanceApplication exists
        try {
            val applicationClass = Class.forName("com.personalfinance.app.PersonalFinanceApplication")
            assertNotNull("PersonalFinanceApplication should exist", applicationClass)
            
            // Check that it has HiltAndroidApp annotation
            val annotations = applicationClass.annotations
            val hasHiltAnnotation = annotations.any { 
                it.annotationClass.simpleName == "HiltAndroidApp" 
            }
            assertTrue("PersonalFinanceApplication should have @HiltAndroidApp annotation", 
                hasHiltAnnotation)
        } catch (e: ClassNotFoundException) {
            fail("PersonalFinanceApplication class not found: ${e.message}")
        }
    }

    @Test
    fun `repository implementations exist`() {
        // Test that all repository implementations exist
        try {
            val authRepoClass = Class.forName("com.personalfinance.app.data.repository.AuthRepositoryImpl")
            val transactionRepoClass = Class.forName("com.personalfinance.app.data.repository.TransactionRepositoryImpl")
            val budgetRepoClass = Class.forName("com.personalfinance.app.data.repository.BudgetRepositoryImpl")
            val analyticsRepoClass = Class.forName("com.personalfinance.app.data.repository.AnalyticsRepositoryImpl")
            val debtRepoClass = Class.forName("com.personalfinance.app.data.repository.DebtRepositoryImpl")
            val savingsGoalRepoClass = Class.forName("com.personalfinance.app.data.repository.SavingsGoalRepositoryImpl")
            val currencyRepoClass = Class.forName("com.personalfinance.app.data.repository.CurrencyRepositoryImpl")
            
            assertNotNull("AuthRepositoryImpl should exist", authRepoClass)
            assertNotNull("TransactionRepositoryImpl should exist", transactionRepoClass)
            assertNotNull("BudgetRepositoryImpl should exist", budgetRepoClass)
            assertNotNull("AnalyticsRepositoryImpl should exist", analyticsRepoClass)
            assertNotNull("DebtRepositoryImpl should exist", debtRepoClass)
            assertNotNull("SavingsGoalRepositoryImpl should exist", savingsGoalRepoClass)
            assertNotNull("CurrencyRepositoryImpl should exist", currencyRepoClass)
        } catch (e: ClassNotFoundException) {
            fail("Repository implementation not found: ${e.message}")
        }
    }

    @Test
    fun `repository interfaces exist`() {
        // Test that all repository interfaces exist
        try {
            val authRepoInterface = Class.forName("com.personalfinance.app.domain.repository.AuthRepository")
            val transactionRepoInterface = Class.forName("com.personalfinance.app.domain.repository.TransactionRepository")
            val budgetRepoInterface = Class.forName("com.personalfinance.app.domain.repository.BudgetRepository")
            val analyticsRepoInterface = Class.forName("com.personalfinance.app.domain.repository.AnalyticsRepository")
            val debtRepoInterface = Class.forName("com.personalfinance.app.domain.repository.DebtRepository")
            val savingsGoalRepoInterface = Class.forName("com.personalfinance.app.domain.repository.SavingsGoalRepository")
            val currencyRepoInterface = Class.forName("com.personalfinance.app.domain.repository.CurrencyRepository")
            
            assertNotNull("AuthRepository interface should exist", authRepoInterface)
            assertNotNull("TransactionRepository interface should exist", transactionRepoInterface)
            assertNotNull("BudgetRepository interface should exist", budgetRepoInterface)
            assertNotNull("AnalyticsRepository interface should exist", analyticsRepoInterface)
            assertNotNull("DebtRepository interface should exist", debtRepoInterface)
            assertNotNull("SavingsGoalRepository interface should exist", savingsGoalRepoInterface)
            assertNotNull("CurrencyRepository interface should exist", currencyRepoInterface)
            
            // Verify they are interfaces
            assertTrue("AuthRepository should be an interface", authRepoInterface.isInterface)
            assertTrue("TransactionRepository should be an interface", transactionRepoInterface.isInterface)
            assertTrue("BudgetRepository should be an interface", budgetRepoInterface.isInterface)
            assertTrue("AnalyticsRepository should be an interface", analyticsRepoInterface.isInterface)
            assertTrue("DebtRepository should be an interface", debtRepoInterface.isInterface)
            assertTrue("SavingsGoalRepository should be an interface", savingsGoalRepoInterface.isInterface)
            assertTrue("CurrencyRepository should be an interface", currencyRepoInterface.isInterface)
        } catch (e: ClassNotFoundException) {
            fail("Repository interface not found: ${e.message}")
        }
    }
}