package com.example.weatherapp.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("lat") lat: Double = 42.882004,
        @Query("lon") lon: Double = 74.582748,
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = "36cbf21e77603d1848c9293fd5e5ba31",
    ): Call<WeatherModel>
}

