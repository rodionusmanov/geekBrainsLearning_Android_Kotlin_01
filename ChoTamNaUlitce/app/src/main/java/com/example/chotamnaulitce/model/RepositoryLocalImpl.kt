package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.domain.Weather

class RepositoryLocalImpl: IRepository {

    override fun getWeatherList():List<Weather> {
        return listOf(Weather())
    }

    override fun getWeather(latitude: Double, longtitude: Double): Weather {
        return Weather()
    }
}