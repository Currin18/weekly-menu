package com.jesusmoreira.weeklymenu.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val MONTH_DAYS = listOf("L", "M", "X", "J", "V", "S", "D")

@Composable
fun Calendar() {
    Column {
        WeekRow(MONTH_DAYS)
    }
}

@Composable
@Preview(showBackground = true)
fun CalendarPreview() {
    Calendar()
}

@Composable
fun WeekRow(listItems: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        listItems.forEach {
            Text(text = it)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WeekRowPreview() {
    WeekRow(MONTH_DAYS)
}

@Composable
fun MonthGrid() {
    val calendar = java.util.Calendar.getInstance()
    val day = calendar.get(java.util.Calendar.DAY_OF_MONTH)
    val month = calendar.get(java.util.Calendar.MONTH)
    val year = calendar.get(java.util.Calendar.YEAR)

    Text(text = "day: $day, month: $month, year: $year")
}

@Composable
@Preview(showBackground = true)
fun MonthGridPreview() {
    MonthGrid()
}