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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0014\u0010\u0013\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0018J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00112\u0006\u0010\'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020 J\u001c\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180/2\u0006\u00100\u001a\u00020\u000bH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u00061"}, d2 = {"Lcom/personalfinance/app/presentation/transaction/AddTransactionViewModel;", "Landroidx/lifecycle/ViewModel;", "transactionRepository", "Lcom/personalfinance/app/domain/repository/TransactionRepository;", "categoryRepository", "Lcom/personalfinance/app/domain/repository/CategoryRepository;", "authRepository", "Lcom/personalfinance/app/domain/repository/AuthRepository;", "(Lcom/personalfinance/app/domain/repository/TransactionRepository;Lcom/personalfinance/app/domain/repository/CategoryRepository;Lcom/personalfinance/app/domain/repository/AuthRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/personalfinance/app/presentation/transaction/AddTransactionUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearError", "", "loadCategories", "saveTransaction", "onSuccess", "Lkotlin/Function0;", "updateAmount", "amount", "", "updateCategory", "categoryId", "updateDate", "date", "Lkotlinx/datetime/LocalDateTime;", "updateIsRecurring", "isRecurring", "", "updateNote", "note", "updatePaymentMethod", "paymentMethod", "Lcom/personalfinance/app/domain/model/PaymentMethod;", "updateRecurringFrequency", "frequency", "Lcom/personalfinance/app/domain/model/RecurringFrequency;", "updateRecurringInterval", "interval", "", "updateTransactionType", "isIncome", "validateForm", "", "state", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AddTransactionViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.domain.repository.TransactionRepository transactionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.domain.repository.CategoryRepository categoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.personalfinance.app.domain.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.personalfinance.app.presentation.transaction.AddTransactionUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.personalfinance.app.presentation.transaction.AddTransactionUiState> uiState = null;
    
    @javax.inject.Inject()
    public AddTransactionViewModel(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.repository.TransactionRepository transactionRepository, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.repository.CategoryRepository categoryRepository, @org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.personalfinance.app.presentation.transaction.AddTransactionUiState> getUiState() {
        return null;
    }
    
    private final void loadCategories() {
    }
    
    public final void updateAmount(@org.jetbrains.annotations.NotNull()
    java.lang.String amount) {
    }
    
    public final void updateTransactionType(boolean isIncome) {
    }
    
    public final void updateCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String categoryId) {
    }
    
    public final void updateDate(@org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime date) {
    }
    
    public final void updateNote(@org.jetbrains.annotations.NotNull()
    java.lang.String note) {
    }
    
    public final void updatePaymentMethod(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.PaymentMethod paymentMethod) {
    }
    
    public final void updateIsRecurring(boolean isRecurring) {
    }
    
    public final void updateRecurringFrequency(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.RecurringFrequency frequency) {
    }
    
    public final void updateRecurringInterval(int interval) {
    }
    
    public final void saveTransaction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    private final java.util.Map<java.lang.String, java.lang.String> validateForm(com.personalfinance.app.presentation.transaction.AddTransactionUiState state) {
        return null;
    }
    
    public final void clearError() {
    }
}