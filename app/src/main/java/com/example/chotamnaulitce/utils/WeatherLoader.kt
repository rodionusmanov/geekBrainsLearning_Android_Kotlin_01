package com.example.chotamnaulitce.utils

import android.util.Log
import com.example.chotamnaulitce.BuildConfig
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import javax.net.ssl.HttpsURLConnection

object WeatherLoader {

    fun weatherRequest(weather: Weather, block: (weather: WeatherDataTransferObject) -> Unit) {
        try {
            val uri =
                URL("https://api.weather.yandex.ru/v2/informers?lat=${weather.city.latitude}&lon=${weather.city.longitude}")
            val weatherConnection: HttpsURLConnection?
            weatherConnection = uri.openConnection() as HttpsURLConnection
            Thread {
                try {
                    weatherConnection.readTimeout = 5000
                    weatherConnection.addRequestProperty(
                        WEATHER_KEY,
                        BuildConfig.WEATHER_API_KEY
                    )
                    val reader = BufferedReader(InputStreamReader(weatherConnection.inputStream))
                    val weatherDataTransferObject =
                        Gson().fromJson(getLines(reader), WeatherDataTransferObject::class.java)
                    block(weatherDataTransferObject)
                } catch (e: IOException) {
                    Log.d("exceptions", e.message.toString())
                } catch (e: JsonSyntaxException) {
                    Log.d("exceptions", e.message.toString())
                } finally {
                    weatherConnection.disconnect()
                }
            }.start()
        } catch (e: MalformedURLException) {
            Log.d("exceptions", e.message.toString())
        }
    }
}