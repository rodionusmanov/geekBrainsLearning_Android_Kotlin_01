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
        callback.onResponse(convertModelToDTO(response.first()))
    }

    fun convertDTOToModel(weatherDataTransferObject: WeatherDataTransferObject): Weather {
        val fact = weatherDataTransferObject.fact
        return (Weather(
            getDefaultCity(),
            fact.temp,
            fact.feelsLike,
            fact.humidity,
            fact.condition,
            fact.windSpeed,
            fact.windDir
        ))
    }

    private fun convertModelToDTO(weather: Weather): WeatherDataTransferObject {
        val fact = Fact("неизвестно", weather.temperatureFeels, 0,weather.temperatureActual, "неизвестно", 0.0, "")
        val info = Info(weather.city.latitude, weather.city.longitude, "")
        return WeatherDataTransferObject(fact, info)
    }
}