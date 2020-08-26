package com.example.enparadigmassignment.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FeelsLike(

    @field:SerializedName("eve")
    val eve: Double? = null,

    @field:SerializedName("night")
    val night: Double? = null,

    @field:SerializedName("day")
    val day: Double? = null,

    @field:SerializedName("morn")
    val morn: Double? = null
): Serializable
