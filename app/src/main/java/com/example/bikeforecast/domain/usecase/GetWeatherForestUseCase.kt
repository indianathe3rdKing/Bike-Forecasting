package com.example.bikeforecast.domain.usecase

import com.example.bikeforecast.domain.model.WeatherResponse
import com.example.bikeforecast.domain.repository.WeatherRepository

class GetWeatherForestUseCase(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(lat: Double,lon: Double): Result<WeatherResponse>{
        return repository.getWeatherForecast(lat,lon)
    }
}