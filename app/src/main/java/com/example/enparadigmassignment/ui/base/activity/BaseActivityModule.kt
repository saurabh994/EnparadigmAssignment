package com.example.enparadigmassignment.ui.base.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.enparadigmassignment.di.qualifier.ActivityContext
import com.example.enparadigmassignment.di.scope.ActivityScope
import com.example.enparadigmassignment.ui.base.viewmodel.factory.ActivityViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class BaseActivityModule {
    @Binds
    @ActivityScope
    @ActivityContext
    abstract fun bindActivityContext(activity: AppCompatActivity): Context

    @Binds
    @ActivityScope
    abstract fun bindViewModelFactory(
        viewModelFactory: ActivityViewModelFactory
    ): ViewModelProvider.Factory

    @Module
    companion object {
        @Provides
        @ActivityScope
        @ActivityContext
        @JvmStatic
        fun provideViewModelProvider(
            activity: AppCompatActivity,
            viewModelFactory: ViewModelProvider.Factory
        ): ViewModelProvider = ViewModelProvider(activity, viewModelFactory)
    }
}