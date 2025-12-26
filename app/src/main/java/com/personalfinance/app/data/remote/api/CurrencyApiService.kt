package com.personalfinance.app.data.remote.api

import com.personalfinance.app.data.remote.dto.ExchangeRateResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyApiService {
    
    @GET("latest/{baseCurrency}")
    suspend fun getExchangeRates(
        @Path("baseCurrency") baseCurrency: String
    ): Response<ExchangeRateResponse>
}