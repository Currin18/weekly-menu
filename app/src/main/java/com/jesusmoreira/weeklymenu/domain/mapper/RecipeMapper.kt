package com.jesusmoreira.weeklymenu.domain.mapper

import com.jesusmoreira.weeklymenu.core.util.ParseUtil
import com.jesusmoreira.weeklymenu.data.local.entity.Recipe as LocalRecipe
import com.jesusmoreira.weeklymenu.domain.model.Recipe as DomainRecipe

fun LocalRecipe.toDomainRecipe(): DomainRecipe = DomainRecipe(
    id = id,
    name = name,
    description = description,
    isFavorite = isFavorite,
    time = time,
    difficulty = ParseUtil.toObject(difficulty),
    services = ParseUtil.toSet(services),
    tags = ParseUtil.toSet(tags),
    ingredients = ParseUtil.toList(ingredients),
    directions = ParseUtil.toList(directions),
    nutrition = ParseUtil.toObject(nutrition),
)

fun DomainRecipe.toDBRecipe(): LocalRecipe = LocalRecipe(
    id = id,
    name = name,
    description = description,
    isFavorite = isFavorite,
    time = time,
    difficulty = ParseUtil.fromObject(difficulty),
    services = ParseUtil.fromSet(services),
    tags = ParseUtil.fromSet(tags),
    ingredients = ParseUtil.fromList(ingredients),
    directions = ParseUtil.fromList(directions),
    nutrition = ParseUtil.fromObject(nutrition),
)