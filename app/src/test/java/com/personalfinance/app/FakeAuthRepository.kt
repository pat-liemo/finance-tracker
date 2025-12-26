package com.personalfinance.app

import com.personalfinance.app.domain.model.User
import com.personalfinance.app.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID

/**
 * Fake implementation of AuthRepository for testing purposes.
 * Simulates authentication behavior without Firebase dependencies.
 */
class FakeAuthRepository : AuthRepository {
    
    private val users = mutableMapOf<String, StoredUser>()
    private val _currentUser = MutableStateFlow<User?>(null)
    
    data class StoredUser(
        val email: String,
        val password: String,
        val user: User
    )
    
    override suspend fun signInWithEmail(email: String, password: String): Result<User> {
        return try {
            // Validate input
            if (email.isBlank() || password.isBlank()) {
                return Result.failure(IllegalArgumentException("Email and password cannot be empty"))
            }
            
            if (!isValidEmail(email)) {
                return Result.failure(IllegalArgumentException("Invalid email format"))
            }
            
            // Check if user exists and password matches
            val storedUser = users[email]
                ?: return Result.failure(Exception("No account found with this email"))
            
            if (storedUser.password != password) {
                return Result.failure(Exception("Incorrect password"))
            }
            
            // Update last login time
            val updatedUser = storedUser.user.copy(lastLoginAt = System.currentTimeMillis())
            users[email] = storedUser.copy(user = updatedUser)
            _currentUser.value = updatedUser
            
            Result.success(updatedUser)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun signInWithGoogle(): Result<User> {
        return Result.failure(NotImplementedError("Google Sign-In not implemented in fake"))
    }
    
    override suspend fun signUp(email: String, password: String): Result<User> {
        return try {
            // Validate input
            if (email.isBlank() || password.isBlank()) {
                return Result.failure(IllegalArgumentException("Email and password cannot be empty"))
            }
            
            if (!isValidEmail(email)) {
                return Result.failure(IllegalArgumentException("Invalid email format"))
            }
            
            if (password.length < 6) {
                return Result.failure(IllegalArgumentException("Password must be at least 6 characters"))
            }
            
            // Check if user already exists
            if (users.containsKey(email)) {
                return Result.failure(Exception("An account with this email already exists"))
            }
            
            // Create new user
            val now = System.currentTimeMillis()
            val user = User(
                id = UUID.randomUUID().toString(),
                email = email,
                displayName = null,
                photoUrl = null,
                isEmailVerified = false,
                createdAt = now,
                lastLoginAt = now
            )
            
            users[email] = StoredUser(email, password, user)
            _currentUser.value = user
            
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun enableBiometricAuth(): Result<Boolean> {
        return Result.failure(NotImplementedError("Biometric auth not implemented in fake"))
    }
    
    override suspend fun signOut(): Result<Unit> {
        return try {
            _currentUser.value = null
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getCurrentUser(): User? {
        return _currentUser.value
    }
    
    override fun getCurrentUserFlow(): Flow<User?> {
        return _currentUser.asStateFlow()
    }
    
    override suspend fun sendPasswordResetEmail(email: String): Result<Unit> {
        return try {
            if (email.isBlank()) {
                return Result.failure(IllegalArgumentException("Email cannot be empty"))
            }
            
            if (!isValidEmail(email)) {
                return Result.failure(IllegalArgumentException("Invalid email format"))
            }
            
            if (!users.containsKey(email)) {
                return Result.failure(Exception("No account found with this email"))
            }
            
            // Simulate sending password reset email
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun updateProfile(displayName: String?, photoUrl: String?): Result<Unit> {
        return try {
            val currentUser = _currentUser.value
                ?: return Result.failure(Exception("No authenticated user"))
            
            val updatedUser = currentUser.copy(
                displayName = displayName,
                photoUrl = photoUrl
            )
            
            // Update in storage
            val storedUser = users[currentUser.email]
                ?: return Result.failure(Exception("User not found in storage"))
            
            users[currentUser.email] = storedUser.copy(user = updatedUser)
            _currentUser.value = updatedUser
            
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    // Helper functions
    private fun isValidEmail(email: String): Boolean {
        return email.contains("@") && email.contains(".") && email.length > 5
    }
    
    // Test helper methods
    fun clearAllUsers() {
        users.clear()
        _currentUser.value = null
    }
    
    fun getUserCount(): Int = users.size
    
    fun hasUser(email: String): Boolean = users.containsKey(email)
}