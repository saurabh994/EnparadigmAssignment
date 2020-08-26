package com.example.enparadigmassignment.data.repository

import com.example.enparadigmassignment.data.api.MainInterface
import com.example.enparadigmassignment.data.response.Response
import io.reactivex.Single
import javax.inject.Inject

class MainRepository @Inject constructor(private val mainInterface: MainInterface){
    fun getWeather():Single<Response>{
        return mainInterface.getWeather()
    }
}