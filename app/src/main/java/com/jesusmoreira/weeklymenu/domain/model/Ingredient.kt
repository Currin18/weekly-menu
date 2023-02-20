package com.jesusmoreira.weeklymenu.domain.model

data class Ingredient(
    var name: String = "",
    var amount: Number = 0,
    var unit: Unit = Unit.UNITS
)