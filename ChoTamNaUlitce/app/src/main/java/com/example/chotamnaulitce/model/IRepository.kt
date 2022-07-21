package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject
import java.io.IOException

interface IRepositoryLocationToWeather {
    fun getWeather(latitude: Double, longtitude: Double, callback: IUniversalCallback)
}

interface IRepositoryAddable {
    fun addWeather(weatherDataTransferObject: WeatherDataTransferObject)
}

interface IUniversalCallback {
    fun onResponse(weatherDataTransferObject: WeatherDataTransferObject)
    fun onFailure(e: IOException)
}

interface IRepositorySingle {
    fun getWeatherList(location: Location): List<Weather>
    fun getWeather(latitude: Double, longtitude: Double): Weather
}

interface IRepositoryCitiesList {
    fun getCitiesList(location: Location): List<Weather>
}

sealed class Location {
    object Rus : Location()
    object World : Location()
}