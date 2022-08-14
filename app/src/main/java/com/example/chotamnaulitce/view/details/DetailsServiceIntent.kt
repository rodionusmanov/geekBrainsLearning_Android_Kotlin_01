package com.example.chotamnaulitce.view.details

import android.app.IntentService
import android.content.Intent
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.chotamnaulitce.BuildConfig
import com.example.chotamnaulitce.model.dataTransferObject.WeatherDataTransferObject
import com.example.chotamnaulitce.utils.*
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class DetailsServiceIntent : IntentService("") {

    override fun onHandleIntent(intent: Intent?) {
        intent?.let {
            val uri = URL(
                "https://api.weather.yandex.ru/v2/informers?" +
                        "lat=${intent.getDoubleExtra(BUNDLE_LAT_KEY, 0.0)}" +
                        "&lon=${intent.getDoubleExtra(BUNDLE_LON_KEY, 0.0)}"
            )
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
                    LocalBroadcastManager.getInstance(this).sendBroadcast(Intent().apply {
                        putExtra(BUNDLE_WEATHER_DTO_KEY, weatherDataTransferObject)
                        action = WAVE_KEY
                    })
                } catch (e: IOException) {
                    Log.d("exceptions", e.message.toString())
                } catch (e: JsonSyntaxException) {
                    Log.d("exceptions", e.message.toString())
                } finally {
                    weatherConnection.disconnect()
                }
            }.start()
        }
    }
}