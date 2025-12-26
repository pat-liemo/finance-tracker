package com.personalfinance.app.domain.model;

import kotlinx.datetime.LocalDateTime;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0011J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010%\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u0006H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u0086\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00c6\u0001\u00a2\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020/H\u00d6\u0001J\t\u00100\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u000f\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013\u00a8\u00061"}, d2 = {"Lcom/personalfinance/app/domain/model/TransactionFilter;", "", "startDate", "Lkotlinx/datetime/LocalDateTime;", "endDate", "categoryIds", "", "", "minAmount", "", "maxAmount", "paymentMethods", "Lcom/personalfinance/app/domain/model/PaymentMethod;", "searchQuery", "tags", "isRecurring", "", "(Lkotlinx/datetime/LocalDateTime;Lkotlinx/datetime/LocalDateTime;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "getCategoryIds", "()Ljava/util/List;", "getEndDate", "()Lkotlinx/datetime/LocalDateTime;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMaxAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMinAmount", "getPaymentMethods", "getSearchQuery", "()Ljava/lang/String;", "getStartDate", "getTags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lkotlinx/datetime/LocalDateTime;Lkotlinx/datetime/LocalDateTime;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lcom/personalfinance/app/domain/model/TransactionFilter;", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class TransactionFilter {
    @org.jetbrains.annotations.Nullable()
    private final kotlinx.datetime.LocalDateTime startDate = null;
    @org.jetbrains.annotations.Nullable()
    private final kotlinx.datetime.LocalDateTime endDate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> categoryIds = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double minAmount = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double maxAmount = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.personalfinance.app.domain.model.PaymentMethod> paymentMethods = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> tags = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isRecurring = null;
    
    public TransactionFilter(@org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDateTime startDate, @org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDateTime endDate, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> categoryIds, @org.jetbrains.annotations.Nullable()
    java.lang.Double minAmount, @org.jetbrains.annotations.Nullable()
    java.lang.Double maxAmount, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.personalfinance.app.domain.model.PaymentMethod> paymentMethods, @org.jetbrains.annotations.Nullable()
    java.lang.String searchQuery, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRecurring) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDateTime getStartDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDateTime getEndDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getCategoryIds() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getMinAmount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getMaxAmount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.personalfinance.app.domain.model.PaymentMethod> getPaymentMethods() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTags() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isRecurring() {
        return null;
    }
    
    public TransactionFilter() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDateTime component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDateTime component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.personalfinance.app.domain.model.PaymentMethod> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.TransactionFilter copy(@org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDateTime startDate, @org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDateTime endDate, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> categoryIds, @org.jetbrains.annotations.Nullable()
    java.lang.Double minAmount, @org.jetbrains.annotations.Nullable()
    java.lang.Double maxAmount, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.personalfinance.app.domain.model.PaymentMethod> paymentMethods, @org.jetbrains.annotations.Nullable()
    java.lang.String searchQuery, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRecurring) {
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