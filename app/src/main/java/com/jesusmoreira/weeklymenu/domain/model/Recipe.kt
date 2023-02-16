package com.jesusmoreira.weeklymenu.domain.model

import java.io.Serializable


data class Recipe(
    val id: Int? = null,
    var name: String = "",
    var categories: Set<Service> = setOf(),
    var time: Int = 0,
    var ingredients: List<Ingredient> = emptyList(),
    var description: String = "",
    var isFavorite: Boolean = false
) : Serializable