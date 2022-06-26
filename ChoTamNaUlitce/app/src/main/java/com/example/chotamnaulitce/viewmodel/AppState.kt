package com.example.chotamnaulitce.viewmodel

import com.example.chotamnaulitce.domain.Weather

sealed class AppState {
    data class Success(val weatherData: Weather) : AppState()
    data class Error(val error: Any) : AppState()
    object Loading : AppState()
}