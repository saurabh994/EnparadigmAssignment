package com.example.enparadigmassignment.data.response

import com.example.enparadigmassignment.data.model.Current
import com.example.enparadigmassignment.data.model.DailyItem
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Response(

	@field:SerializedName("current")
	val current: Current? = null,

	@field:SerializedName("timezone")
	val timezone: String? = null,

	@field:SerializedName("timezone_offset")
	val timezoneOffset: Int? = null,

	@field:SerializedName("daily")
	val daily: List<DailyItem>? = null,

	@field:SerializedName("lon")
	val lon: Double? = null,

	@field:SerializedName("lat")
	val lat: Double? = null
): Serializable