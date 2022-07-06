package com.example.chotamnaulitce.view.weatherlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chotamnaulitce.model.*
import com.example.chotamnaulitce.viewmodel.AppState
import kotlin.random.Random

class WeatherFrameViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()
) :
    ViewModel() {

    lateinit var repositoryMulti: IRepositoryMulti
    lateinit var repositorySingle: IRepositorySingle

    fun getLiveData(): MutableLiveData<AppState> {
        chooseRepository()
        return liveData
    }

    private fun chooseRepository() {
        repositorySingle = if (isConnected()) {
            RepositoryRemoteImpl()
        } else {
            RepositoryLocalImpl()
        }
        repositoryMulti = RepositoryLocalImpl()
    }

    fun getWeatherListForRus(){
        sentRequest(Location.Rus)
    }
    fun getWeatherListForWorld(){
        sentRequest(Location.World)
    }

    private fun sentRequest(location: Location) {
        liveData.value = AppState.Loading
        if (Random.nextInt(0, 1) < 2) {
            liveData.value = AppState.SuccessMulti(repositoryMulti.getWeatherList(location))
        } else {
            liveData.postValue(AppState.Error(Any()))
        }
    }

    private fun isConnected(): Boolean {
        return false
    }
}