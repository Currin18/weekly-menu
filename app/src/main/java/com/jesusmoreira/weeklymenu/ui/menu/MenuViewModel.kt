package com.jesusmoreira.weeklymenu.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate

class MenuViewModel: ViewModel() {
    val today: LocalDate = LocalDate.now()

    private val _selectedDate = MutableLiveData<LocalDate>()
    val selectedDate: LiveData<LocalDate> = _selectedDate

    fun onSelectedDateChange(newSelectedDate: LocalDate) {
        _selectedDate.value = newSelectedDate
    }
}