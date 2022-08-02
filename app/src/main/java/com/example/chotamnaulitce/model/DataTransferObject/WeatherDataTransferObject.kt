package com.example.chotamnaulitce.model.DataTransferObject

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherDataTransferObject(
    @SerializedName("fact")
    val fact: Fact,
    @SerializedName("info")
    val info: Info
) : Parcelable