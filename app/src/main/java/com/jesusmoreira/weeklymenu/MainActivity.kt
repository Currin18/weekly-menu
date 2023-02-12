package com.jesusmoreira.weeklymenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.jesusmoreira.weeklymenu.ui.App
import com.jesusmoreira.weeklymenu.ui.menu.MenuViewModel
import com.jesusmoreira.weeklymenu.ui.theme.WeeklyMenuTheme

class MainActivity : ComponentActivity() {

    private val menuViewModel = MenuViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeeklyMenuTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    App(menuViewModel = menuViewModel)
                }
            }
        }
    }
}