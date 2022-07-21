package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.ChoTamNaUlitceApp
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.utils.convertWeatherEntityToWeather
import com.example.chotamnaulitce.utils.convertWeatherToWeatherEntity

class RepositoryLocationToWeatherRoomImpl : IRepositoryLocationToWeather, IRepositoryAddable {

    override fun getWeather(
        latitude: Double,
        longitude: Double,
        callback: IUniversalCallback
    ) {
        callback.onResponse(
            ChoTamNaUlitceApp.getWeatherDatabase().weatherDAO()
                .getWeatherByLocation(latitude, longitude).let {
                    convertWeatherEntityToWeather(it).last()
                }
        )
    }

    override fun addWeather(weather: Weather) {
        ChoTamNaUlitceApp.getWeatherDatabase().weatherDAO().insertRoom(convertWeatherToWeatherEntity(weather))
    }

}