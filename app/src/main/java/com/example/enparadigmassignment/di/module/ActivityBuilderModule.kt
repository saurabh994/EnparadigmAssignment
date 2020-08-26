package com.example.enparadigmassignment.di.module

import com.example.enparadigmassignment.di.scope.ActivityScope
import com.example.enparadigmassignment.ui.weather.MainActivity
import com.example.enparadigmassignment.ui.weather.MainActivityModule
import com.example.enparadigmassignment.ui.weather.detail.MainActivityDetail
import com.example.enparadigmassignment.ui.weather.detail.MainActivityDetailModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    @ActivityScope
    abstract fun contributeUploadActivity(): MainActivity

    @ContributesAndroidInjector(modules = [MainActivityDetailModule::class])
    @ActivityScope
    abstract fun contributeMainActivityDetail(): MainActivityDetail
}