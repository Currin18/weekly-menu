package com.jesusmoreira.weeklymenu.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jesusmoreira.weeklymenu.ui.menu.MenuScreen
import com.jesusmoreira.weeklymenu.ui.menu.MenuViewModel
import com.jesusmoreira.weeklymenu.ui.theme.WeeklyMenuTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(menuViewModel: MenuViewModel) {
    WeeklyMenuTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Weekly Menu")
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.Menu, "backIcon")
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White,
                    )
                )
            }, content = {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                        .background(Color.White),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MenuScreen(menuViewModel)
                }
            }
        )
    }
}

@Composable
@Preview(
    showSystemUi = true,
    showBackground = true
)
fun AppPreview() {
    App(menuViewModel = MenuViewModel())
}