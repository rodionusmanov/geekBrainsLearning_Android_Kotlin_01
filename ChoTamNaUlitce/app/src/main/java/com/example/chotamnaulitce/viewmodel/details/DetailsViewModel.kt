package com.example.chotamnaulitce.viewmodel.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.model.*
import com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject
import com.example.chotamnaulitce.model.retrofit.RepositoryLocationToWeatherRetrofitImpl
import com.example.chotamnaulitce.utils.isConnected
import java.io.IOException

class DetailsViewModel(
    private val liveData: MutableLiveData<DetailsFragmentAppState> = MutableLiveData<DetailsFragmentAppState>()
) :
    ViewModel() {

    private lateinit var repositoryLocationToWeather: IRepositoryLocationToWeather
    lateinit var repositoryAddable: IRepositoryAddable

    fun getLiveData(): MutableLiveData<DetailsFragmentAppState> {
        chooseRepository()
        return liveData
    }

    private fun chooseRepository() {
        if (isConnected) {
            repositoryLocationToWeather = when (1) {
                1 -> {
                    RepositoryLocationToWeatherOkhttpImpl()
                }
                2 -> {
                    RepositoryLocationToWeatherRetrofitImpl()
                }
                3 -> {
                    RepositoryLocationToWeatherLocalImpl()
                }
                4 -> {
                    RepositoryLocationToWeatherRoomImpl()
                }
                else -> {
                    RepositoryLocationToWeatherLocalImpl()
                }
            }
            repositoryAddable = when (0) {
                1 -> {
                    RepositoryLocationToWeatherRoomImpl()
                }

                else -> {
                    RepositoryLocationToWeatherRoomImpl()
                }
            }
        } else {
            repositoryLocationToWeather = when (4) {
                3 -> {
                    RepositoryLocationToWeatherLocalImpl()
                }
                4 -> {
                    RepositoryLocationToWeatherRoomImpl()
                }
                else -> {
                    RepositoryLocationToWeatherLocalImpl()
                }
            }
        }
    }


    fun getWeather(weather: Weather) {
        chooseRepository()
        liveData.value = DetailsFragmentAppState.Loading
        repositoryLocationToWeather.getWeather(weather, callback)
    }

    private val callback = object : IUniversalCallback {
        override fun onResponse(weather: Weather) {
            if (isConnected) {
                repositoryAddable.addWeather(weather)
            }
            liveData.postValue(DetailsFragmentAppState.Success(weather))
        }

        override fun onFailure(e: IOException) {
            liveData.postValue(DetailsFragmentAppState.Error(e))
        }
    }
}