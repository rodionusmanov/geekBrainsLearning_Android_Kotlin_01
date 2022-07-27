package com.example.chotamnaulitce.utils

import com.example.chotamnaulitce.domain.City
import com.example.chotamnaulitce.domain.Weather
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
    if (!isConnected) {
        weather.city.name += " offline"
    }
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
        weather.windDirection
    )
}

fun conditionToRus(string: String): String {
    when (string) {
        "clear" -> return "ясно"
        "partly-cloudy" -> return "малооблачно"
        "cloudy" -> return "малооблачно с прояснениями"
        "overcast" -> return "пасмурно"
        "drizzle" -> return "морось"
        "light-rain" -> return "небольшой дождь"
        "rain" -> return "дождь"
        "moderate-rain" -> return "умеренно сильный дождь"
        "heavy-rain" -> return "сильный дождь"
        "continuous-heavy-rain" -> return " длительный сильный дождь"
        "showers" -> return "ливень"
        "wet-snow" -> return "дождь со снегом"
        "light-snow" -> return "небольшой снег"
        "snow" -> return "снег"
        "snow-showers" -> return "снегопад"
        "hail" -> return " небольшой снег"
        "thunderstorm" -> return "гроза"
        "thunderstorm-with-rain" -> return "дождь с грозой"
        "thunderstorm-with-hail" -> return "гроза с градом"
        else -> return "неизвестно"
    }
}

fun windDirectionToRus(string: String): String {
    return when (string) {
        "n" -> "север"
        "ne" -> "северо-восток"
        "e" -> "восток"
        "se" -> "юго-восток"
        "s" -> "юг"
        "sw" -> "юго-запад"
        "w" -> "запад"
        "nw" -> "северо-запад"
        "c" -> "штиль"
        else -> "неизвестно"
    }
}