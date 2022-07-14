package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.domain.getDefaultCity

class RepositoryDetailsOkhttpImpl:IRepositoryDetails {
    override fun getWeather(latitude: Double, longitude: Double): Weather {
        return Weather(getDefaultCity())
    }
}