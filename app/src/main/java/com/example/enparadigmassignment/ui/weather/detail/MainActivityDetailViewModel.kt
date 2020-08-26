package com.example.enparadigmassignment.ui.weather.detail

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import com.example.enparadigmassignment.data.model.DailyItem
import com.example.enparadigmassignment.di.scope.ActivityScope
import com.example.enparadigmassignment.ui.base.viewmodel.BaseActivityViewModel
import com.google.gson.Gson
import javax.inject.Inject

@ActivityScope
class MainActivityDetailViewModel @Inject constructor(): BaseActivityViewModel()  {
    val weatherData = MutableLiveData<DailyItem>()

    override fun handleIntent(intent: Intent) {
        super.handleIntent(intent)
        intent.extras?.apply {
            weatherData.value = Gson().fromJson(
                getString(MainActivityDetail.EXTRA_DAILY_ITEM),
                DailyItem::class.java
            )
        }
    }

}