package com.personalfinance.app.data.local.converter

import androidx.room.TypeConverter
import com.personalfinance.app.domain.model.SyncStatus

class SyncStatusConverter {
    
    @TypeConverter
    fun fromSyncStatus(syncStatus: SyncStatus): String {
        return syncStatus.name
    }
    
    @TypeConverter
    fun toSyncStatus(syncStatusString: String): SyncStatus {
        return SyncStatus.valueOf(syncStatusString)
    }
}