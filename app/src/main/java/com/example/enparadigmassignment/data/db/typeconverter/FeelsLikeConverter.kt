package com.example.enparadigmassignment.data.db.typeconverter

import androidx.room.TypeConverter
import com.example.enparadigmassignment.data.model.FeelsLike
import com.example.enparadigmassignment.data.model.Temp
import com.example.enparadigmassignment.data.model.WeatherItem
import com.google.gson.Gson

class FeelsLikeConverter {
    @TypeConverter
    fun jsonToFeelsLike(source: String?): FeelsLike? {
        return Gson().fromJson(source, FeelsLike::class.java)
    }

    @TypeConverter
    fun feelsLikeToJson(source: FeelsLike?): String {
        return Gson().toJson(source)
    }
}