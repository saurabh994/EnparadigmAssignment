package com.example.enparadigmassignment.di.module

import android.app.Application
import android.content.Context
import com.example.enparadigmassignment.ApplicationClass
import com.example.enparadigmassignment.di.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(
    includes = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class, TimberModule::class, RxJavaModule::class,
        NetworkModule::class, ApiModule::class, RoomModule::class]
)
abstract class ApplicationModule {
    @Binds
    @Singleton
    abstract fun bindApplication(application: ApplicationClass): Application

    @Binds
    @Singleton
    @ApplicationContext
    abstract fun bindApplicationContext(application: Application): Context
}
