package com.example.bikeforecast.domain.usecase

import com.example.bikeforecast.domain.repository.WeatherRepository

class GetWeatherForestUseCase(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(lat: Double,lon: Double): Result<WeatherRepository>{
        return repository.getWeatherForecast(lat,lon)
    }
}