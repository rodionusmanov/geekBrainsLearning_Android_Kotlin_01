package com.example.chotamnaulitce.utils

import android.widget.Toast
import com.example.chotamnaulitce.domain.City
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.domain.getDefaultCity
import com.example.chotamnaulitce.model.DataTransferObject.Fact
import com.example.chotamnaulitce.model.DataTransferObject.Info
import com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject
import com.example.chotamnaulitce.model.room.WeatherEntity
import java.io.BufferedReader
import java.util.stream.Collectors

fun getLines(reader: BufferedReader): String {
    return reader.lines().collect(Collectors.joining("\n"))
}

fun convertDTOToWeather(weatherDataTransferObject: WeatherDataTransferObject, city: City): Weather {
    val fact = weatherDataTransferObject.fact
    return (Weather(
        city,
        fact.temp,
        fact.feelsLike,
        fact.humidity,
        fact.condition,
        fact.windSpeed,
        fact.windDir
    ))
}

fun convertWeatherToDTO(weather: Weather): WeatherDataTransferObject {
    val fact = Fact(
        "неизвестно",
        weather.temperatureFeels,
        0,
        weather.temperatureActual,
        "неизвестно",
        0.0,
        ""
    )
    val info = Info(weather.city.latitude, weather.city.longitude, "")
    return WeatherDataTransferObject(fact, info)
}

fun convertWeatherEntityToWeatherDTO(entityList: List<WeatherEntity>): List<WeatherDataTransferObject> {
    return entityList.map {
        WeatherDataTransferObject(
            Fact(
                it.condition,
                it.temperatureFeels,
                it.humidity,
                it.temperatureActual,
                it.windDirection,
                it.windSpeed,
                "bkn_d"
            ),
            Info(it.latitude, it.longitude, it.name)
        )
    }
}

fun convertWeatherEntityToWeather(entityList: List<WeatherEntity>): List<Weather> {
    return entityList.map {
        Weather(
            City(it.name, it.latitude, it.longitude),
            it.temperatureActual,
            it.temperatureFeels,
            it.humidity,
            it.condition,
            it.windSpeed,
            it.windDirection
        )
    }
}

fun convertWeatherToWeatherEntity(weather: Weather): WeatherEntity {
    weather.city.name += " offline"
    return WeatherEntity(
        0,
        weather.city.name,
        weather.city.latitude,
        weather.city.longitude,
        weather.temperatureActual,
        weather.temperatureFeels,
        weather.humidity,
        weather.condition,
        weather.windSpeed,
        weather.windDirection)
}