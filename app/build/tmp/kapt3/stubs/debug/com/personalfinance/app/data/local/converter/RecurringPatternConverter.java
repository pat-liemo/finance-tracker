package com.personalfinance.app.data.local.converter;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.personalfinance.app.domain.model.RecurringPattern;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/personalfinance/app/data/local/converter/RecurringPatternConverter;", "", "()V", "gson", "Lcom/google/gson/Gson;", "fromRecurringPattern", "", "pattern", "Lcom/personalfinance/app/domain/model/RecurringPattern;", "toRecurringPattern", "patternString", "app_debug"})
public final class RecurringPatternConverter {
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    
    public RecurringPatternConverter() {
        super();
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String fromRecurringPattern(@org.jetbrains.annotations.Nullable()
    com.personalfinance.app.domain.model.RecurringPattern pattern) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final com.personalfinance.app.domain.model.RecurringPattern toRecurringPattern(@org.jetbrains.annotations.Nullable()
    java.lang.String patternString) {
        return null;
    }
}