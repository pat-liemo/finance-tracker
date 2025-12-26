package com.personalfinance.app.domain.repository

import com.personalfinance.app.domain.model.DateRange

interface ExportRepository {
    suspend fun exportTransactionsToCSV(dateRange: DateRange): Result<String>
    suspend fun exportTransactionsToExcel(dateRange: DateRange): Result<String>
    suspend fun exportTransactionsToPDF(dateRange: DateRange): Result<String>
    suspend fun exportAnalyticsReport(dateRange: DateRange, format: String): Result<String>
}