package com.example.enparadigmassignment.ui.weather

import androidx.appcompat.app.AppCompatActivity
import com.example.enparadigmassignment.di.key.ActivityViewModelKey
import com.example.enparadigmassignment.di.scope.ActivityScope
import com.example.enparadigmassignment.ui.base.activity.BaseActivityModule
import com.example.enparadigmassignment.ui.base.viewmodel.BaseActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [BaseActivityModule::class])
abstract class MainActivityModule {
    @Binds
    @ActivityScope
    abstract fun bindActivity(activity: MainActivity): AppCompatActivity

    @Binds
    @IntoMap
    @ActivityViewModelKey(MainActivityViewModel::class)
    @ActivityScope
    abstract fun bindViewModel(viewModel: MainActivityViewModel): BaseActivityViewModel
}