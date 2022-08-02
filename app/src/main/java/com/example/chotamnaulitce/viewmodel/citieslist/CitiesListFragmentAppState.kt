package com.example.chotamnaulitce.viewmodel.citieslist

import com.example.chotamnaulitce.domain.Weather

sealed class CitiesListFragmentAppState {
    data class SuccessSingle(val weatherData: Weather) : CitiesListFragmentAppState()
    data class SuccessMulti(val weatherList: List<Weather>) : CitiesListFragmentAppState()
    data class Error(val error: Any) : CitiesListFragmentAppState()
    object Loading : CitiesListFragmentAppState()
}