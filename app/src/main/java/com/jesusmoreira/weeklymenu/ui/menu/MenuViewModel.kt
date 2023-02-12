package com.jesusmoreira.weeklymenu.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate

class MenuViewModel: ViewModel() {
    val today: LocalDate = LocalDate.now()

    private val _selectedDate = MutableLiveData<LocalDate>()
    val selectedDate: LiveData<LocalDate> = _selectedDate

    private val _selectedMonth = MutableLiveData<Int>()
    val selectedMonth: LiveData<Int> = _selectedMonth

    private val _selectedYear = MutableLiveData<Int>()
    val selectedYear: LiveData<Int> = _selectedYear

    fun onSelectedDateChange(newSelectedDate: LocalDate) {
        _selectedDate.value = newSelectedDate
        _selectedMonth.value = newSelectedDate.monthValue
        _selectedYear.value = newSelectedDate.year
    }
}