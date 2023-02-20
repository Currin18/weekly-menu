package com.jesusmoreira.weeklymenu.core.util

import java.time.LocalDate

object DateUtil {
    val WEEK_DAYS = listOf("L", "M", "X", "J", "V", "S", "D")

    fun getDayListByDate(selectedMonth: Int, selectedYear: Int): List<List<String>> {
        val selectedDate = LocalDate.of(selectedYear, selectedMonth, 1)
        val weeksList = mutableListOf<MutableList<String>>()

        val dayOfWeek = selectedDate.dayOfWeek.value - 1
        val lengthOfMonth = selectedDate.lengthOfMonth() - 1

        for (i in 0.. lengthOfMonth + dayOfWeek) {
            if (i % 7 == 0) weeksList.add(mutableListOf("", "", "", "", "", "", ""))
            if (i >= dayOfWeek) weeksList.last()[i % 7] = "${i - dayOfWeek + 1}"
        }

        return weeksList
    }
}