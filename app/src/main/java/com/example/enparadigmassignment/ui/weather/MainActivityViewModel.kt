package com.example.enparadigmassignment.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    val isLoading = MutableLiveData<Boolean>().apply { value = false }
    lateinit var weatherData: LiveData<List<DailyItem>>

    override fun handleCreate() {
        super.handleCreate()
        weatherData = mainRepository.getAllWeatherDataLocal()
        loadWeatherApi()
    }

    private fun loadWeatherApi(){
        mainRepository.getWeather()
            .request({
                isLoading.value = true
            },{
                isLoading.value = false
            },{
                mainRepository.clearWeatherFromLocal()
                it.let { it1 -> it1.daily?.let { it2 -> mainRepository.insert(it2) } }
            },{
                 Timber.e(it)
            })
    }
}