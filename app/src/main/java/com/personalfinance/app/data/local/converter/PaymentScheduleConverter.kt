package com.personalfinance.app.data.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.personalfinance.app.domain.model.PaymentSchedule

class PaymentScheduleConverter {
    
    private val gson = Gson()
    
    @TypeConverter
    fun fromPaymentSchedule(schedule: PaymentSchedule): String {
        return gson.toJson(schedule)
    }
    
    @TypeConverter
    fun toPaymentSchedule(scheduleString: String): PaymentSchedule {
        return gson.fromJson(scheduleString, PaymentSchedule::class.java)
    }
}