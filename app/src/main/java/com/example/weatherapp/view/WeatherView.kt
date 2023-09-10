package com.example.weatherapp.view

import com.example.weatherapp.model.Coordinates
import com.example.weatherapp.model.MainModel
import com.example.weatherapp.model.Weather

interface WeatherView {

    fun showError(error: String)

    fun showWeatherInfo(
        coordinates: Coordinates,
        main: MainModel,
        weather: ArrayList<Weather>,
        name: String,
    )
}