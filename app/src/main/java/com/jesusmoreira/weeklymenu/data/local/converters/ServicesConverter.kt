package com.jesusmoreira.weeklymenu.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jesusmoreira.weeklymenu.domain.model.Service
import java.lang.reflect.Type


class ServicesConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromServices(value: Set<Service>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toServices(value: String): Set<Service> {
        val listType: Type = object : TypeToken<Set<Service>>() {}.type
        return gson.fromJson(value, listType)
    }
}