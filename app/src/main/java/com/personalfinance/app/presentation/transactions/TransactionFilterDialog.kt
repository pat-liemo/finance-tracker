package com.personalfinance.app.presentation.transactions

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.personalfinance.app.domain.model.Category
import com.personalfinance.app.domain.model.PaymentMethod
import com.personalfinance.app.domain.model.TransactionFilter
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionFilterDialog(
    currentFilter: TransactionFilter,
    availableCategories: List<Category>,
    onDismiss: () -> Unit,
    onApplyFilter: (TransactionFilter) -> Unit
) {
    var selectedCategories by remember { mutableStateOf(currentFilter.categoryIds.toSet()) }
    var selectedPaymentMethods by remember { mutableStateOf(currentFilter.paymentMethods.toSet()) }
    var minAmount by remember { mutableStateOf(currentFilter.minAmount?.toString() ?: "") }
    var maxAmount by remember { mutableStateOf(currentFilter.maxAmount?.toString() ?: "") }
    var startDate by remember { mutableStateOf(currentFilter.startDate) }
    var endDate by remember { mutableStateOf(currentFilter.endDate) }
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Filter Transactions") },
        text = {
            LazyColumn(
                modifier = Modifier.height(400.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Categories section
                item {
                    Text(
                        text = "Categories",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    if (availableCategories.isNotEmpty()) {
                        availableCategories.forEach { category ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = selectedCategories.contains(category.id),
                                    onCheckedChange = { checked ->
                                        selectedCategories = if (checked) {
                                            selectedCategories + category.id
                                        } else {
                                            selectedCategories - category.id
                                        }
                                    }
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "${category.icon} ${category.name}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    } else {
                        Text(
                            text = "No categories available",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                
                // Amount range section
                item {
                    Text(
                        text = "Amount Range",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = minAmount,
                            onValueChange = { minAmount = it },
                            label = { Text("Min Amount") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = maxAmount,
                            onValueChange = { maxAmount = it },
                            label = { Text("Max Amount") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
                
                // Payment methods section
                item {
                    Text(
                        text = "Payment Methods",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    PaymentMethod.values().forEach { method ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = selectedPaymentMethods.contains(method),
                                onCheckedChange = { checked ->
                                    selectedPaymentMethods = if (checked) {
                                        selectedPaymentMethods + method
                                    } else {
                                        selectedPaymentMethods - method
                                    }
                                }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = method.name.replace("_", " "),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
                
                // Date range section
                item {
                    Text(
                        text = "Date Range",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Column {
                        OutlinedTextField(
                            value = startDate?.toString() ?: "",
                            onValueChange = { },
                            label = { Text("Start Date") },
                            readOnly = true,
                            trailingIcon = {
                                Icon(Icons.Default.DateRange, contentDescription = "Select start date")
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        OutlinedTextField(
                            value = endDate?.toString() ?: "",
                            onValueChange = { },
                            label = { Text("End Date") },
                            readOnly = true,
                            trailingIcon = {
                                Icon(Icons.Default.DateRange, contentDescription = "Select end date")
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            OutlinedButton(
                                onClick = {
                                    val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
                                    val thirtyDaysAgo = now.date.let { date ->
                                        kotlinx.datetime.LocalDate(date.year, date.month, date.dayOfMonth - 30)
                                    }
                                    startDate = LocalDateTime(thirtyDaysAgo, now.time)
                                    endDate = now
                                },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Last 30 Days")
                            }
                            
                            OutlinedButton(
                                onClick = {
                                    startDate = null
                                    endDate = null
                                },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("Clear Dates")
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    val filter = TransactionFilter(
                        categoryIds = selectedCategories.toList(),
                        paymentMethods = selectedPaymentMethods.toList(),
                        minAmount = minAmount.toDoubleOrNull(),
                        maxAmount = maxAmount.toDoubleOrNull(),
                        startDate = startDate,
                        endDate = endDate
                    )
                    onApplyFilter(filter)
                }
            ) {
                Text("Apply")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}