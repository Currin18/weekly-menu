package com.jesusmoreira.weeklymenu.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopActionBar(title: String, showBackButton: Boolean, onBackButton: () -> Unit = {}) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { onBackButton() }) {
                    Icon(Icons.Filled.ArrowBack, "Back icon")
                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
        )
    )
}