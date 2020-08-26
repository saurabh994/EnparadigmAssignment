package com.example.enparadigmassignment.data.db.typeconverter

import androidx.room.TypeConverter
import com.example.enparadigmassignment.data.model.WeatherItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class WeatherConverter {
    @TypeConverter
    fun stringToList(string: String): List<WeatherItem> {
        val listType = object : TypeToken<List<WeatherItem>>() {}.type
        return Gson().fromJson(string, listType)
    }

    @TypeConverter
    fun listToString(list: List<WeatherItem>): String {
        return Gson().toJson(list)
    }
}