package com.jesusmoreira.weeklymenu.ui.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jesusmoreira.weeklymenu.R
import com.jesusmoreira.weeklymenu.ui.common.BottomNavigationBar
import com.jesusmoreira.weeklymenu.ui.common.TopActionBar
import com.jesusmoreira.weeklymenu.ui.menu.components.Calendar
import com.jesusmoreira.weeklymenu.ui.menu.components.DailyMenu
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavHostController, viewModel: MenuViewModel) {
    val selectedDate: LocalDate by viewModel.selectedDate
        .observeAsState(initial = viewModel.today)
    val selectedMonth: Int by viewModel.selectedMonth
        .observeAsState(initial = viewModel.today.monthValue)
    val selectedYear: Int by viewModel.selectedYear
        .observeAsState(initial = viewModel.today.year)

    Scaffold(
        topBar = { TopActionBar(stringResource(id = R.string.menu)) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Calendar(
                        today = viewModel.today,
                        selectedDate = selectedDate,
                        selectedMonth = selectedMonth,
                        selectedYear = selectedYear,
                        onSelectDateChange = { viewModel.onSelectedDateChange(it) }
                    )
                    DailyMenu(selectedDate = selectedDate)
                }
            }
        },
        bottomBar = { BottomNavigationBar(navController = navController) }
    )
}

@Composable
@Preview(showBackground = true)
fun MenuScreenPreview() {
    MenuScreen(rememberNavController(), MenuViewModel())
}
