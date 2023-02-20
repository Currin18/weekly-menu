package com.jesusmoreira.weeklymenu.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
data class Recipe(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "description") val description: String = "",
    @ColumnInfo(name = "isFavorite") val isFavorite: Boolean = false,
    @ColumnInfo(name = "time") val time: Int = 0,
    @ColumnInfo(name = "difficulty") val difficulty: String = "EASY",
    @ColumnInfo(name = "services") val services: String = "[]",
    @ColumnInfo(name = "tags") val tags: String = "[]",
    @ColumnInfo(name = "ingredients") val ingredients: String = "[]",
    @ColumnInfo(name = "directions") val directions: String = "[]",
    @ColumnInfo(name = "nutrition") val nutrition: String = "{}",
)