package com.jesusmoreira.weeklymenu.domain.mapper

import com.jesusmoreira.weeklymenu.domain.model.Recipe as DomainRecipe
import com.jesusmoreira.weeklymenu.data.local.entity.Recipe as LocalRecipe

fun LocalRecipe.toDomainRecipe(): DomainRecipe = DomainRecipe(
    id,
    name,
    listOf(),
    description
)

fun DomainRecipe.toDBRecipe(): LocalRecipe = LocalRecipe(
    id,
    name,
    "", // ingredients.map { "name:${it.name},amount:${it.amount}},unit:${it.unit}" }.joinToString { "::" },
    description
)