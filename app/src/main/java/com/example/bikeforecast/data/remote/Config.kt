package com.example.bikeforecast.data.remote

import com.example.bikeforecast.BuildConfig



object Config {

    val OPENWEATHER_API_KEY = BuildConfig.API_KEY

    const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    const val WEATHER_ICON_BASE_URL = "https://openweathermap.org/img/wn/"
}
