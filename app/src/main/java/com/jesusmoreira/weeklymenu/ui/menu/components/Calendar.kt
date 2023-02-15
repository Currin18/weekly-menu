package com.jesusmoreira.weeklymenu.ui.menu.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jesusmoreira.weeklymenu.core.utils.DateUtils
import java.time.LocalDate

@Composable
fun Calendar(
    today: LocalDate,
    selectedDate: LocalDate,
    selectedMonth: Int,
    selectedYear: Int,
    onSelectDateChange: (LocalDate) -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        tonalElevation = 3.dp,
    ) {
        Column {
            WeekRow(
                DateUtils.WEEK_DAYS,
                today.dayOfMonth.toString(),
                selectedDate.dayOfMonth.toString()
            )
            MonthGrid(
                today = today,
                selectedDate = selectedDate,
                selectedMonth = selectedMonth,
                selectedYear = selectedYear,
                onDateClick = { onSelectDateChange(selectedDate.withDayOfMonth(it.toInt())) }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CalendarPreview() {
    val selectedDate = LocalDate.now().plusDays(2)
    Calendar(
        today = LocalDate.now(),
        selectedDate = selectedDate,
        selectedMonth = selectedDate.monthValue,
        selectedYear = selectedDate.year,
        onSelectDateChange = {}
    )
}

@Composable
fun WeekRow(
    listItems: List<String>,
    today: String,
    selectedDay: String,
    onClick: (String) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        listItems.forEach {
            var modifier: Modifier = Modifier
            var fontWeight = FontWeight.Normal
            var color = MaterialTheme.colorScheme.onPrimaryContainer

            if (it == selectedDay) {
                modifier = Modifier.background(MaterialTheme.colorScheme.tertiary, CircleShape)
                color = MaterialTheme.colorScheme.onSecondary
            }
            if (it == today) {
                modifier = Modifier.background(MaterialTheme.colorScheme.secondary, CircleShape)
                fontWeight = FontWeight.Bold
                color = MaterialTheme.colorScheme.onPrimary
            }

            Text(
                text = it,
                textAlign = TextAlign.Center,
                color = color,
                fontWeight = fontWeight,
                modifier = modifier
                    .size(28.dp)
                    .clickable { onClick(it) }
                    .padding(4.dp),
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WeekRowPreview() {
    WeekRow(DateUtils.WEEK_DAYS, "", "")
}

@Composable
fun MonthGrid(
    today: LocalDate,
    selectedDate: LocalDate,
    selectedMonth: Int,
    selectedYear: Int,
    onDateClick: (String) -> Unit = {}
) {
    val weeksList = DateUtils.getDayListByDate(selectedMonth, selectedYear)

    Column {
        if (weeksList.isNotEmpty()) {
            for (week in weeksList) {
                WeekRow(
                    listItems = week,
                    today = today.dayOfMonth.toString(),
                    selectedDay = selectedDate.dayOfMonth.toString()
                ) { onDateClick(it) }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MonthGridPreview() {
    val selectedDate = LocalDate.now()
    MonthGrid(LocalDate.now(), selectedDate, selectedDate.monthValue, selectedDate.year)
}