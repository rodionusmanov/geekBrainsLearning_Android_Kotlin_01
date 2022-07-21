package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.ChoTamNaUlitceApp
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.utils.convertWeatherEntityToWeather
import com.example.chotamnaulitce.utils.convertWeatherToWeatherEntity

class RepositoryLocationToWeatherRoomImpl : IRepositoryLocationToWeather, IRepositoryAddable {

    override fun getWeather(
        weather: Weather,
        callback: IUniversalCallback
    ) {
        Thread {
            callback.onResponse(
                ChoTamNaUlitceApp.getWeatherDatabase().weatherDAO()
                    .getWeatherByLocation(weather.city.latitude, weather.city.longitude).let {
                        convertWeatherEntityToWeather(it).last()
                    }
            )
        }.start()
    }

    override fun addWeather(weather: Weather) {
        Thread {
            ChoTamNaUlitceApp.getWeatherDatabase().weatherDAO()
                .insertRoom(convertWeatherToWeatherEntity(weather))
        }.start()
    }
}