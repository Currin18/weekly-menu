package com.jesusmoreira.weeklymenu.ui.menu.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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

val MONTH_DAYS = listOf("L", "M", "X", "J", "V", "S", "D")

@Composable
fun Calendar(today: LocalDate, selectedDate: LocalDate, onSelectDateChange: (LocalDate) -> Unit) {
    Column {
        WeekRow(MONTH_DAYS, today.dayOfMonth.toString(), selectedDate.dayOfMonth.toString())
        MonthGrid(
            today = today,
            selectedDate = selectedDate,
            onDateClick = { onSelectDateChange(selectedDate.withMonth(it.toInt())) }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CalendarPreview() {
    Calendar(
        today = LocalDate.now(),
        selectedDate = LocalDate.now().plusDays(2),
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
            var color = Color.Unspecified

            if (it == selectedDay) {
                modifier = Modifier.background(Color.LightGray, CircleShape)
            }
            if (it == today) {
                modifier = Modifier.background(Color.Gray, CircleShape)
                fontWeight = FontWeight.Bold
                color = Color.White
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
    WeekRow(MONTH_DAYS, "", "")
}

@Composable
fun MonthGrid(today: LocalDate, selectedDate: LocalDate, onDateClick: (String) -> Unit = {}) {

    val weeksList = DateUtils.getDayListByDate(selectedDate)

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
    MonthGrid(LocalDate.now(), LocalDate.now())
}