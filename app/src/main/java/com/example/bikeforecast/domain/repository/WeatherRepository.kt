package com.example.bikeforecast.domain.repository

import com.example.bikeforecast.domain.model.WeatherResponse

interface WeatherRepository {
    suspend fun getWeatherForecast(lat:Double,lon:Double): Result<WeatherResponse>
}