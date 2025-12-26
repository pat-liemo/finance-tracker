package com.personalfinance.app.domain.model;

import kotlinx.datetime.LocalDateTime;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J:\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/personalfinance/app/domain/model/RecurringPattern;", "", "frequency", "Lcom/personalfinance/app/domain/model/RecurringFrequency;", "interval", "", "endDate", "Lkotlinx/datetime/LocalDateTime;", "maxOccurrences", "(Lcom/personalfinance/app/domain/model/RecurringFrequency;ILkotlinx/datetime/LocalDateTime;Ljava/lang/Integer;)V", "getEndDate", "()Lkotlinx/datetime/LocalDateTime;", "getFrequency", "()Lcom/personalfinance/app/domain/model/RecurringFrequency;", "getInterval", "()I", "getMaxOccurrences", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Lcom/personalfinance/app/domain/model/RecurringFrequency;ILkotlinx/datetime/LocalDateTime;Ljava/lang/Integer;)Lcom/personalfinance/app/domain/model/RecurringPattern;", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class RecurringPattern {
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.domain.model.RecurringFrequency frequency = null;
    private final int interval = 0;
    @org.jetbrains.annotations.Nullable()
    private final kotlinx.datetime.LocalDateTime endDate = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer maxOccurrences = null;
    
    public RecurringPattern(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.RecurringFrequency frequency, int interval, @org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDateTime endDate, @org.jetbrains.annotations.Nullable()
    java.lang.Integer maxOccurrences) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.RecurringFrequency getFrequency() {
        return null;
    }
    
    public final int getInterval() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDateTime getEndDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMaxOccurrences() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.RecurringFrequency component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDateTime component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.RecurringPattern copy(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.RecurringFrequency frequency, int interval, @org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDateTime endDate, @org.jetbrains.annotations.Nullable()
    java.lang.Integer maxOccurrences) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}