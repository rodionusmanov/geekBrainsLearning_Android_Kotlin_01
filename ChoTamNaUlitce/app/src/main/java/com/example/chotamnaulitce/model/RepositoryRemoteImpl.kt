package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.domain.Weather

class RepositoryRemoteImpl: IRepositorySingle {

    override fun getWeatherList(location: Location):List<Weather> {
        Thread {
            Thread.sleep(200L)
        }.start()
        return listOf(Weather())
    }

    override fun getWeather(latitude: Double, longtitude: Double): Weather {
        Thread {
            Thread.sleep(200L)
        }.start()
        return Weather()
    }
}