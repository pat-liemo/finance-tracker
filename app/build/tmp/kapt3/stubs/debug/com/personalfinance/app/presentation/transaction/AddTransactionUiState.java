package com.personalfinance.app.presentation.transaction;

import androidx.lifecycle.ViewModel;
import com.personalfinance.app.domain.model.Category;
import com.personalfinance.app.domain.model.PaymentMethod;
import com.personalfinance.app.domain.model.RecurringFrequency;
import com.personalfinance.app.domain.model.RecurringPattern;
import com.personalfinance.app.domain.model.Transaction;
import com.personalfinance.app.domain.repository.AuthRepository;
import com.personalfinance.app.domain.repository.CategoryRepository;
import com.personalfinance.app.domain.repository.TransactionRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.datetime.Clock;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0018J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u00c6\u0003J\t\u0010-\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\bH\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u000bH\u00c6\u0003J\t\u00106\u001a\u00020\u0005H\u00c6\u0003J\t\u00107\u001a\u00020\u000eH\u00c6\u0003J\t\u00108\u001a\u00020\u0010H\u00c6\u0003J\u00a1\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010:\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010<\u001a\u00020\u0010H\u00d6\u0001J\t\u0010=\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010#R\u0011\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010#R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010#R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*\u00a8\u0006>"}, d2 = {"Lcom/personalfinance/app/presentation/transaction/AddTransactionUiState;", "", "amount", "", "isIncome", "", "category", "date", "Lkotlinx/datetime/LocalDateTime;", "note", "paymentMethod", "Lcom/personalfinance/app/domain/model/PaymentMethod;", "isRecurring", "recurringFrequency", "Lcom/personalfinance/app/domain/model/RecurringFrequency;", "recurringInterval", "", "availableCategories", "", "Lcom/personalfinance/app/domain/model/Category;", "isLoading", "error", "amountError", "categoryError", "(Ljava/lang/String;ZLjava/lang/String;Lkotlinx/datetime/LocalDateTime;Ljava/lang/String;Lcom/personalfinance/app/domain/model/PaymentMethod;ZLcom/personalfinance/app/domain/model/RecurringFrequency;ILjava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getAmountError", "getAvailableCategories", "()Ljava/util/List;", "getCategory", "getCategoryError", "getDate", "()Lkotlinx/datetime/LocalDateTime;", "getError", "()Z", "getNote", "getPaymentMethod", "()Lcom/personalfinance/app/domain/model/PaymentMethod;", "getRecurringFrequency", "()Lcom/personalfinance/app/domain/model/RecurringFrequency;", "getRecurringInterval", "()I", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class AddTransactionUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String amount = null;
    private final boolean isIncome = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String category = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.datetime.LocalDateTime date = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String note = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.domain.model.PaymentMethod paymentMethod = null;
    private final boolean isRecurring = false;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.domain.model.RecurringFrequency recurringFrequency = null;
    private final int recurringInterval = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.personalfinance.app.domain.model.Category> availableCategories = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String amountError = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String categoryError = null;
    
    public AddTransactionUiState(@org.jetbrains.annotations.NotNull()
    java.lang.String amount, boolean isIncome, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime date, @org.jetbrains.annotations.NotNull()
    java.lang.String note, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.PaymentMethod paymentMethod, boolean isRecurring, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.RecurringFrequency recurringFrequency, int recurringInterval, @org.jetbrains.annotations.NotNull()
    java.util.List<com.personalfinance.app.domain.model.Category> availableCategories, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, @org.jetbrains.annotations.Nullable()
    java.lang.String amountError, @org.jetbrains.annotations.Nullable()
    java.lang.String categoryError) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAmount() {
        return null;
    }
    
    public final boolean isIncome() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.LocalDateTime getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNote() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.PaymentMethod getPaymentMethod() {
        return null;
    }
    
    public final boolean isRecurring() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.RecurringFrequency getRecurringFrequency() {
        return null;
    }
    
    public final int getRecurringInterval() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.personalfinance.app.domain.model.Category> getAvailableCategories() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAmountError() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCategoryError() {
        return null;
    }
    
    public AddTransactionUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.personalfinance.app.domain.model.Category> component10() {
        return null;
    }
    
    public final boolean component11() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    public final boolean component2() {
        return false;
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
    
    public final boolean component7() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.domain.model.RecurringFrequency component8() {
        return null;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.personalfinance.app.presentation.transaction.AddTransactionUiState copy(@org.jetbrains.annotations.NotNull()
    java.lang.String amount, boolean isIncome, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime date, @org.jetbrains.annotations.NotNull()
    java.lang.String note, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.PaymentMethod paymentMethod, boolean isRecurring, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.RecurringFrequency recurringFrequency, int recurringInterval, @org.jetbrains.annotations.NotNull()
    java.util.List<com.personalfinance.app.domain.model.Category> availableCategories, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, @org.jetbrains.annotations.Nullable()
    java.lang.String amountError, @org.jetbrains.annotations.Nullable()
    java.lang.String categoryError) {
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