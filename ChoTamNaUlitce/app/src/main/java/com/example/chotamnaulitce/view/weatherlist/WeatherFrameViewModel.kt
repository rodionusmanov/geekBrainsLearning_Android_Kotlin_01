package com.example.chotamnaulitce.view.weatherlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chotamnaulitce.databinding.WeatherFragmentFrameBinding
import com.example.chotamnaulitce.model.IRepository
import com.example.chotamnaulitce.model.RepositoryLocalImpl
import com.example.chotamnaulitce.model.RepositoryRemoteImpl
import com.example.chotamnaulitce.viewmodel.AppState
import java.lang.Thread.sleep
import kotlin.random.Random

class WeatherFrameViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()
) :
    ViewModel() {

    lateinit var repository: IRepository

    fun getLiveData(): MutableLiveData<AppState> {
        chooseRepository()
        return liveData
    }

    private fun chooseRepository() {
        repository = if (isConnected()) {
            RepositoryRemoteImpl()
        } else {
            RepositoryLocalImpl()
        }
    }

    fun sentRequest() {
        liveData.value = AppState.Loading
        if (Random.nextInt(0, 3) < 2) {
            liveData.value = AppState.Success(repository.getWeather(55.45, 37.36))
        } else {
            liveData.postValue(AppState.Error(Any()))
        }

        /*Thread {
            sleep(2000L)
            if (Random.nextInt(0, 2) < 2) {
                liveData.postValue(AppState.Success(Any()))
            } else {
                liveData.postValue(AppState.Error(Any()))
            }
        }.start()*/

    }

    private fun isConnected(): Boolean {
        return false
    }
}