package com.example.chotamnaulitce.viewmodel

import com.example.chotamnaulitce.domain.Weather

sealed class AppState {
    data class SuccessSingle(val weatherData: Weather) : AppState()
    data class SuccessMulti(val weatherList: List<Weather>) : AppState()
    data class Error(val error: Any) : AppState()
    object Loading : AppState()
}