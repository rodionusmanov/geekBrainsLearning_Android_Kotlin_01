package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.domain.Weather
import java.io.IOException

interface IRepositoryLocationToWeather {
    fun getWeather(weather: Weather, callback: IUniversalCallback)
}

interface IRepositoryAddable {
    fun addWeather(weather: Weather)
}

interface IUniversalCallback {
    fun onResponse(weather: Weather)
    fun onFailure(e: IOException)
}

interface IRepositoryCitiesList {
    fun getCitiesList(location: Location): List<Weather>
}

sealed class Location {
    object Rus : Location()
    object World : Location()
}