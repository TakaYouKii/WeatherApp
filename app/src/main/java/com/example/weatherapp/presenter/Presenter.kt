package com.example.weatherapp.presenter

import android.util.Log
import com.example.weatherapp.model.WeatherApi
import com.example.weatherapp.model.WeatherModel
import com.example.weatherapp.view.WeatherView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Presenter @Inject constructor(private val weatherApi: WeatherApi) {

    lateinit var weatherView: WeatherView

    fun getWeatherInfo(){

        weatherApi.getWeather().enqueue(object : Callback<WeatherModel>{
            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                Log.e("ololo", "onResponse: ${response.body()}")
                response.body()?.let {
                    weatherView.showWeatherInfo(it.coord, it.main, it.weather, it.name)
                }

            }

            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                weatherView.showError(t.message.toString())
            }
        })
    }

    fun attachView(weatherView: WeatherView){
        this.weatherView = weatherView
    }
}


