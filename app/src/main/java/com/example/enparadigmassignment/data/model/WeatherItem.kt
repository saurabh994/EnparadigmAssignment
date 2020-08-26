package com.example.enparadigmassignment.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherItem(

    @field:SerializedName("icon")
    val icon: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("main")
    val main: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
): Serializable
