package com.personalfinance.app.presentation.transactions

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.personalfinance.app.domain.model.PaymentMethod
import com.personalfinance.app.domain.model.Transaction
import kotlinx.datetime.toJavaLocalDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsScreen(
    onNavigateBack: () -> Unit,
    viewModel: TransactionsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var showFilterDialog by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    
    LaunchedEffect(Unit) {
        viewModel.loadTransactions()
    }
    
    LaunchedEffect(searchQuery) {
        viewModel.updateSearchQuery(searchQuery)
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Transactions") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { showFilterDialog = true }) {
                        Icon(Icons.Default.Menu, contentDescription = "Filter")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Search bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search transactions...") },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            
            // Active filters display
            if (uiState.hasActiveFilters) {
                ActiveFiltersRow(
                    uiState = uiState,
                    onClearFilters = { viewModel.clearFilters() },
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            
            when {
                uiState.isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                
                uiState.filteredTransactions.isEmpty() -> {
                    EmptyTransactionsState(
                        hasFilters = uiState.hasActiveFilters,
                        onClearFilters = { viewModel.clearFilters() }
                    )
                }
                
                else -> {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(uiState.filteredTransactions) { transaction ->
                            TransactionItem(transaction = transaction)
                        }
                    }
                }
            }
        }
    }
    
    if (showFilterDialog) {
        TransactionFilterDialog(
            currentFilter = uiState.currentFilter,
            availableCategories = uiState.availableCategories,
            onDismiss = { showFilterDialog = false },
            onApplyFilter = { filter ->
                viewModel.applyFilter(filter)
                showFilterDialog = false
            }
        )
    }
    
    uiState.errorMessage?.let { error ->
        LaunchedEffect(error) {
            // Show snackbar or handle error
        }
    }
}

@Composable
fun ActiveFiltersRow(
    uiState: TransactionsUiState,
    onClearFilters: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Filters:",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        // Show active filter chips
        uiState.currentFilter.categoryIds.forEach { categoryId ->
            FilterChip(
                onClick = { },
                label = { Text(categoryId) },
                selected = true
            )
        }
        
        if (uiState.currentFilter.minAmount != null || uiState.currentFilter.maxAmount != null) {
            FilterChip(
                onClick = { },
                label = { 
                    Text("Amount: ${uiState.currentFilter.minAmount ?: 0} - ${uiState.currentFilter.maxAmount ?: "∞"}")
                },
                selected = true
            )
        }
        
        uiState.currentFilter.paymentMethods.forEach { method ->
            FilterChip(
                onClick = { },
                label = { Text(method.name.replace("_", " ")) },
                selected = true
            )
        }
        
        Spacer(modifier = Modifier.weight(1f))
        
        TextButton(onClick = onClearFilters) {
            Text("Clear All")
        }
    }
}

@Composable
fun EmptyTransactionsState(
    hasFilters: Boolean,
    onClearFilters: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = if (hasFilters) "No transactions match your filters" else "No transactions found",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = if (hasFilters) "Try adjusting your search criteria" else "Add some transactions to see them here",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        if (hasFilters) {
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onClearFilters) {
                Text("Clear Filters")
            }
        }
    }
}

@Composable
private fun TransactionItem(
    transaction: Transaction,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = transaction.description.ifEmpty { "Transaction" },
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
                
                Spacer(modifier = Modifier.height(4.dp))
                
                Text(
                    text = "Category: ${transaction.categoryId}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                Spacer(modifier = Modifier.height(2.dp))
                
                Text(
                    text = formatDate(transaction.date),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = formatAmount(transaction.amount),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = if (transaction.amount >= 0) {
                        Color(0xFF4CAF50) // Green for income
                    } else {
                        Color(0xFFF44336) // Red for expense
                    }
                )
                
                Spacer(modifier = Modifier.height(4.dp))
                
                Text(
                    text = transaction.paymentMethod.name.replace("_", " "),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

private fun formatDate(date: kotlinx.datetime.LocalDateTime): String {
    val javaDate = date.toJavaLocalDateTime()
    return javaDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"))
}

private fun formatAmount(amount: Double): String {
    return if (amount >= 0) {
        "+$%.2f".format(amount)
    } else {
        "-$%.2f".format(-amount)
    }
}