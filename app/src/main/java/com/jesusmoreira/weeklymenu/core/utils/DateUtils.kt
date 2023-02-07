package com.jesusmoreira.weeklymenu.core.utils

import java.time.LocalDate

/**
 * Created by indigitall.
 */
object DateUtils {
    fun getDayListByDate(selectedDate: LocalDate): List<List<String>> {
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