package com.personalfinance.app.domain.repository

import com.personalfinance.app.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun signInWithEmail(email: String, password: String): Result<User>
    suspend fun signInWithGoogle(): Result<User>
    suspend fun signUp(email: String, password: String): Result<User>
    suspend fun enableBiometricAuth(): Result<Boolean>
    suspend fun signOut(): Result<Unit>
    suspend fun getCurrentUser(): User?
    fun getCurrentUserFlow(): Flow<User?>
    suspend fun sendPasswordResetEmail(email: String): Result<Unit>
    suspend fun updateProfile(displayName: String?, photoUrl: String?): Result<Unit>
}