package com.example.bikeforecast.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bikeforecast.domain.repository.WeatherRepository
import com.example.bikeforecast.domain.usecase.CalculateBikeRidingScoreUseCase
import com.example.bikeforecast.domain.usecase.GetWeatherForestUseCase
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(WeatherApi::class.java)
    }

    single {
        single<WeatherRepository>{
            WeatherRepositoryImpl(get())
        }
    }

    single {
        GetWeatherForestUseCase(get())
    }

    single { CalculateBikeRidingScoreUseCase() }

    viewModel{WeatherVIewModel(get(),get(),get())}
}