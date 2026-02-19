package com.example.bikeforecast.di

import org.koin.core.module.dsl.viewModel
import com.example.bikeforecast.data.remote.Config
import com.example.bikeforecast.data.remote.WeatherApiService
import com.example.bikeforecast.data.repository.WeatherRepositoryImpl
import com.example.bikeforecast.domain.repository.WeatherRepository
import com.example.bikeforecast.domain.usecase.CalculateBikeRidingScoreUseCase
import com.example.bikeforecast.domain.usecase.GetWeatherForestUseCase
import com.example.bikeforecast.presentation.viewModel.WeatherViewModel
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
        get<Retrofit>().create(WeatherApiService::class.java)
    }

    single<WeatherRepository>{
        WeatherRepositoryImpl(get())
    }

    single {
        GetWeatherForestUseCase(get())
    }

    single { CalculateBikeRidingScoreUseCase() }

    viewModel{ WeatherViewModel(get(),get(),get()) }
}
