package com.jesusmoreira.weeklymenu.domain.model

import java.io.Serializable


data class Recipe(
    val id: Int? = null,
    var name: String = "",
    var description: String = "",
    var isFavorite: Boolean = false,
    var time: Int = 0,
    var difficulty: Difficulty = Difficulty.EASY,
    var services: Set<Service> = setOf(Service.LUNCH, Service.DINNER),
    var tags: List<String> = listOf("tag1", "tag2"),
    var ingredients: List<Ingredient> = emptyList(),
    var directions: List<String> = emptyList(),
    var nutrition: Nutrition = Nutrition()
) : Serializable