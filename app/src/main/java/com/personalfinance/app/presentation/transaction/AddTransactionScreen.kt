package com.personalfinance.app.presentation.transaction

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.personalfinance.app.domain.model.PaymentMethod
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toJavaLocalDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTransactionScreen(
    onNavigateBack: () -> Unit,
    viewModel: AddTransactionViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    LaunchedEffect(uiState.error) {
        if (uiState.error != null) {
            // Error will be shown in the UI, clear it after some time
            kotlinx.coroutines.delay(5000)
            viewModel.clearError()
        }
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Transaction") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Error message
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
            
            // Amount input
            OutlinedTextField(
                value = uiState.amount,
                onValueChange = viewModel::updateAmount,
                label = { Text("Amount") },
                placeholder = { Text("0.00") },
                leadingIcon = { Text("$") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                isError = uiState.amountError != null,
                supportingText = uiState.amountError?.let { { Text(it) } },
                modifier = Modifier.fillMaxWidth()
            )
            
            // Transaction type selection
            Card {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Transaction Type",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .weight(1f)
                                .selectable(
                                    selected = !uiState.isIncome,
                                    onClick = { viewModel.updateTransactionType(false) },
                                    role = Role.RadioButton
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = !uiState.isIncome,
                                onClick = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Expense")
                        }
                        
                        Row(
                            modifier = Modifier
                                .weight(1f)
                                .selectable(
                                    selected = uiState.isIncome,
                                    onClick = { viewModel.updateTransactionType(true) },
                                    role = Role.RadioButton
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = uiState.isIncome,
                                onClick = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Income")
                        }
                    }
                }
            }
            
            // Category selection with dropdown
            var categoryExpanded by remember { mutableStateOf(false) }
            
            ExposedDropdownMenuBox(
                expanded = categoryExpanded,
                onExpandedChange = { categoryExpanded = !categoryExpanded }
            ) {
                OutlinedTextField(
                    value = uiState.category,
                    onValueChange = { },
                    readOnly = true,
                    label = { Text("Category") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = categoryExpanded) },
                    isError = uiState.categoryError != null,
                    supportingText = uiState.categoryError?.let { { Text(it) } },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )
                
                ExposedDropdownMenu(
                    expanded = categoryExpanded,
                    onDismissRequest = { categoryExpanded = false }
                ) {
                    uiState.availableCategories.forEach { category ->
                        DropdownMenuItem(
                            text = { 
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(category.icon)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(category.name)
                                }
                            },
                            onClick = {
                                viewModel.updateCategory(category.id)
                                categoryExpanded = false
                            }
                        )
                    }
                    
                    if (uiState.availableCategories.isEmpty()) {
                        DropdownMenuItem(
                            text = { Text("No categories available") },
                            onClick = { categoryExpanded = false }
                        )
                    }
                }
            }
            
            // Date selection
            OutlinedTextField(
                value = formatDate(uiState.date),
                onValueChange = { },
                label = { Text("Date") },
                readOnly = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select date"
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
            
            // Payment method selection
            var expanded by remember { mutableStateOf(false) }
            
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = uiState.paymentMethod.name.replace("_", " "),
                    onValueChange = { },
                    readOnly = true,
                    label = { Text("Payment Method") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )
                
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    PaymentMethod.values().forEach { method ->
                        DropdownMenuItem(
                            text = { Text(method.name.replace("_", " ")) },
                            onClick = {
                                viewModel.updatePaymentMethod(method)
                                expanded = false
                            }
                        )
                    }
                }
            }
            
            // Recurring transaction option
            Card {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Make this recurring",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Medium
                        )
                        Switch(
                            checked = uiState.isRecurring,
                            onCheckedChange = viewModel::updateIsRecurring
                        )
                    }
                    
                    if (uiState.isRecurring) {
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Frequency selection
                        var frequencyExpanded by remember { mutableStateOf(false) }
                        
                        ExposedDropdownMenuBox(
                            expanded = frequencyExpanded,
                            onExpandedChange = { frequencyExpanded = !frequencyExpanded }
                        ) {
                            OutlinedTextField(
                                value = uiState.recurringFrequency.name.lowercase().replaceFirstChar { it.uppercase() },
                                onValueChange = { },
                                readOnly = true,
                                label = { Text("Frequency") },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = frequencyExpanded) },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .menuAnchor()
                            )
                            
                            ExposedDropdownMenu(
                                expanded = frequencyExpanded,
                                onDismissRequest = { frequencyExpanded = false }
                            ) {
                                com.personalfinance.app.domain.model.RecurringFrequency.values().forEach { frequency ->
                                    DropdownMenuItem(
                                        text = { Text(frequency.name.lowercase().replaceFirstChar { it.uppercase() }) },
                                        onClick = {
                                            viewModel.updateRecurringFrequency(frequency)
                                            frequencyExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        // Interval input
                        OutlinedTextField(
                            value = uiState.recurringInterval.toString(),
                            onValueChange = { 
                                it.toIntOrNull()?.let { interval ->
                                    if (interval > 0) viewModel.updateRecurringInterval(interval)
                                }
                            },
                            label = { Text("Every X ${uiState.recurringFrequency.name.lowercase()}${if (uiState.recurringInterval > 1) "s" else ""}") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
            OutlinedTextField(
                value = uiState.note,
                onValueChange = viewModel::updateNote,
                label = { Text("Note (Optional)") },
                placeholder = { Text("Add a description...") },
                minLines = 3,
                maxLines = 5,
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Save button
            Button(
                onClick = { viewModel.saveTransaction(onNavigateBack) },
                enabled = !uiState.isLoading,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(16.dp),
                        strokeWidth = 2.dp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Text("Save Transaction")
            }
        }
    }
}

private fun formatDate(date: LocalDateTime): String {
    val javaDate = date.toJavaLocalDateTime()
    return javaDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"))
}