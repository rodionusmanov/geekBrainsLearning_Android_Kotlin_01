package com.example.chotamnaulitce.model.DataTransferObject


import com.google.gson.annotations.SerializedName

data class Fact(
    @SerializedName("condition")
    val condition: String,
    @SerializedName("feels_like")
    val feelsLike: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("temp")
    val temp: Int,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_speed")
    val windSpeed: Double
)