package com.jesusmoreira.weeklymenu.domain.model

import java.time.LocalDate

data class Menu(
    val date: LocalDate,
    var recipes: Map<Service, List<Recipe>>
)
