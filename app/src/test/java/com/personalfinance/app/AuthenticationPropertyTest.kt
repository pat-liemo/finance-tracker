package com.personalfinance.app

import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*

/**
 * Property-based tests for authentication functionality
 * **Feature: personal-finance-app, Property 1: Valid credentials create accounts**
 * **Validates: Requirements 1.1**
 */
class AuthenticationPropertyTest {
    
    @Test
    fun `Property 1 - Valid credentials create accounts`() = runTest {
        val authRepository = FakeAuthRepository()
        
        // Test with multiple valid email and password combinations
        val validCredentials = listOf(
            "user1@example.com" to "password123",
            "test.user@domain.org" to "securepass456",
            "admin@company.co.uk" to "mypassword789",
            "developer@startup.io" to "devpass2024",
            "manager@business.net" to "managerpass",
            "student@university.edu" to "studentpass123",
            "freelancer@work.com" to "freelancepass",
            "designer@creative.studio" to "designpass456",
            "analyst@data.science" to "analyticspass",
            "engineer@tech.company" to "engineerpass123"
        )
        
        validCredentials.forEach { (email, password) ->
            // Clear state before each test
            authRepository.clearAllUsers()
            
            // When: signUp is called with valid credentials
            val signUpResult = authRepository.signUp(email, password)
            
            // Then: authentication succeeds
            assertTrue("Sign up should succeed with valid credentials: $email", signUpResult.isSuccess)
            
            val user = signUpResult.getOrNull()
            assertNotNull("User should not be null after successful sign up", user)
            
            // And: getCurrentUser returns a non-null user
            val currentUser = authRepository.getCurrentUser()
            assertNotNull("Current user should not be null after sign up", currentUser)
            assertEquals("Current user should match signed up user", user, currentUser)
            
            // And: user has correct email
            assertEquals("User email should match input", email, user?.email)
            
            // And: user has valid ID
            assertNotNull("User should have a valid ID", user?.id)
            assertTrue("User ID should not be empty", user?.id?.isNotEmpty() == true)
            
            // And: user has creation timestamp
            assertTrue("User should have creation timestamp", (user?.createdAt ?: 0) > 0)
            assertTrue("User should have last login timestamp", (user?.lastLoginAt ?: 0) > 0)
        }
    }
    
    @Test
    fun `Property 1 extension - Sign out clears current user`() = runTest {
        val authRepository = FakeAuthRepository()
        
        val validCredentials = listOf(
            "user1@example.com" to "password123",
            "test.user@domain.org" to "securepass456",
            "admin@company.co.uk" to "mypassword789",
            "developer@startup.io" to "devpass2024",
            "manager@business.net" to "managerpass"
        )
        
        validCredentials.forEach { (email, password) ->
            // Clear state before each test
            authRepository.clearAllUsers()
            
            // Given: a user is signed up and signed in
            val signUpResult = authRepository.signUp(email, password)
            assertTrue("Sign up should succeed", signUpResult.isSuccess)
            
            val userBeforeSignOut = authRepository.getCurrentUser()
            assertNotNull("User should exist before sign out", userBeforeSignOut)
            
            // When: sign out is called
            val signOutResult = authRepository.signOut()
            
            // Then: sign out succeeds
            assertTrue("Sign out should succeed", signOutResult.isSuccess)
            
            // And: current user is cleared
            val userAfterSignOut = authRepository.getCurrentUser()
            assertNull("Current user should be null after sign out", userAfterSignOut)
        }
    }
    
    @Test
    fun `Property 1 extension - Sign in after sign up works`() = runTest {
        val authRepository = FakeAuthRepository()
        
        val validCredentials = listOf(
            "user1@example.com" to "password123",
            "test.user@domain.org" to "securepass456",
            "admin@company.co.uk" to "mypassword789",
            "developer@startup.io" to "devpass2024",
            "manager@business.net" to "managerpass"
        )
        
        validCredentials.forEach { (email, password) ->
            // Clear state before each test
            authRepository.clearAllUsers()
            
            // Given: a user signs up
            val signUpResult = authRepository.signUp(email, password)
            assertTrue("Sign up should succeed", signUpResult.isSuccess)
            val originalUser = signUpResult.getOrNull()
            
            // And: signs out
            authRepository.signOut()
            assertNull("User should be signed out", authRepository.getCurrentUser())
            
            // When: user signs in with same credentials
            val signInResult = authRepository.signInWithEmail(email, password)
            
            // Then: sign in succeeds
            assertTrue("Sign in should succeed with correct credentials", signInResult.isSuccess)
            
            val signedInUser = signInResult.getOrNull()
            assertNotNull("Signed in user should not be null", signedInUser)
            
            // And: user data is preserved
            assertEquals("User ID should be preserved", originalUser?.id, signedInUser?.id)
            assertEquals("User email should be preserved", originalUser?.email, signedInUser?.email)
            assertEquals("User creation time should be preserved", originalUser?.createdAt, signedInUser?.createdAt)
            
            // And: last login time is updated
            assertTrue("Last login time should be updated", 
                (signedInUser?.lastLoginAt ?: 0) >= (originalUser?.lastLoginAt ?: 0))
        }
    }
    
    @Test
    fun `Property validation - Invalid emails are rejected`() = runTest {
        val authRepository = FakeAuthRepository()
        
        val invalidEmails = listOf(
            "",
            "invalid-email",
            "@example.com",
            "user@",
            "user@.com",
            "user",
            "user.com",
            "   ",
            "a@b"
        )
        
        val validPassword = "password123"
        
        invalidEmails.forEach { invalidEmail ->
            authRepository.clearAllUsers()
            
            val result = authRepository.signUp(invalidEmail, validPassword)
            assertTrue("Invalid email '$invalidEmail' should be rejected", result.isFailure)
            
            val exception = result.exceptionOrNull()
            assertNotNull("Exception should be provided for invalid email", exception)
            assertTrue("Exception should mention email format", 
                exception?.message?.contains("email", ignoreCase = true) == true)
        }
    }
    
    @Test
    fun `Property validation - Invalid passwords are rejected`() = runTest {
        val authRepository = FakeAuthRepository()
        
        val invalidPasswords = listOf(
            "",
            "12345", // Too short
            "     ", // Only whitespace
            "a",     // Too short
            "12"     // Too short
        )
        
        val validEmail = "test@example.com"
        
        invalidPasswords.forEach { invalidPassword ->
            authRepository.clearAllUsers()
            
            val result = authRepository.signUp(validEmail, invalidPassword)
            assertTrue("Invalid password '$invalidPassword' should be rejected", result.isFailure)
            
            val exception = result.exceptionOrNull()
            assertNotNull("Exception should be provided for invalid password", exception)
            assertTrue("Exception should mention password requirements", 
                exception?.message?.contains("password", ignoreCase = true) == true)
        }
    }
    
    @Test
    fun `Property validation - Duplicate email registration is rejected`() = runTest {
        val authRepository = FakeAuthRepository()
        
        val validCredentials = listOf(
            "user1@example.com" to "password123",
            "test.user@domain.org" to "securepass456",
            "admin@company.co.uk" to "mypassword789"
        )
        
        validCredentials.forEach { (email, password) ->
            authRepository.clearAllUsers()
            
            // First registration should succeed
            val firstResult = authRepository.signUp(email, password)
            assertTrue("First registration should succeed", firstResult.isSuccess)
            
            // Second registration with same email should fail
            val secondResult = authRepository.signUp(email, "different_password")
            assertTrue("Duplicate email registration should fail", secondResult.isFailure)
            
            val exception = secondResult.exceptionOrNull()
            assertNotNull("Exception should be provided for duplicate email", exception)
            assertTrue("Exception should mention email already exists", 
                exception?.message?.contains("already exists", ignoreCase = true) == true)
        }
    }
}