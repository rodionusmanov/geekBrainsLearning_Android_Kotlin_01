package com.example.chotamnaulitce.model.retrofit

import com.example.chotamnaulitce.BuildConfig
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject
import com.example.chotamnaulitce.model.IRepositoryLocationToWeather
import com.example.chotamnaulitce.model.IUniversalCallback
import com.example.chotamnaulitce.utils.convertDTOToWeather
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class RepositoryLocationToWeatherRetrofitImpl : IRepositoryLocationToWeather {

    private val retrofitImpl = Retrofit.Builder()

    override fun getWeather(weather: Weather, callback: IUniversalCallback) {
        retrofitImpl.baseUrl("https://api.weather.yandex.ru")
        retrofitImpl.addConverterFactory(
            GsonConverterFactory.create(GsonBuilder().setLenient().create())
        )
        val api = retrofitImpl.build().create(WeatherAPI::class.java)
        api.getWeather(BuildConfig.WEATHER_API_KEY, weather.city.latitude, weather.city.longitude)
            .enqueue(object : Callback<WeatherDataTransferObject> {

                override fun onResponse(
                    call: Call<WeatherDataTransferObject>,
                    response: Response<WeatherDataTransferObject>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        callback.onResponse(convertDTOToWeather(response.body()!!, weather.city))
                    } else {
                        callback.onFailure(IOException("4xx"))
                    }
                }

                override fun onFailure(call: Call<WeatherDataTransferObject>, t: Throwable) {
                    callback.onFailure(IOException(t))
                }
            })
    }
}