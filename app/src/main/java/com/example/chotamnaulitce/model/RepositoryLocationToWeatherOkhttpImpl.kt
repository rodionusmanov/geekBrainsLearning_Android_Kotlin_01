package com.example.chotamnaulitce.model

import android.util.Log
import com.example.chotamnaulitce.BuildConfig
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.model.dataTransferObject.WeatherDataTransferObject
import com.example.chotamnaulitce.utils.WEATHER_KEY
import com.example.chotamnaulitce.utils.convertDTOToWeather
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class RepositoryLocationToWeatherOkhttpImpl : IRepositoryLocationToWeather {
    override fun getWeather(
        weather: Weather,
        callback: IUniversalCallback
    ){
        val client = OkHttpClient()
        val builder = Request.Builder()
        builder.addHeader(WEATHER_KEY, BuildConfig.WEATHER_API_KEY)
        builder.url(
            "https://api.weather.yandex.ru/v2/informers?" +
                    "lat=${weather.city.latitude}" +
                    "&lon=${weather.city.longitude}"
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
                        callback.onResponse(convertDTOToWeather(weatherDataTransferObject, weather.city))
                    }
                } else {
                    callback.onFailure(IOException("4xx"))
                }
            }
        })
    }
}