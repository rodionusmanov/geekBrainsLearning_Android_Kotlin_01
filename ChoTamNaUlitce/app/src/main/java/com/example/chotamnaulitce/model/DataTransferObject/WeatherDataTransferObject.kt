package com.example.chotamnaulitce.model.DataTransferObject


import com.google.gson.annotations.SerializedName

data class WeatherDataTransferObject(
    @SerializedName("fact")
    val fact: Fact,
    @SerializedName("info")
    val info: Info
)