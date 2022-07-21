package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.domain.getDefaultCity
import com.example.chotamnaulitce.domain.getRusCities
import com.example.chotamnaulitce.domain.getWorldCities
import com.example.chotamnaulitce.model.DataTransferObject.Fact
import com.example.chotamnaulitce.model.DataTransferObject.Info
import com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject

class RepositoryLocationToWeatherLocalImpl : IRepositoryLocationToWeather {
    override fun getWeather(
        latitude: Double,
        longitude: Double,
        callback: IUniversalCallback
    ) {
        val list = getRusCities().toMutableList()
        list.addAll(getWorldCities())
        val response =
            list.filter { it.city.latitude == latitude && it.city.longitude == longitude }
        callback.onResponse(response.first())
    }

}