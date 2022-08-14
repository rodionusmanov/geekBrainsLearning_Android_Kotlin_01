package com.example.chotamnaulitce.viewmodel.citieslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chotamnaulitce.model.*
import kotlin.random.Random

class CitiesListViewModel(
    private val liveData: MutableLiveData<CitiesListFragmentAppState> = MutableLiveData<CitiesListFragmentAppState>()
) :
    ViewModel() {

    private lateinit var repositoryCitiesList: IRepositoryCitiesList

    fun getLiveData(): MutableLiveData<CitiesListFragmentAppState> {
        chooseRepository()
        return liveData
    }

    private fun chooseRepository() {
        repositoryCitiesList = RepositoryCitiesListImpl()
    }

    fun getWeatherListForRus(){
        sentRequest(Location.Rus)
    }
    fun getWeatherListForWorld(){
        sentRequest(Location.World)
    }

    private fun sentRequest(location: Location) {
        liveData.value = CitiesListFragmentAppState.Loading
        if (Random.nextInt(0, 1) < 2) {
            liveData.value = CitiesListFragmentAppState.SuccessMulti(repositoryCitiesList.getCitiesList(location))
        } else {
            liveData.postValue(CitiesListFragmentAppState.Error(Any()))
        }
    }
}