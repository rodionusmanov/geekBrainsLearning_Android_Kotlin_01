package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.domain.getRusCities
import com.example.chotamnaulitce.domain.getWorldCities

class RepositoryLocationToWeatherLocalImpl : IRepositoryLocationToWeather {
    override fun getWeather(
        weather: Weather,
        callback: IUniversalCallback
    ) {
        val list = getRusCities().toMutableList()
        list.addAll(getWorldCities())
        val response =
            list.filter { it.city.latitude == weather.city.latitude && it.city.longitude == weather.city.longitude }
        callback.onResponse(response.first())
    }

}