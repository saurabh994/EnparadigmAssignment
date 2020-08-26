package com.example.enparadigmassignment.data.db.typeconverter

import androidx.room.TypeConverter
import com.example.enparadigmassignment.data.model.Temp
import com.example.enparadigmassignment.data.model.WeatherItem
import com.google.gson.Gson

class TempConverter {
    @TypeConverter
    fun jsonToTemp(source: String?): Temp? {
        return Gson().fromJson(source, Temp::class.java)
    }

    @TypeConverter
    fun tempToJson(source: Temp?): String {
        return Gson().toJson(source)
    }
}