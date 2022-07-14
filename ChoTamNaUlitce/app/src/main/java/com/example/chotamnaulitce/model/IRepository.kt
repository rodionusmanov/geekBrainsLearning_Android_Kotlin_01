package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.domain.Weather

interface IRepositoryDetails {
    fun getWeather(latitude: Double, longtitude: Double): Weather
}

interface IRepositorySingle {
    fun getWeatherList(location: Location): List<Weather>
    fun getWeather(latitude: Double, longtitude: Double): Weather
}

interface IRepositoryCitiesList {
    fun getCitiesList(location: Location): List<Weather>
}
sealed class Location{
    object Rus:Location()
    object World:Location()
}