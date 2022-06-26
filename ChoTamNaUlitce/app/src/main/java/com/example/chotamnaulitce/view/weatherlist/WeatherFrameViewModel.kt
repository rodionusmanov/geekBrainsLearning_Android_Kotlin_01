package com.example.chotamnaulitce.view.weatherlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chotamnaulitce.viewmodel.AppState
import java.lang.Thread.sleep
import kotlin.random.Random

class WeatherFrameViewModel(val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()) :
    ViewModel() {

    fun sentRequest() {
        liveData.value = AppState.Loading
        Thread {
            sleep(2000L)
            if (Random.nextInt(0, 3) < 2) {
                liveData.postValue(AppState.Success(Any()))
            } else {
                liveData.postValue(AppState.Error(Any()))
            }
        }.start()

    }
}