package com.example.chotamnaulitce.viewmodel.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chotamnaulitce.model.*

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
        repository = if (isConnected()) {
            RepositoryDetailsOkhttpImpl()
        } else {
            RepositoryDetailsRetrofitImpl()
        }
    }

    fun getWeather(latitude: Double, longitude: Double) {
        chooseRepository()
        liveData.value = DetailsFragmentAppState.Loading
        liveData.postValue(DetailsFragmentAppState.Success(repository.getWeather(latitude, longitude)))
    }

    private fun isConnected(): Boolean {
        return false
    }
}