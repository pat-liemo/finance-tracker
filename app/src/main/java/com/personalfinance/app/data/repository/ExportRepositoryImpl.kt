package com.personalfinance.app.data.repository

import com.personalfinance.app.data.local.dao.TransactionDao
import com.personalfinance.app.data.local.dao.CategoryDao
import com.personalfinance.app.domain.model.DateRange
import com.personalfinance.app.domain.repository.ExportRepository
import kotlinx.coroutines.flow.first
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.atTime
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject
import kotlin.math.abs

class ExportRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDao,
    private val categoryDao: CategoryDao
) : ExportRepository {
    
    override suspend fun exportTransactionsToCSV(dateRange: DateRange): Result<String> {
        return try {
            val startDateTime = dateRange.startDate.atStartOfDayIn(TimeZone.currentSystemDefault()).toLocalDateTime(TimeZone.currentSystemDefault())
            val endDateTime = dateRange.endDate.atTime(23, 59, 59)
            
            val transactions = transactionDao.getTransactionsByDateRange("", startDateTime, endDateTime).first()
            
            val csvBuilder = StringBuilder()
            csvBuilder.appendLine("Date,Description,Category,Amount,Payment Method,Type")
            
            for (transaction in transactions) {
                val category = categoryDao.getCategoryById(transaction.categoryId)
                val categoryName = category?.name ?: transaction.categoryId
                val type = if (transaction.amount >= 0) "Income" else "Expense"
                val amount = abs(transaction.amount)
                
                csvBuilder.appendLine(
                    "${transaction.date.date}," +
                    "\"${transaction.description}\"," +
                    "\"$categoryName\"," +
                    "$amount," +
                    "${transaction.paymentMethod.name.replace("_", " ")}," +
                    "$type"
                )
            }
            
            Result.success(csvBuilder.toString())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun exportTransactionsToExcel(dateRange: DateRange): Result<String> {
        return try {
            // For now, return CSV format as Excel implementation would require additional libraries
            // In a real implementation, you would use Apache POI or similar library
            val csvResult = exportTransactionsToCSV(dateRange)
            csvResult.fold(
                onSuccess = { csvData ->
                    Result.success("Excel export not fully implemented. CSV data: $csvData")
                },
                onFailure = { exception ->
                    Result.failure(exception)
                }
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun exportTransactionsToPDF(dateRange: DateRange): Result<String> {
        return try {
            val startDateTime = dateRange.startDate.atStartOfDayIn(TimeZone.currentSystemDefault()).toLocalDateTime(TimeZone.currentSystemDefault())
            val endDateTime = dateRange.endDate.atTime(23, 59, 59)
            
            val transactions = transactionDao.getTransactionsByDateRange("", startDateTime, endDateTime).first()
            
            // For now, return a simple text report
            // In a real implementation, you would use a PDF library like iText
            val reportBuilder = StringBuilder()
            reportBuilder.appendLine("FINANCIAL REPORT")
            reportBuilder.appendLine("Period: ${dateRange.startDate} to ${dateRange.endDate}")
            reportBuilder.appendLine("Generated: ${kotlinx.datetime.Clock.System.now()}")
            reportBuilder.appendLine("=" + "=".repeat(49))
            reportBuilder.appendLine()
            
            val income = transactions.filter { it.amount > 0 }.sumOf { it.amount }
            val expenses = abs(transactions.filter { it.amount < 0 }.sumOf { it.amount })
            val net = income - expenses
            
            reportBuilder.appendLine("SUMMARY:")
            reportBuilder.appendLine("Total Income: $${String.format("%.2f", income)}")
            reportBuilder.appendLine("Total Expenses: $${String.format("%.2f", expenses)}")
            reportBuilder.appendLine("Net: $${String.format("%.2f", net)}")
            reportBuilder.appendLine()
            
            reportBuilder.appendLine("TRANSACTIONS:")
            for (transaction in transactions.sortedByDescending { it.date }) {
                val category = categoryDao.getCategoryById(transaction.categoryId)
                val categoryName = category?.name ?: transaction.categoryId
                val type = if (transaction.amount >= 0) "Income" else "Expense"
                val amount = abs(transaction.amount)
                
                reportBuilder.appendLine(
                    "${transaction.date.date} | $type | $categoryName | $${String.format("%.2f", amount)} | ${transaction.description}"
                )
            }
            
            Result.success(reportBuilder.toString())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun exportAnalyticsReport(dateRange: DateRange, format: String): Result<String> {
        return try {
            when (format.uppercase()) {
                "CSV" -> exportTransactionsToCSV(dateRange)
                "EXCEL" -> exportTransactionsToExcel(dateRange)
                "PDF" -> exportTransactionsToPDF(dateRange)
                else -> Result.failure(IllegalArgumentException("Unsupported format: $format"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}