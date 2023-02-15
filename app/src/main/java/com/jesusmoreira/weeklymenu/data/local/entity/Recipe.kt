package com.jesusmoreira.weeklymenu.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
data class Recipe(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "ingredients") val ingredients: String = "[]",
    @ColumnInfo(name = "description") val description: String = ""
)