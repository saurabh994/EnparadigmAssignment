package com.example.enparadigmassignment.di.module

import android.util.Log
import com.example.enparadigmassignment.BuildConfig
import dagger.Module
import dagger.Provides
import timber.log.Timber
import javax.inject.Singleton

@Module
class TimberModule {
    @Provides
    @Singleton
    fun provideTimberTree(): Timber.Tree = object : Timber.DebugTree() {
        override fun isLoggable(tag: String?, priority: Int) = BuildConfig.DEBUG || priority >= Log.INFO
    }
}