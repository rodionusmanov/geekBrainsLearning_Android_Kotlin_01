package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.domain.getRusCities
import com.example.chotamnaulitce.domain.getWorldCities

class RepositoryLocalImpl : IRepositorySingle, IRepositoryMulti {

    override fun getWeatherList(location: Location): List<Weather> {
        return when (location) {
            Location.Rus -> {
                getRusCities()
            }
            Location.World -> {
                getWorldCities()
            }
        }
        return listOf(Weather())
    }

    override fun getWeather(latitude: Double, longtitude: Double): Weather {
        return Weather()
    }
}