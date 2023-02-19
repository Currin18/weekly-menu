package com.jesusmoreira.weeklymenu.domain.model

data class Ingredient(
    var name: String = "",
    var amount: Float = 0f,
    var unit: Unit = Unit.UNITS
)