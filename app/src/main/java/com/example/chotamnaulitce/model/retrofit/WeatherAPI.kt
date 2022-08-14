package com.example.chotamnaulitce.model.retrofit

import com.example.chotamnaulitce.model.dataTransferObject.WeatherDataTransferObject
import com.example.chotamnaulitce.utils.WEATHER_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WeatherAPI {

    @GET("/v2/informers")
    fun getWeather(
        @Header(WEATHER_KEY) keyValue: String,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ) : Call<WeatherDataTransferObject>

}