package com.personalfinance.app.domain.model

data class ExchangeRate(
    val baseCurrency: String,
    val targetCurrency: String,
    val rate: Double,
    val lastUpdated: Long = System.currentTimeMillis()
)

data class CurrencyConversion(
    val originalAmount: Double,
    val convertedAmount: Double,
    val fromCurrency: String,
    val toCurrency: String,
    val exchangeRate: Double,
    val conversionDate: Long = System.currentTimeMillis()
)