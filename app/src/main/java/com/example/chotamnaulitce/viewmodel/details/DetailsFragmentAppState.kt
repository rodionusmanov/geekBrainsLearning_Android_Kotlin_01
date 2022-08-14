package com.example.chotamnaulitce.viewmodel.details

import com.example.chotamnaulitce.domain.Weather

sealed class DetailsFragmentAppState {
    data class Success(val weatherData: Weather) : DetailsFragmentAppState()
    data class Error(val error: Any) : DetailsFragmentAppState()
    object Loading : DetailsFragmentAppState()
}