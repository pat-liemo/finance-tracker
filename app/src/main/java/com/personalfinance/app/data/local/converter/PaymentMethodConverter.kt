package com.personalfinance.app.data.local.converter

import androidx.room.TypeConverter
import com.personalfinance.app.domain.model.PaymentMethod

class PaymentMethodConverter {
    
    @TypeConverter
    fun fromPaymentMethod(paymentMethod: PaymentMethod): String {
        return paymentMethod.name
    }
    
    @TypeConverter
    fun toPaymentMethod(paymentMethodString: String): PaymentMethod {
        return PaymentMethod.valueOf(paymentMethodString)
    }
}