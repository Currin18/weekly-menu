package com.jesusmoreira.weeklymenu.core.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object ParseUtil {
    private val gson = Gson()

    fun <T> fromObject(value: T): String {
        return gson.toJson(value)
    }

    inline fun <reified T> toObject(value: String): T =
        Gson().fromJson(value, T::class.java)

    fun <T> fromList(value: List<T>): String = gson.toJson(value)

    inline fun <reified T> toList(value: String): List<T> =
        Gson().fromJson(value, object : TypeToken<List<T>>() {}.type)

    fun <T> fromSet(value: Set<T>): String = gson.toJson(value)

    inline fun <reified T> toSet(value: String): Set<T> =
        Gson().fromJson(value, object : TypeToken<Set<T>>() {}.type)
}