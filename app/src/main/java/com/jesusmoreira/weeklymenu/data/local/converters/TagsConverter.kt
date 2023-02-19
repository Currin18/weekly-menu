package com.jesusmoreira.weeklymenu.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class TagsConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromTags(value: List<String>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toTags(value: String): List<String> {
        val listType: Type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, listType)
    }

}