package com.personalfinance.app.data.local.converter;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.personalfinance.app.domain.model.PaymentSchedule;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/personalfinance/app/data/local/converter/PaymentScheduleConverter;", "", "()V", "gson", "Lcom/google/gson/Gson;", "fromPaymentSchedule", "", "schedule", "Lcom/personalfinance/app/domain/model/PaymentSchedule;", "toPaymentSchedule", "scheduleString", "app_debug"})
public final class PaymentScheduleConverter {
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    
    public PaymentScheduleConverter() {
        super();
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromPaymentSchedule(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.PaymentSchedule schedule) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.PaymentSchedule toPaymentSchedule(@org.jetbrains.annotations.NotNull()
    java.lang.String scheduleString) {
        return null;
    }
}