package com.example.chotamnaulitce.utils

import com.example.chotamnaulitce.BuildConfig
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

object WeatherLoader {

    fun weatherRequest(weather: Weather, block: (weather: WeatherDataTransferObject) -> Unit) {
        val uri =
            URL("https://api.weather.yandex.ru/v2/informers?lat=${weather.city.latitude}&lon=${weather.city.longitude}")
        val weatherConnection: HttpsURLConnection?

        weatherConnection = uri.openConnection() as HttpsURLConnection
        weatherConnection.readTimeout = 5000
        weatherConnection.addRequestProperty("X-Yandex-API-Key", BuildConfig.WEATHER_API_KEY)
        Thread {
            val reader = BufferedReader(InputStreamReader(weatherConnection.inputStream))
            val weatherDataTransferObject =
                Gson().fromJson(getLines(reader), WeatherDataTransferObject::class.java)
            block(weatherDataTransferObject)
        }.start()
    }
}