package com.example.enparadigmassignment.ui.weather

import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.enparadigmassignment.R
import com.example.enparadigmassignment.data.model.DailyItem
import com.example.enparadigmassignment.databinding.ActivityMainBinding
import com.example.enparadigmassignment.ui.base.activity.BaseActivity
import com.example.enparadigmassignment.ui.weather.detail.MainActivityDetail
import com.google.gson.Gson
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
        recycler.addItemDecoration(
            DividerItemDecoration(this,  DividerItemDecoration.VERTICAL)
        )
        recycler.adapter = mainAdapter
    }

    override fun onViewModelCreated() {
        super.onViewModelCreated()
        viewModel.isLoading.observe(this, Observer {
            if (it)
                pbLoader.visibility = View.VISIBLE
            else
                pbLoader.visibility = View.GONE
        })
        viewModel.weatherData.observe(this, Observer {
            mainAdapter.submitList(it)
        })
    }

    override fun onClickItem(item: DailyItem) {
        val intent = Intent(this,MainActivityDetail::class.java)
        intent.putExtra(MainActivityDetail.EXTRA_DAILY_ITEM,Gson().toJson(item))
        startActivity(intent)
    }

}