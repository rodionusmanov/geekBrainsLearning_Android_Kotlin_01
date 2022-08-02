package com.example.chotamnaulitce.viewmodel.details

import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject

sealed class DetailsFragmentAppState {
    data class Success(val weatherData: Weather) : DetailsFragmentAppState()
    data class Error(val error: Any) : DetailsFragmentAppState()
    object Loading : DetailsFragmentAppState()
}