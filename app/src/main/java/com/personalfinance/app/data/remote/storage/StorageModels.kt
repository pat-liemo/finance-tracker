package com.personalfinance.app.data.remote.storage

data class StorageUsage(
    val totalSizeMB: Double,
    val receiptCount: Int,
    val backupCount: Int
)

data class UploadResult(
    val success: Boolean,
    val downloadUrl: String? = null,
    val error: String? = null,
    val progress: Int = 0
)

data class UploadProgress(
    val fileName: String,
    val progress: Int,
    val isComplete: Boolean = false
)