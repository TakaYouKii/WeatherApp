package com.example.weatherapp.presenter

import android.os.Handler
import android.os.Looper
import com.example.weatherapp.view.SplashView

class SplashPresenter(private var splashView: SplashView) {

    fun showSplash(){
        Handler(Looper.myLooper()!!).postDelayed({
            splashView.showSplashScreen()
        }, 2000)

    }
}