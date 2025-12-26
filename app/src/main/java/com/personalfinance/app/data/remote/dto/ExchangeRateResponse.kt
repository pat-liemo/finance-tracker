package com.personalfinance.app.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ExchangeRateResponse(
    @SerializedName("base")
    val baseCurrency: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("rates")
    val rates: Map<String, Double>
)