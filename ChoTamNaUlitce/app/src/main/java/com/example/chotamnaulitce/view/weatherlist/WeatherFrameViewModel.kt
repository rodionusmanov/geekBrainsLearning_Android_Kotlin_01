package com.example.chotamnaulitce.view.weatherlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chotamnaulitce.viewmodel.AppState

class WeatherFrameViewModel(val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()) : ViewModel() {

    fun sentRequest(){
        liveData.value = AppState.Loading
        liveData.value = AppState.Success(Any())
    }
}