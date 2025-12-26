package com.personalfinance.app.data.remote.storage

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import java.io.File
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseStorageService @Inject constructor(
    private val storage: FirebaseStorage
) {
    
    /**
     * Upload a receipt image to Firebase Storage
     */
    suspend fun uploadReceipt(
        userId: String,
        imageUri: Uri,
        transactionId: Long
    ): Result<String> {
        return try {
            val fileName = "receipt_${transactionId}_${UUID.randomUUID()}.jpg"
            val storageRef = storage.reference
                .child("users")
                .child(userId)
                .child("receipts")
                .child(fileName)
            
            val uploadTask = storageRef.putFile(imageUri).await()
            val downloadUrl = uploadTask.storage.downloadUrl.await()
            
            Result.success(downloadUrl.toString())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Upload an exported file to Firebase Storage
     */
    suspend fun uploadExportedFile(
        userId: String,
        file: File,
        fileName: String
    ): Result<String> {
        return try {
            val storageRef = storage.reference
                .child("users")
                .child(userId)
                .child("exports")
                .child(fileName)
            
            val uri = Uri.fromFile(file)
            val uploadTask = storageRef.putFile(uri).await()
            val downloadUrl = uploadTask.storage.downloadUrl.await()
            
            Result.success(downloadUrl.toString())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Get storage usage information
     */
    suspend fun getStorageUsage(userId: String): StorageUsage {
        return try {
            // This is a simplified implementation
            // In a real app, you'd query Firebase Storage for actual usage
            StorageUsage(
                totalSizeMB = 0.0,
                receiptCount = 0,
                backupCount = 0
            )
        } catch (e: Exception) {
            StorageUsage(0.0, 0, 0)
        }
    }
}