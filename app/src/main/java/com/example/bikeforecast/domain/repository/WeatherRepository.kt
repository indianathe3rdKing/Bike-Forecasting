package com.example.bikeforecast.domain.repository

interface WeatherRepository {
    suspend fun getWeatherForecast(lat:Double,Ion:Double): Result<WeatherRepository>
}