package com.personalfinance.app.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.personalfinance.app.data.local.converter.DateTimeConverter;
import com.personalfinance.app.data.local.converter.PaymentMethodConverter;
import com.personalfinance.app.data.local.converter.RecurringPatternConverter;
import com.personalfinance.app.data.local.converter.SyncStatusConverter;
import com.personalfinance.app.data.local.converter.StringListConverter;
import com.personalfinance.app.domain.model.PaymentMethod;
import com.personalfinance.app.domain.model.RecurringPattern;
import com.personalfinance.app.domain.model.SyncStatus;
import kotlinx.datetime.LocalDateTime;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0018J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0014H\u00c6\u0003J\t\u00100\u001a\u00020\u0007H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u0007H\u00c6\u0003J\t\u00105\u001a\u00020\tH\u00c6\u0003J\t\u00106\u001a\u00020\u0007H\u00c6\u0003J\t\u00107\u001a\u00020\fH\u00c6\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u00c6\u0003J\t\u00109\u001a\u00020\u0010H\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\u0093\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010<\u001a\u00020\u00102\b\u0010=\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010>\u001a\u00020?H\u00d6\u0001J\t\u0010@\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010#R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001c\u00a8\u0006A"}, d2 = {"Lcom/personalfinance/app/data/local/entity/TransactionEntity;", "", "id", "", "amount", "", "categoryId", "", "date", "Lkotlinx/datetime/LocalDateTime;", "description", "paymentMethod", "Lcom/personalfinance/app/domain/model/PaymentMethod;", "tags", "", "isRecurring", "", "recurringPattern", "Lcom/personalfinance/app/domain/model/RecurringPattern;", "syncStatus", "Lcom/personalfinance/app/domain/model/SyncStatus;", "userId", "createdAt", "updatedAt", "(JDLjava/lang/String;Lkotlinx/datetime/LocalDateTime;Ljava/lang/String;Lcom/personalfinance/app/domain/model/PaymentMethod;Ljava/util/List;ZLcom/personalfinance/app/domain/model/RecurringPattern;Lcom/personalfinance/app/domain/model/SyncStatus;Ljava/lang/String;JJ)V", "getAmount", "()D", "getCategoryId", "()Ljava/lang/String;", "getCreatedAt", "()J", "getDate", "()Lkotlinx/datetime/LocalDateTime;", "getDescription", "getId", "()Z", "getPaymentMethod", "()Lcom/personalfinance/app/domain/model/PaymentMethod;", "getRecurringPattern", "()Lcom/personalfinance/app/domain/model/RecurringPattern;", "getSyncStatus", "()Lcom/personalfinance/app/domain/model/SyncStatus;", "getTags", "()Ljava/util/List;", "getUpdatedAt", "getUserId", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(tableName = "transactions")
@androidx.room.TypeConverters(value = {com.personalfinance.app.data.local.converter.DateTimeConverter.class, com.personalfinance.app.data.local.converter.PaymentMethodConverter.class, com.personalfinance.app.data.local.converter.RecurringPatternConverter.class, com.personalfinance.app.data.local.converter.SyncStatusConverter.class, com.personalfinance.app.data.local.converter.StringListConverter.class})
public final class TransactionEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    private final double amount = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String categoryId = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.datetime.LocalDateTime date = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.domain.model.PaymentMethod paymentMethod = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> tags = null;
    private final boolean isRecurring = false;
    @org.jetbrains.annotations.Nullable()
    private final com.personalfinance.app.domain.model.RecurringPattern recurringPattern = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.domain.model.SyncStatus syncStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userId = null;
    private final long createdAt = 0L;
    private final long updatedAt = 0L;
    
    public TransactionEntity(long id, double amount, @org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime date, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.PaymentMethod paymentMethod, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, boolean isRecurring, @org.jetbrains.annotations.Nullable()
    com.personalfinance.app.domain.model.RecurringPattern recurringPattern, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.SyncStatus syncStatus, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, long createdAt, long updatedAt) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    public final double getAmount() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategoryId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.LocalDateTime getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.PaymentMethod getPaymentMethod() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTags() {
        return null;
    }
    
    public final boolean isRecurring() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.personalfinance.app.domain.model.RecurringPattern getRecurringPattern() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.SyncStatus getSyncStatus() {
        return null;
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
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.SyncStatus component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    public final long component12() {
        return 0L;
    }
    
    public final long component13() {
        return 0L;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.LocalDateTime component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.PaymentMethod component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.personalfinance.app.domain.model.RecurringPattern component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.data.local.entity.TransactionEntity copy(long id, double amount, @org.jetbrains.annotations.NotNull()
    java.lang.String categoryId, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime date, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.PaymentMethod paymentMethod, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, boolean isRecurring, @org.jetbrains.annotations.Nullable()
    com.personalfinance.app.domain.model.RecurringPattern recurringPattern, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.SyncStatus syncStatus, @org.jetbrains.annotations.NotNull()
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