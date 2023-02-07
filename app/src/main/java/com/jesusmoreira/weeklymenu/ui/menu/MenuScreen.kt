package com.jesusmoreira.weeklymenu.ui.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jesusmoreira.weeklymenu.ui.menu.components.Calendar
import java.time.LocalDate

@Composable
fun MenuScreen(viewModel: MenuViewModel) {
    val selectedDate: LocalDate by viewModel.selectedDate
        .observeAsState(initial = viewModel.today)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Calendar(
            today = viewModel.today,
            selectedDate = selectedDate,
            onSelectDateChange = { viewModel.onSelectedDateChange(it) }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MenuScreenPreview() {
    MenuScreen(viewModel = MenuViewModel())
}
