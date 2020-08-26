package com.example.enparadigmassignment.ui.weather.detail

import androidx.appcompat.app.AppCompatActivity
import com.example.enparadigmassignment.di.key.ActivityViewModelKey
import com.example.enparadigmassignment.di.scope.ActivityScope
import com.example.enparadigmassignment.ui.base.activity.BaseActivityModule
import com.example.enparadigmassignment.ui.base.viewmodel.BaseActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [BaseActivityModule::class])
abstract class MainActivityDetailModule {
    @Binds
    @ActivityScope
    abstract fun bindActivity(activity: MainActivityDetail): AppCompatActivity

    @Binds
    @IntoMap
    @ActivityViewModelKey(MainActivityDetailViewModel::class)
    @ActivityScope
    abstract fun bindViewModel(viewModel: MainActivityDetailViewModel): BaseActivityViewModel
}