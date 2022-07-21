package com.example.chotamnaulitce.model

import android.util.Log
import com.example.chotamnaulitce.BuildConfig
import com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject
import com.example.chotamnaulitce.utils.WEATHER_KEY
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class RepositoryLocationToWeatherOkhttpImpl : IRepositoryLocationToWeather {
    override fun getWeather(
        latitude: Double,
        longitude: Double,
        callback: IUniversalCallback
    ){
        val client = OkHttpClient()
        val builder = Request.Builder()
        builder.addHeader(WEATHER_KEY, BuildConfig.WEATHER_API_KEY)
        builder.url(
            "https://api.weather.yandex.ru/v2/informers?" +
                    "lat=${latitude}" +
                    "&lon=${longitude}"
        )
        val request: Request = builder.build()
        val call: Call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("okhttpException", "потрачено")
                callback.onFailure(e)
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.code in 200..299 && response.body != null) {
                    response.body?.let {
                        val responseString = it.string()
                        val weatherDataTransferObject =
                            Gson().fromJson((responseString), WeatherDataTransferObject::class.java)
                        callback.onResponse(weatherDataTransferObject)
                    }
                } else {
                    callback.onFailure(IOException("4xx"))
                }
            }
        })
    }
}