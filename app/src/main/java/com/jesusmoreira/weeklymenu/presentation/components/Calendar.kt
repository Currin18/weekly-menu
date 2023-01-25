package com.jesusmoreira.weeklymenu.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.util.Date

val MONTH_DAYS = listOf("L", "M", "X", "J", "V", "S", "D")

@Composable
fun Calendar(date: LocalDate) {
    Column {
        WeekRow(MONTH_DAYS)
        MonthGrid(date)
    }
}

@Composable
@Preview(showBackground = true)
fun CalendarPreview() {
    Calendar(LocalDate.now())
}

@Composable
fun WeekRow(listItems: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        listItems.forEach {
            Text(
                text = it,
                modifier = Modifier.width(24.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WeekRowPreview() {
    WeekRow(MONTH_DAYS)
}

@Composable
fun MonthGrid(date: LocalDate) {
    val month = LocalDate.of(date.year, date.month, 1)
    val dayOfWeek = month.dayOfWeek.value - 1
    val lengthOfMonth = month.lengthOfMonth() - 1
    val weeksList = mutableListOf<MutableList<String>>()
    for (i in 0.. lengthOfMonth + dayOfWeek) {
        if (i % 7 == 0) weeksList.add(mutableListOf("", "", "", "", "", "", ""))
        if (i >= dayOfWeek) weeksList.last()[i % 7] = "${i - dayOfWeek + 1}"
    }

    Column(
    ) {
        if (weeksList.isNotEmpty()) {
            for (week in weeksList) {
                WeekRow(listItems = week)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MonthGridPreview() {
    MonthGrid(LocalDate.now())
}