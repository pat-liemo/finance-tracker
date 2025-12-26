package com.personalfinance.app.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.personalfinance.app.data.local.converter.BudgetPeriodConverter;
import com.personalfinance.app.data.local.converter.DateTimeConverter;
import com.personalfinance.app.domain.model.BudgetPeriod;
import kotlinx.datetime.LocalDate;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0007H\u00c6\u0003J\t\u0010&\u001a\u00020\tH\u00c6\u0003J\t\u0010\'\u001a\u00020\u000bH\u00c6\u0003J\t\u0010(\u001a\u00020\u0007H\u00c6\u0003J\t\u0010)\u001a\u00020\u000eH\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003Jm\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010-\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010/\u001a\u000200H\u00d6\u0001J\t\u00101\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001bR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017\u00a8\u00062"}, d2 = {"Lcom/personalfinance/app/data/local/entity/BudgetEntity;", "", "id", "", "categoryId", "", "amount", "", "period", "Lcom/personalfinance/app/domain/model/BudgetPeriod;", "startDate", "Lkotlinx/datetime/LocalDate;", "alertThreshold", "isActive", "", "userId", "createdAt", "updatedAt", "(JLjava/lang/String;DLcom/personalfinance/app/domain/model/BudgetPeriod;Lkotlinx/datetime/LocalDate;DZLjava/lang/String;JJ)V", "getAlertThreshold", "()D", "getAmount", "getCategoryId", "()Ljava/lang/String;", "getCreatedAt", "()J", "getId", "()Z", "getPeriod", "()Lcom/personalfinance/app/domain/model/BudgetPeriod;", "getStartDate", "()Lkotlinx/datetime/LocalDate;", "getUpdatedAt", "getUserId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(tableName = "budgets")
@androidx.room.TypeConverters(value = {com.personalfinance.app.data.local.converter.DateTimeConverter.class, com.personalfinance.app.data.local.converter.BudgetPeriodConverter.class})
public final class BudgetEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String categoryId = null;
    private final double amount = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.domain.model.BudgetPeriod period = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.datetime.LocalDate startDate = null;
    private final double alertThreshold = 0.0;
    private final boolean isActive = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userId = null;
    private final long createdAt = 0L;
    private final long updatedAt = 0L;
    
    public BudgetEntity(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, double amount, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.BudgetPeriod period, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate startDate, double alertThreshold, boolean isActive, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, long createdAt, long updatedAt) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategoryId() {
        return null;
    }
    
    public final double getAmount() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.BudgetPeriod getPeriod() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.LocalDate getStartDate() {
        return null;
    }
    
    public final double getAlertThreshold() {
        return 0.0;
    }
    
    public final boolean isActive() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final long getUpdatedAt() {
        return 0L;
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long component10() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.BudgetPeriod component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.LocalDate component5() {
        return null;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final boolean component7() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    public final long component9() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.data.local.entity.BudgetEntity copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, double amount, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.BudgetPeriod period, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate startDate, double alertThreshold, boolean isActive, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, long createdAt, long updatedAt) {
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