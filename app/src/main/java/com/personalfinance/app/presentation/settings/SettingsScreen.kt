package com.personalfinance.app.presentation.settings

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.personalfinance.app.data.preferences.ThemeMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onNavigateBack: () -> Unit,
    paddingValues: PaddingValues? = null,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    val contentPadding = paddingValues ?: PaddingValues(0.dp)
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)
    ) {
        // Top bar for screens without bottom nav
        if (paddingValues == null) {
            TopAppBar(
                title = { Text("Settings") },
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
        
        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Appearance Section
            SettingsSection(
                title = "Appearance",
                icon = Icons.Default.Settings
            ) {
                ThemeSection(
                    currentThemeMode = uiState.themeMode,
                    onThemeModeChanged = viewModel::setThemeMode
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                DynamicColorSection(
                    dynamicColorEnabled = uiState.dynamicColorEnabled,
                    onDynamicColorChanged = viewModel::setDynamicColor
                )
            }
            
            // Accessibility Section
            SettingsSection(
                title = "Accessibility",
                icon = Icons.Default.Person
            ) {
                AccessibilitySection(
                    largeTextEnabled = uiState.largeTextEnabled,
                    onLargeTextChanged = viewModel::setLargeText,
                    highContrastEnabled = uiState.highContrastEnabled,
                    onHighContrastChanged = viewModel::setHighContrast
                )
            }
            
            // About Section
            SettingsSection(
                title = "About",
                icon = Icons.Default.Info
            ) {
                AboutSection()
            }
        }
    }
}

@Composable
private fun SettingsSection(
    title: String,
    icon: ImageVector,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .animateContentSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            
            content()
        }
    }
}

@Composable
private fun ThemeSection(
    currentThemeMode: ThemeMode,
    onThemeModeChanged: (ThemeMode) -> Unit
) {
    Column(
        modifier = Modifier.selectableGroup()
    ) {
        Text(
            text = "Theme Mode",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        ThemeOption(
            text = "System Default",
            description = "Follow system theme",
            selected = currentThemeMode == ThemeMode.SYSTEM,
            onClick = { onThemeModeChanged(ThemeMode.SYSTEM) }
        )
        
        ThemeOption(
            text = "Light Mode",
            description = "Always use light theme",
            selected = currentThemeMode == ThemeMode.LIGHT,
            onClick = { onThemeModeChanged(ThemeMode.LIGHT) }
        )
        
        ThemeOption(
            text = "Dark Mode",
            description = "Always use dark theme",
            selected = currentThemeMode == ThemeMode.DARK,
            onClick = { onThemeModeChanged(ThemeMode.DARK) }
        )
    }
}

@Composable
private fun DynamicColorSection(
    dynamicColorEnabled: Boolean,
    onDynamicColorChanged: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Dynamic Colors",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Use Material You colors (Android 12+)",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Switch(
            checked = dynamicColorEnabled,
            onCheckedChange = onDynamicColorChanged
        )
    }
}

@Composable
private fun AccessibilitySection(
    largeTextEnabled: Boolean,
    onLargeTextChanged: (Boolean) -> Unit,
    highContrastEnabled: Boolean,
    onHighContrastChanged: (Boolean) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Large Text Option
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Large Text",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Increase text size for better readability",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Switch(
                checked = largeTextEnabled,
                onCheckedChange = onLargeTextChanged
            )
        }
        
        // High Contrast Option
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "High Contrast",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Enhance contrast for better visibility",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Switch(
                checked = highContrastEnabled,
                onCheckedChange = onHighContrastChanged
            )
        }
    }
}

@Composable
private fun AboutSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        AboutItem(
            title = "Version",
            value = "1.0.0"
        )
        AboutItem(
            title = "Build",
            value = "Debug"
        )
        AboutItem(
            title = "Developer",
            value = "Personal Finance Team"
        )
    }
}

@Composable
private fun AboutItem(
    title: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun ThemeOption(
    text: String,
    description: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = selected,
                onClick = onClick,
                role = Role.RadioButton
            )
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = null
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}