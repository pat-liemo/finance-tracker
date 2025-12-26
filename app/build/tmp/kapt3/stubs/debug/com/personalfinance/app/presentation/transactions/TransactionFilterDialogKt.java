package com.personalfinance.app.presentation.transactions;

import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import com.personalfinance.app.domain.model.Category;
import com.personalfinance.app.domain.model.PaymentMethod;
import com.personalfinance.app.domain.model.TransactionFilter;
import kotlinx.datetime.Clock;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\nH\u0007\u00a8\u0006\u000b"}, d2 = {"TransactionFilterDialog", "", "currentFilter", "Lcom/personalfinance/app/domain/model/TransactionFilter;", "availableCategories", "", "Lcom/personalfinance/app/domain/model/Category;", "onDismiss", "Lkotlin/Function0;", "onApplyFilter", "Lkotlin/Function1;", "app_debug"})
public final class TransactionFilterDialogKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void TransactionFilterDialog(@org.jetbrains.annotations.NotNull()
    com.personalfinance.app.domain.model.TransactionFilter currentFilter, @org.jetbrains.annotations.NotNull()
    java.util.List<com.personalfinance.app.domain.model.Category> availableCategories, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.personalfinance.app.domain.model.TransactionFilter, kotlin.Unit> onApplyFilter) {
    }
}