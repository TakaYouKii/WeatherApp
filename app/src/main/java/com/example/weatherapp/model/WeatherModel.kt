package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class WeatherModel(
    var coord: Coordinates,
    var main: MainModel,
    var weather: ArrayList<Weather>,
    var name: String
): Serializable

data class Coordinates(
    var lon: Double,
    var lat: Double,
): Serializable


data class Weather (
    val main: String,
    val description: String,
): Serializable

data class MainModel(
    var temp: Double,
    @SerializedName("temp_min")
    var min: Double,
    @SerializedName("temp_max")
    var max: Double,
    var humidity: Int,
    var pressure: Int
): Serializable

