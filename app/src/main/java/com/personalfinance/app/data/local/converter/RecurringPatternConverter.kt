package com.personalfinance.app.data.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.personalfinance.app.domain.model.RecurringPattern

class RecurringPatternConverter {
    
    private val gson = Gson()
    
    @TypeConverter
    fun fromRecurringPattern(pattern: RecurringPattern?): String? {
        return pattern?.let { gson.toJson(it) }
    }
    
    @TypeConverter
    fun toRecurringPattern(patternString: String?): RecurringPattern? {
        return patternString?.let { gson.fromJson(it, RecurringPattern::class.java) }
    }
}