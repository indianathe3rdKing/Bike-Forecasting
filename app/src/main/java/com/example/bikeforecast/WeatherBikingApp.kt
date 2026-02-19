package com.example.bikeforecast

import android.app.Application
import com.example.bikeforecast.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class WeatherBikingApp: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WeatherBikingApp)
            modules(appModule)
        }
    }
}