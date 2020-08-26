package com.example.enparadigmassignment.data.repository

import androidx.lifecycle.LiveData
import com.example.enparadigmassignment.data.api.MainInterface
import com.example.enparadigmassignment.data.db.dao.WeatherDao
import com.example.enparadigmassignment.data.model.DailyItem
import com.example.enparadigmassignment.data.response.Response
import io.reactivex.Single
import javax.inject.Inject

class MainRepository @Inject constructor(private val mainInterface: MainInterface,private val weatherDao: WeatherDao){
    fun getWeather():Single<Response>{
        return mainInterface.getWeather()
    }

    fun getAllWeatherDataLocal(): LiveData<List<DailyItem>> =
        weatherDao.getAllItems()

    fun insert(items:List<DailyItem>){
        weatherDao.insert(items)
    }

    fun clearWeatherFromLocal() = weatherDao.clear()
}