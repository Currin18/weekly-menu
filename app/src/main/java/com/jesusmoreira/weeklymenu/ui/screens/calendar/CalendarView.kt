package com.jesusmoreira.weeklymenu.ui.screens.calendar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jesusmoreira.weeklymenu.ui.components.calendar.Calendar
import java.time.LocalDate

@Composable
fun CalendarView(date: LocalDate) {
    Calendar(date = date)
}

@Composable
@Preview(showBackground = true)
fun CalendarViewPreview() {
    Calendar(date = LocalDate.now())
}
