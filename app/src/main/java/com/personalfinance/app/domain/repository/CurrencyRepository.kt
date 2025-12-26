package com.personalfinance.app.domain.repository

import com.personalfinance.app.domain.model.ExchangeRate
import com.personalfinance.app.domain.model.CurrencyConversion

interface CurrencyRepository {
    suspend fun getExchangeRates(baseCurrency: String): Result<List<ExchangeRate>>
    suspend fun convertCurrency(
        amount: Double,
        fromCurrency: String,
        toCurrency: String
    ): Result<CurrencyConversion>
    suspend fun getCachedRates(): List<ExchangeRate>
    suspend fun updateExchangeRates(): Result<Unit>
}