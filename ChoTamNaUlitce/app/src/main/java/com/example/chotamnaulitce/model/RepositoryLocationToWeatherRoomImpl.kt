package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.ChoTamNaUlitceApp
import com.example.chotamnaulitce.model.DataTransferObject.Fact
import com.example.chotamnaulitce.model.DataTransferObject.Info
import com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject
import com.example.chotamnaulitce.model.room.WeatherEntity

class RepositoryLocationToWeatherRoomImpl : IRepositoryLocationToWeather, IRepositoryAddable {

    override fun getWeather(
        latitude: Double,
        longitude: Double,
        callback: IUniversalCallback
    ) {
        callback.onResponse(
            ChoTamNaUlitceApp.getWeatherDatabase().weatherDAO()
                .getWeatherByLocation(latitude, longitude).let {
                    convertWeatherEntityToWeatherDTO(it).last()
                }
        )
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

    override fun addWeather(weatherDataTransferObject: WeatherDataTransferObject) {

    }

}