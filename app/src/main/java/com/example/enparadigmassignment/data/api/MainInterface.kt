package com.example.enparadigmassignment.data.api

import com.example.enparadigmassignment.data.response.Response
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MainInterface {
    @GET("/data/2.5/onecall")
    fun getWeather(
        @Query("lat") lat: String = "11.8745",
        @Query("lon") lon: String = "75.3704",
        @Query("units") units: String = "metric",
        @Query("exclude") exclude: String = "hourly,minutely",
        @Query("appid") appid: String = "986217f7c4c4c3242e172374c69d5ef8"
    ): Single<Response>
}