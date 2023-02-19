package com.jesusmoreira.weeklymenu.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.jesusmoreira.weeklymenu.domain.model.Difficulty
import com.jesusmoreira.weeklymenu.domain.model.Service

@Entity(tableName = "recipe")
data class Recipe(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "description") val description: String = "",
    @ColumnInfo(name = "isFavorite") val isFavorite: Boolean = false,
    @ColumnInfo(name = "time") val time: Int = 0,
    @ColumnInfo(name = "difficulty") val difficulty: Difficulty = Difficulty.EASY,
    @ColumnInfo(name = "services") val services: Set<Service> = setOf(),
    @ColumnInfo(name = "tags") val tags: List<String> = listOf()
    // @ColumnInfo(name = "ingredients") val ingredients: List<String> = listOf(),
    // @ColumnInfo(name = "directions") val directions: List<String> = listOf(),
)