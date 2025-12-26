package com.personalfinance.app.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.personalfinance.app.data.local.dao.UserDao
import com.personalfinance.app.data.local.entity.UserEntity
import com.personalfinance.app.domain.model.User
import com.personalfinance.app.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val userDao: UserDao
) : AuthRepository {
    
    override suspend fun signInWithEmail(email: String, password: String): Result<User> {
        return try {
            // Validate input
            if (email.isBlank() || password.isBlank()) {
                return Result.failure(IllegalArgumentException("Email and password cannot be empty"))
            }
            
            if (!isValidEmail(email)) {
                return Result.failure(IllegalArgumentException("Invalid email format"))
            }
            
            // Sign in with Firebase
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val firebaseUser = authResult.user 
                ?: return Result.failure(Exception("Authentication failed: No user returned"))
            
            // Convert to domain model and save locally
            val user = firebaseUser.toDomainModel()
            saveUserLocally(user)
            
            Result.success(user)
        } catch (e: FirebaseAuthException) {
            Result.failure(Exception(getAuthErrorMessage(e)))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun signInWithGoogle(): Result<User> {
        return try {
            // Google Sign-In will be implemented in a later task
            Result.failure(NotImplementedError("Google Sign-In will be implemented in a later task"))
        } catch (e: Exception) {
            Result.failure(e)
        }
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
            
            // Create account with Firebase
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val firebaseUser = authResult.user 
                ?: return Result.failure(Exception("Account creation failed: No user returned"))
            
            // Convert to domain model and save locally
            val user = firebaseUser.toDomainModel()
            saveUserLocally(user)
            
            Result.success(user)
        } catch (e: FirebaseAuthException) {
            Result.failure(Exception(getAuthErrorMessage(e)))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun enableBiometricAuth(): Result<Boolean> {
        return try {
            // Biometric authentication will be implemented in a later task
            Result.failure(NotImplementedError("Biometric authentication will be implemented in a later task"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun signOut(): Result<Unit> {
        return try {
            firebaseAuth.signOut()
            userDao.deleteAllUsers()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getCurrentUser(): User? {
        return try {
            val firebaseUser = firebaseAuth.currentUser
            firebaseUser?.toDomainModel()
        } catch (e: Exception) {
            null
        }
    }
    
    override fun getCurrentUserFlow(): Flow<User?> {
        return userDao.getCurrentUser().map { userEntity ->
            userEntity?.toDomainModel()
        }
    }
    
    override suspend fun sendPasswordResetEmail(email: String): Result<Unit> {
        return try {
            if (email.isBlank()) {
                return Result.failure(IllegalArgumentException("Email cannot be empty"))
            }
            
            if (!isValidEmail(email)) {
                return Result.failure(IllegalArgumentException("Invalid email format"))
            }
            
            firebaseAuth.sendPasswordResetEmail(email).await()
            Result.success(Unit)
        } catch (e: FirebaseAuthException) {
            Result.failure(Exception(getAuthErrorMessage(e)))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun updateProfile(displayName: String?, photoUrl: String?): Result<Unit> {
        return try {
            val currentUser = firebaseAuth.currentUser 
                ?: return Result.failure(Exception("No authenticated user"))
            
            val profileUpdates = UserProfileChangeRequest.Builder()
                .setDisplayName(displayName)
                .setPhotoUri(photoUrl?.let { android.net.Uri.parse(it) })
                .build()
            
            currentUser.updateProfile(profileUpdates).await()
            
            // Update local user data
            val updatedUser = currentUser.toDomainModel()
            saveUserLocally(updatedUser)
            
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    // Helper functions
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    
    private fun getAuthErrorMessage(exception: FirebaseAuthException): String {
        return when (exception.errorCode) {
            "ERROR_INVALID_EMAIL" -> "Invalid email address"
            "ERROR_WRONG_PASSWORD" -> "Incorrect password"
            "ERROR_USER_NOT_FOUND" -> "No account found with this email"
            "ERROR_USER_DISABLED" -> "This account has been disabled"
            "ERROR_TOO_MANY_REQUESTS" -> "Too many failed attempts. Please try again later"
            "ERROR_EMAIL_ALREADY_IN_USE" -> "An account with this email already exists"
            "ERROR_WEAK_PASSWORD" -> "Password is too weak"
            "ERROR_NETWORK_REQUEST_FAILED" -> "Network error. Please check your connection"
            else -> exception.message ?: "Authentication failed"
        }
    }
    
    private suspend fun saveUserLocally(user: User) {
        try {
            val userEntity = user.toEntity()
            userDao.insertUser(userEntity)
        } catch (e: Exception) {
            // Log error but don't fail the authentication
            // In a real app, you might want to use a proper logging framework
        }
    }
    
    private fun FirebaseUser.toDomainModel(): User {
        return User(
            id = uid,
            email = email ?: "",
            displayName = displayName,
            photoUrl = photoUrl?.toString(),
            isEmailVerified = isEmailVerified,
            createdAt = metadata?.creationTimestamp ?: System.currentTimeMillis(),
            lastLoginAt = metadata?.lastSignInTimestamp ?: System.currentTimeMillis()
        )
    }
    
    private fun User.toEntity(): UserEntity {
        return UserEntity(
            id = id,
            email = email,
            displayName = displayName,
            photoUrl = photoUrl,
            isEmailVerified = isEmailVerified,
            createdAt = createdAt,
            lastLoginAt = lastLoginAt
        )
    }
    
    private fun UserEntity.toDomainModel(): User {
        return User(
            id = id,
            email = email,
            displayName = displayName,
            photoUrl = photoUrl,
            isEmailVerified = isEmailVerified,
            createdAt = createdAt,
            lastLoginAt = lastLoginAt
        )
    }
}