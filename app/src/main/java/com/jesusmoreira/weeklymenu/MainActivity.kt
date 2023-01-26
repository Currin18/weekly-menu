package com.jesusmoreira.weeklymenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jesusmoreira.weeklymenu.ui.App
import com.jesusmoreira.weeklymenu.ui.theme.WeeklyMenuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}