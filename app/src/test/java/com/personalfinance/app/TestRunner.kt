package com.personalfinance.app

import kotlinx.coroutines.runBlocking

/**
 * Simple test runner to verify authentication property tests work
 */
fun main() {
    println("Running Authentication Property Tests...")
    
    val testInstance = AuthenticationPropertyTest()
    
    try {
        runBlocking {
            testInstance.`Property 1 - Valid credentials create accounts`()
        }
        println("✅ Property 1 - Valid credentials create accounts: PASSED")
    } catch (e: Exception) {
        println("❌ Property 1 - Valid credentials create accounts: FAILED - ${e.message}")
        e.printStackTrace()
    }
    
    try {
        runBlocking {
            testInstance.`Property 1 extension - Sign out clears current user`()
        }
        println("✅ Property 1 extension - Sign out clears current user: PASSED")
    } catch (e: Exception) {
        println("❌ Property 1 extension - Sign out clears current user: FAILED - ${e.message}")
        e.printStackTrace()
    }
    
    try {
        runBlocking {
            testInstance.`Property 1 extension - Sign in after sign up works`()
        }
        println("✅ Property 1 extension - Sign in after sign up works: PASSED")
    } catch (e: Exception) {
        println("❌ Property 1 extension - Sign in after sign up works: FAILED - ${e.message}")
        e.printStackTrace()
    }
    
    try {
        runBlocking {
            testInstance.`Property validation - Invalid emails are rejected`()
        }
        println("✅ Property validation - Invalid emails are rejected: PASSED")
    } catch (e: Exception) {
        println("❌ Property validation - Invalid emails are rejected: FAILED - ${e.message}")
        e.printStackTrace()
    }
    
    try {
        runBlocking {
            testInstance.`Property validation - Invalid passwords are rejected`()
        }
        println("✅ Property validation - Invalid passwords are rejected: PASSED")
    } catch (e: Exception) {
        println("❌ Property validation - Invalid passwords are rejected: FAILED - ${e.message}")
        e.printStackTrace()
    }
    
    try {
        runBlocking {
            testInstance.`Property validation - Duplicate email registration is rejected`()
        }
        println("✅ Property validation - Duplicate email registration is rejected: PASSED")
    } catch (e: Exception) {
        println("❌ Property validation - Duplicate email registration is rejected: FAILED - ${e.message}")
        e.printStackTrace()
    }
    
    println("Authentication Property Tests completed!")
}