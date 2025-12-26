package com.personalfinance.app

import org.junit.Test

/**
 * Debug test to see what methods are actually available
 */
class AnalyticsDebugTest {
    
    @Test
    fun `Debug - Print AnalyticsRepositoryImpl methods`() {
        try {
            val analyticsRepoClass = Class.forName("com.personalfinance.app.data.repository.AnalyticsRepositoryImpl")
            val methods = analyticsRepoClass.declaredMethods.map { it.name }
            
            println("AnalyticsRepositoryImpl methods:")
            methods.forEach { println("  - $it") }
        } catch (e: ClassNotFoundException) {
            println("AnalyticsRepositoryImpl class not found: ${e.message}")
        }
    }
    
    @Test
    fun `Debug - Print ExportRepositoryImpl methods`() {
        try {
            val exportRepoClass = Class.forName("com.personalfinance.app.data.repository.ExportRepositoryImpl")
            val methods = exportRepoClass.declaredMethods.map { it.name }
            
            println("ExportRepositoryImpl methods:")
            methods.forEach { println("  - $it") }
        } catch (e: ClassNotFoundException) {
            println("ExportRepositoryImpl class not found: ${e.message}")
        }
    }
}