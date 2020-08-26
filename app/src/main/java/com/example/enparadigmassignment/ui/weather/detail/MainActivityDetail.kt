package com.example.enparadigmassignment.ui.weather.detail

import com.example.enparadigmassignment.R
import com.example.enparadigmassignment.databinding.ActivityWeatherDetailBinding
import com.example.enparadigmassignment.ui.base.activity.BaseActivity

class MainActivityDetail : BaseActivity<ActivityWeatherDetailBinding, MainActivityDetailViewModel>() {
    override val layoutViewRes: Int
        get() = R.layout.activity_weather_detail

    override val viewModelClass: Class<MainActivityDetailViewModel>
        get() = MainActivityDetailViewModel::class.java

    companion object{
        const val EXTRA_DAILY_ITEM = "daily_item"
    }

}