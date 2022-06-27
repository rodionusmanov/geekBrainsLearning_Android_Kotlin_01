package com.example.chotamnaulitce.domain

data class Weather(
    val city: City = getDefaultCity(),
    val temperatureActual: Int = 0,
    val temperatureFeels: Int = 0
)

data class City(
    val name: String,
    val latitude: Double,
    val longtitude: Double
)

fun getDefaultCity() = City("Москва", 55.45, 37.36)