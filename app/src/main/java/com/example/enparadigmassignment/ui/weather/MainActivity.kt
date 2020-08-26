package com.example.enparadigmassignment.ui.weather

import androidx.lifecycle.Observer
import com.example.enparadigmassignment.R
import com.example.enparadigmassignment.data.model.DailyItem
import com.example.enparadigmassignment.databinding.ActivityMainBinding
import com.example.enparadigmassignment.ui.base.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(),MainNavigator {
    override val layoutViewRes: Int
        get() = R.layout.activity_main

    override val viewModelClass: Class<MainActivityViewModel>
        get() = MainActivityViewModel::class.java

    private val mainAdapter by lazy {
        MainActivityAdapter(this)
    }

    override fun onViewCreated() {
        super.onViewCreated()
        recycler.adapter = mainAdapter
    }

    override fun onViewModelCreated() {
        super.onViewModelCreated()
        viewModel.weatherData.observe(this, Observer {
            mainAdapter.submitList(it)
        })
    }

    override fun onClickItem(item: DailyItem) {

    }

}