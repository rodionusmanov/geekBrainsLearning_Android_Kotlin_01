package com.example.chotamnaulitce.viewmodel.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.model.*
import com.example.chotamnaulitce.model.retrofit.RepositoryLocationToWeatherRetrofitImpl
import com.example.chotamnaulitce.utils.chosenRepository
import com.example.chotamnaulitce.utils.isConnected
import java.io.IOException

class DetailsViewModel(
    private val liveData: MutableLiveData<DetailsFragmentAppState> = MutableLiveData<DetailsFragmentAppState>()
) :
    ViewModel() {

    private lateinit var repositoryLocationToWeather: IRepositoryLocationToWeather
    lateinit var repositoryAddable: IRepositoryAddable

    fun getLiveData(): MutableLiveData<DetailsFragmentAppState> {
        return liveData
    }

    private fun chooseRepository() {
        if (isConnected) {
            repositoryLocationToWeather = when (chosenRepository) {
                1 -> {
                    RepositoryLocationToWeatherOkhttpImpl()
                }
                2 -> {
                    RepositoryLocationToWeatherRetrofitImpl()
                }
                3 -> {
                    RepositoryLocationToWeatherRoomImpl()
                }
                4 -> {
                    RepositoryLocationToWeatherLocalImpl()
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
            repositoryLocationToWeather = when (chosenRepository) {
                3 -> {
                    RepositoryLocationToWeatherRoomImpl()
                }
                4 -> {
                    RepositoryLocationToWeatherLocalImpl()
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