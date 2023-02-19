package com.jesusmoreira.weeklymenu.domain.mapper

import com.jesusmoreira.weeklymenu.domain.model.Service
import com.jesusmoreira.weeklymenu.domain.model.Recipe as DomainRecipe
import com.jesusmoreira.weeklymenu.data.local.entity.Recipe as LocalRecipe

fun LocalRecipe.toDomainRecipe(): DomainRecipe = DomainRecipe(
    id = id,
    name = name,
    description = description,
    isFavorite = isFavorite,
    time = time,
    difficulty = difficulty,
    services = services,
    tags = tags,
    ingredients = listOf(),
    directions = listOf(),
)

fun DomainRecipe.toDBRecipe(): LocalRecipe = LocalRecipe(
    id = id,
    name = name,
    description = description,
    isFavorite = isFavorite,
    time = time,
    difficulty = difficulty,
    services = services,
    tags = tags,
    // ingredients = "", // ingredients.map { "name:${it.name},amount:${it.amount}},unit:${it.unit}" }.joinToString { "::" },
    // directions
)