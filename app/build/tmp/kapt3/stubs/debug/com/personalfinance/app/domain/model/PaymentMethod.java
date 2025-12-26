package com.personalfinance.app.domain.model;

import kotlinx.datetime.LocalDateTime;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/personalfinance/app/domain/model/PaymentMethod;", "", "(Ljava/lang/String;I)V", "CASH", "CREDIT_CARD", "DEBIT_CARD", "BANK_TRANSFER", "DIGITAL_WALLET", "CHECK", "OTHER", "app_debug"})
public enum PaymentMethod {
    /*public static final*/ CASH /* = new CASH() */,
    /*public static final*/ CREDIT_CARD /* = new CREDIT_CARD() */,
    /*public static final*/ DEBIT_CARD /* = new DEBIT_CARD() */,
    /*public static final*/ BANK_TRANSFER /* = new BANK_TRANSFER() */,
    /*public static final*/ DIGITAL_WALLET /* = new DIGITAL_WALLET() */,
    /*public static final*/ CHECK /* = new CHECK() */,
    /*public static final*/ OTHER /* = new OTHER() */;
    
    PaymentMethod() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.personalfinance.app.domain.model.PaymentMethod> getEntries() {
        return null;
    }
}