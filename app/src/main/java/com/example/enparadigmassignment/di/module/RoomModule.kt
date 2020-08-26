package com.example.enparadigmassignment.di.module

import android.app.Application
import com.example.enparadigmassignment.data.db.AppDatabase
import com.example.enparadigmassignment.data.db.dao.WeatherDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Provides
    @Singleton
    fun providesAppDatabase(application: Application): AppDatabase =
        AppDatabase.getInstance(application)

    @Singleton
    @Provides
    fun providesPostDao(appDatabase: AppDatabase): WeatherDao = appDatabase.weatherDao()
}