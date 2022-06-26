package com.example.chotamnaulitce.viewmodel

sealed class AppState {
    data class Success(val weatherData: Any) : AppState()
    data class Error(val error: Any) : AppState()
    object Loading : AppState()
}