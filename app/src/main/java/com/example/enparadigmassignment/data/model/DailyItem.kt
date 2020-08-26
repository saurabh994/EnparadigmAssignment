package com.example.enparadigmassignment.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

data class DailyItem(

    @field:SerializedName("rain")
    val rain: Double? = null,

    @field:SerializedName("sunrise")
    val sunrise: Int? = null,

    @field:SerializedName("temp")
    val temp: Temp? = null,

    @field:SerializedName("uvi")
    val uvi: Double? = null,

    @field:SerializedName("pressure")
    val pressure: Int? = null,

    @field:SerializedName("clouds")
    val clouds: Int? = null,

    @field:SerializedName("feels_like")
    val feelsLike: FeelsLike? = null,

    @field:SerializedName("dt")
    val dt: Long? = null,

    @field:SerializedName("pop")
    val pop: Double? = null,

    @field:SerializedName("wind_deg")
    val windDeg: Int? = null,

    @field:SerializedName("dew_point")
    val dewPoint: Double? = null,

    @field:SerializedName("sunset")
    val sunset: Int? = null,

    @field:SerializedName("weather")
    val weather: List<WeatherItem?>? = null,

    @field:SerializedName("humidity")
    val humidity: Int? = null,

    @field:SerializedName("wind_speed")
    val windSpeed: Double? = null
):Serializable{
    fun getDay() : String{
        val sdf = SimpleDateFormat("EEEE",Locale.getDefault())
        val dateFormat = dt?.times(1000)?.let { Date(it) }
        return sdf.format(dateFormat)
    }
}