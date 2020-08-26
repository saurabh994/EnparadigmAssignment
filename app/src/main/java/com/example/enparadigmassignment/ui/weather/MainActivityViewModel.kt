package com.example.enparadigmassignment.ui.weather

import androidx.lifecycle.LiveData
import com.example.enparadigmassignment.common.extension.request
import com.example.enparadigmassignment.common.widget.ListLiveData
import com.example.enparadigmassignment.data.model.DailyItem
import com.example.enparadigmassignment.data.repository.MainRepository
import com.example.enparadigmassignment.data.response.Response
import com.example.enparadigmassignment.di.scope.ActivityScope
import com.example.enparadigmassignment.ui.base.viewmodel.BaseActivityViewModel
import timber.log.Timber
import javax.inject.Inject

@ActivityScope
class MainActivityViewModel @Inject constructor(private val mainRepository: MainRepository): BaseActivityViewModel() {
    val weatherData = ListLiveData<DailyItem>()

    override fun handleCreate() {
        super.handleCreate()
        loadWeatherApi()
    }

    private fun loadWeatherApi(){
        mainRepository.getWeather()
            .request({

            },{

            },{
                it.daily?.let { it1 -> weatherData.addAll(it1) }
            },{
                 Timber.e(it)
            })
    }
}