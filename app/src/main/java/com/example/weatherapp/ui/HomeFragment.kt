package com.example.weatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.weatherapp.model.Coordinates
import com.example.weatherapp.model.MainModel
import com.example.weatherapp.presenter.Presenter
import com.example.weatherapp.model.Weather
import com.example.weatherapp.view.WeatherView
import com.example.weatherapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), WeatherView {

    lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var presenter: Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        presenter.getWeatherInfo()
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    override fun showWeatherInfo(
        coordinates: Coordinates,
        main: MainModel,
        weather: ArrayList<Weather>,
        name: String
    ) {
        with(binding){
            tvLat.text = "Lat: " + coordinates.lat.toString()
            tvLon.text = "Lon: " + coordinates.lon.toString()
            tvName.text = name
            tvMain.text = weather[0].main
            tvDescription.text = weather[0].description
            tvMaxTemp.text = main.max.toString()
            tvMinTemp.text = main.min.toString()
            tvHumidity.text = main.humidity.toString()
            tvPressure.text  = main.pressure.toString()
            tvTemperature.text= main.temp.toString()
        }
    }


}