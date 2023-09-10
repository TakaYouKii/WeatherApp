package com.example.weatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentSplashBinding
import com.example.weatherapp.presenter.SplashPresenter
import com.example.weatherapp.view.SplashView


class SplashFragment : Fragment(), SplashView {

    lateinit var binding: FragmentSplashBinding

    lateinit var splashPresenter: SplashPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        splashPresenter = SplashPresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        splashPresenter.showSplash()
    }

    override fun showSplashScreen() {
        findNavController().navigate(R.id.homeFragment)
    }


}