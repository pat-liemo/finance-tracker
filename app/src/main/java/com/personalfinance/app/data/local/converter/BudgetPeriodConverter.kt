package com.personalfinance.app.data.local.converter

import androidx.room.TypeConverter
import com.personalfinance.app.domain.model.BudgetPeriod

class BudgetPeriodConverter {
    
    @TypeConverter
    fun fromBudgetPeriod(period: BudgetPeriod): String {
        return period.name
    }
    
    @TypeConverter
    fun toBudgetPeriod(periodString: String): BudgetPeriod {
        return BudgetPeriod.valueOf(periodString)
    }
}