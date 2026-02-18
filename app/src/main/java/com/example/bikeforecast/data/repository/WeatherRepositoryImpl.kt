package com.example.bikeforecast.data.repository

import com.example.bikeforecast.data.remote.Config
import com.example.bikeforecast.data.remote.WeatherApiService
import com.example.bikeforecast.domain.model.WeatherResponse
import com.example.bikeforecast.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val apiService: WeatherApiService
): WeatherRepository {
    override suspend fun getWeatherForecast(
        lat: Double,
        lon: Double
    ): Result<WeatherResponse> {
        return try {
            val response = apiService.getWeatherForecast(lat=lat,lon=lon, apiKey = Config.OPENWEATHER_API_KEY)
            Result.success(response)
        }catch (e: Exception){
            Result.failure(e)
        }
    }

}