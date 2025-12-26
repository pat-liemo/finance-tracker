package com.personalfinance.app.data.local.converter;

import androidx.room.TypeConverter;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateTime;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/personalfinance/app/data/local/converter/DateTimeConverter;", "", "()V", "fromLocalDate", "", "date", "Lkotlinx/datetime/LocalDate;", "fromLocalDateTime", "dateTime", "Lkotlinx/datetime/LocalDateTime;", "toLocalDate", "dateString", "toLocalDateTime", "dateTimeString", "app_debug"})
public final class DateTimeConverter {
    
    public DateTimeConverter() {
        super();
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String fromLocalDateTime(@org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDateTime dateTime) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDateTime toLocalDateTime(@org.jetbrains.annotations.Nullable()
    java.lang.String dateTimeString) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String fromLocalDate(@org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDate date) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDate toLocalDate(@org.jetbrains.annotations.Nullable()
    java.lang.String dateString) {
        return null;
    }
}