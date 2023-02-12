package com.jesusmoreira.weeklymenu.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopActionBar(title: String) {
    TopAppBar(
        title = {
            Text(text = title)
        },
//        navigationIcon = {
//            IconButton(onClick = {}) {
//                Icon(Icons.Filled.Menu, "backIcon")
//            }
//        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
        )
    )
}