package com.personalfinance.app.presentation.analytics

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.column.columnChart
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.entryOf
import kotlinx.datetime.LocalDate
import java.text.NumberFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnalyticsScreen(
    paddingValues: PaddingValues? = null,
    viewModel: AnalyticsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var showExportDialog by remember { mutableStateOf(false) }
    
    val contentPadding = paddingValues ?: PaddingValues(0.dp)
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)
    ) {
        // Top bar for screens without bottom nav
        if (paddingValues == null) {
            TopAppBar(
                title = { Text("Analytics & Reports") },
                actions = {
                    IconButton(onClick = { showExportDialog = true }) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Export Data"
                        )
                    }
                    IconButton(onClick = { viewModel.refreshAnalytics() }) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Refresh"
                        )
                    }
                }
            )
        }
        
        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Date range header
            uiState.dateRange?.let { dateRange ->
                Card {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Current Month Analysis",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = "${formatDate(dateRange.startDate)} - ${formatDate(dateRange.endDate)}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
            
            // Loading state
            if (uiState.isLoading) {
                Card {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
            
            // Error state
            uiState.error?.let { error ->
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer
                    )
                ) {
                    Text(
                        text = error,
                        modifier = Modifier.padding(16.dp),
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }
            
            // Income vs Expense Chart
            uiState.incomeVsExpenseChart?.let { chartData ->
                IncomeVsExpenseChart(chartData = chartData)
            }
            
            // Spending Breakdown (Pie Chart equivalent)
            uiState.spendingBreakdown?.let { breakdown ->
                SpendingBreakdownCard(breakdown = breakdown)
            }
            
            // Trends Analysis
            uiState.trendAnalysis?.let { trends ->
                TrendsCard(trends = trends)
            }
            
            // Budget Utilization
            uiState.budgetUtilization?.let { budgetUtils ->
                if (budgetUtils.isNotEmpty()) {
                    BudgetUtilizationCard(budgetUtilizations = budgetUtils)
                }
            }
            
            // Insights and Behavior Changes
            uiState.insights?.let { insights ->
                if (insights.isNotEmpty()) {
                    InsightsCard(insights = insights)
                }
            }
            
            // Empty state
            if (!uiState.isLoading && uiState.error == null && 
                uiState.spendingBreakdown?.totalAmount == 0.0) {
                Card {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "No Data Available",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Add some transactions to see your analytics",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
    
    // Export Dialog
    if (showExportDialog) {
        ExportDataDialog(
            onDismiss = { showExportDialog = false },
            onExport = { format ->
                viewModel.exportData(format)
                showExportDialog = false
            }
        )
    }
}

@Composable
private fun IncomeVsExpenseChart(chartData: com.personalfinance.app.domain.model.ChartData) {
    Card {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Income vs Expenses",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            if (chartData.datasets.isNotEmpty() && chartData.datasets[0].data.isNotEmpty()) {
                val income = chartData.datasets[0].data.getOrNull(0) ?: 0.0
                val expenses = chartData.datasets[0].data.getOrNull(1) ?: 0.0
                
                // Create chart entries
                val chartEntryModelProducer = ChartEntryModelProducer()
                
                LaunchedEffect(chartData) {
                    chartEntryModelProducer.setEntries(
                        listOf(
                            entryOf(0f, income.toFloat()),
                            entryOf(1f, expenses.toFloat())
                        )
                    )
                }
                
                // Chart
                Chart(
                    chart = columnChart(),
                    chartModelProducer = chartEntryModelProducer,
                    startAxis = rememberStartAxis(),
                    bottomAxis = rememberBottomAxis(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Summary
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Income",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = formatCurrency(income),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF4CAF50) // Green
                        )
                    }
                    
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Expenses",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = formatCurrency(expenses),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFFF44336) // Red
                        )
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No data available",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun SpendingBreakdownCard(breakdown: com.personalfinance.app.domain.model.SpendingBreakdown) {
    Card {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Spending by Category",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "Total: ${formatCurrency(breakdown.totalAmount)}",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            if (breakdown.categoryBreakdown.isNotEmpty()) {
                breakdown.categoryBreakdown.entries.sortedByDescending { it.value }.forEach { (category, amount) ->
                    val percentage = breakdown.percentageBreakdown[category] ?: 0.0
                    
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = category,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = "${String.format("%.1f", percentage)}%",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        
                        Text(
                            text = formatCurrency(amount),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    
                    // Progress bar
                    LinearProgressIndicator(
                        progress = { (percentage / 100).toFloat() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                }
            } else {
                Text(
                    text = "No expenses recorded",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }
        }
    }
}

private fun formatDate(date: LocalDate): String {
    return "${date.month.name.lowercase().replaceFirstChar { it.uppercase() }} ${date.dayOfMonth}, ${date.year}"
}

private fun formatCurrency(amount: Double): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale.US)
    return formatter.format(amount)
}

@Composable
private fun TrendsCard(trends: com.personalfinance.app.domain.model.TrendAnalysis) {
    Card {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Spending Trends",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            trends.trends.forEach { trend ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = trend.category,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = trend.description,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    
                    // Trend indicator
                    val trendColor = when (trend.direction) {
                        com.personalfinance.app.domain.model.TrendDirection.INCREASING -> Color(0xFFF44336) // Red
                        com.personalfinance.app.domain.model.TrendDirection.DECREASING -> Color(0xFF4CAF50) // Green
                        com.personalfinance.app.domain.model.TrendDirection.STABLE -> Color(0xFF2196F3) // Blue
                    }
                    
                    val trendIcon = when (trend.direction) {
                        com.personalfinance.app.domain.model.TrendDirection.INCREASING -> "↗"
                        com.personalfinance.app.domain.model.TrendDirection.DECREASING -> "↘"
                        com.personalfinance.app.domain.model.TrendDirection.STABLE -> "→"
                    }
                    
                    Text(
                        text = trendIcon,
                        style = MaterialTheme.typography.titleLarge,
                        color = trendColor
                    )
                }
            }
        }
    }
}

@Composable
private fun BudgetUtilizationCard(budgetUtilizations: List<com.personalfinance.app.domain.model.BudgetUtilization>) {
    Card {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Budget Utilization",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            budgetUtilizations.forEach { budget ->
                Column(
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = budget.categoryName,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = "${formatCurrency(budget.spentAmount)} / ${formatCurrency(budget.budgetAmount)}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(4.dp))
                    
                    val progressColor = when (budget.status) {
                        com.personalfinance.app.domain.model.BudgetStatus.ON_TRACK -> Color(0xFF4CAF50) // Green
                        com.personalfinance.app.domain.model.BudgetStatus.APPROACHING_LIMIT -> Color(0xFFFF9800) // Orange
                        com.personalfinance.app.domain.model.BudgetStatus.OVER_BUDGET -> Color(0xFFF44336) // Red
                    }
                    
                    LinearProgressIndicator(
                        progress = { (budget.utilizationPercentage / 100).coerceAtMost(1.0).toFloat() },
                        modifier = Modifier.fillMaxWidth(),
                        color = progressColor
                    )
                    
                    Spacer(modifier = Modifier.height(4.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${String.format("%.1f", budget.utilizationPercentage)}% used",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        
                        val remainingText = if (budget.remainingAmount >= 0) {
                            "Remaining: ${formatCurrency(budget.remainingAmount)}"
                        } else {
                            "Over by: ${formatCurrency(-budget.remainingAmount)}"
                        }
                        
                        Text(
                            text = remainingText,
                            style = MaterialTheme.typography.bodySmall,
                            color = if (budget.remainingAmount >= 0) {
                                MaterialTheme.colorScheme.onSurfaceVariant
                            } else {
                                Color(0xFFF44336)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun InsightsCard(insights: List<String>) {
    Card {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Financial Insights",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            insights.forEach { insight ->
                Row(
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Text(
                        text = "• ",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = insight,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun ExportDataDialog(
    onDismiss: () -> Unit,
    onExport: (String) -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Export Data") },
        text = {
            Column {
                Text("Choose export format:")
                Spacer(modifier = Modifier.height(16.dp))
                
                listOf("CSV", "Excel", "PDF").forEach { format ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(
                            onClick = { onExport(format) },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Export as $format")
                        }
                    }
                }
            }
        },
        confirmButton = { },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}