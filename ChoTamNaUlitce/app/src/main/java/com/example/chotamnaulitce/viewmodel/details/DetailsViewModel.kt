package com.example.chotamnaulitce.viewmodel.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chotamnaulitce.model.*
import com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject
import java.io.IOException

class DetailsViewModel(
    private val liveData: MutableLiveData<DetailsFragmentAppState> = MutableLiveData<DetailsFragmentAppState>()
) :
    ViewModel() {

    private lateinit var repository: IRepositoryDetails

    fun getLiveData(): MutableLiveData<DetailsFragmentAppState> {
        chooseRepository()
        return liveData
    }

    private fun chooseRepository() {
        repository = when (2) {
            1 -> {
                RepositoryDetailsOkhttpImpl()
            }
            2 -> {
                RepositoryDetailsLocalImpl()
            }
            else -> {RepositoryDetailsLocalImpl()}
        }
    }

    fun getWeather(latitude: Double, longitude: Double) {
        chooseRepository()
        liveData.value = DetailsFragmentAppState.Loading
        repository.getWeather(latitude, longitude, callback)
    }

    private val callback = object : IUniversalCallback {
        override fun onResponse(weatherDataTransferObject: WeatherDataTransferObject) {
            liveData.postValue(DetailsFragmentAppState.Success(weatherDataTransferObject))
        }

        override fun onFailure(e: IOException) {
            liveData.postValue(DetailsFragmentAppState.Error(e))
        }
    }
}