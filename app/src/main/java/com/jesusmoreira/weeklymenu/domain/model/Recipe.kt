package com.jesusmoreira.weeklymenu.domain.model

import android.os.Parcelable


data class Recipe(
    val id: Int? = null,
    var name: String = "",
    var ingredients: List<Ingredient> = emptyList(),
    var description: String = ""
) : java.io.Serializable
