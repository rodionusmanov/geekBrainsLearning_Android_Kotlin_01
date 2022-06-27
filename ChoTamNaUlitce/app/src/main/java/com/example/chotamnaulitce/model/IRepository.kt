package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.domain.Weather

interface IRepository {
    fun getWeatherList():List<Weather>
    fun getWeather(latitude: Double, longtitude: Double):Weather
}