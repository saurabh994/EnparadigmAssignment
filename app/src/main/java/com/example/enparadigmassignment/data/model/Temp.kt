package com.example.enparadigmassignment.data.model

import com.google.gson.annotations.SerializedName

data class Temp(

    @SerializedName("min")
    val min: Double? = null,

    @SerializedName("max")
    val max: Double? = null,

    @SerializedName("eve")
    val eve: Double? = null,

    @SerializedName("night")
    val night: Double? = null,

    @SerializedName("day")
    val day: Double? = null,

    @SerializedName("morn")
    val morn: Double? = null
)