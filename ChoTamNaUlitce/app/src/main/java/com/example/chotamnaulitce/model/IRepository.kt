package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.domain.Weather

interface IRepositorySingle {
    fun getWeatherList(location: Location): List<Weather>
    fun getWeather(latitude: Double, longtitude: Double): Weather
}

interface IRepositoryMulti {
    fun getWeatherList(location: Location): List<Weather>
    fun getWeather(latitude: Double, longtitude: Double): Weather
}
sealed class Location{
    object Rus:Location()
    object World:Location()
}