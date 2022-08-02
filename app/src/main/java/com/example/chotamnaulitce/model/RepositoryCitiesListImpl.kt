package com.example.chotamnaulitce.model

import com.example.chotamnaulitce.domain.Weather
import com.example.chotamnaulitce.domain.getRusCities
import com.example.chotamnaulitce.domain.getWorldCities

class RepositoryCitiesListImpl : IRepositoryCitiesList {

    override fun getCitiesList(location: Location): List<Weather> {
        return when (location) {
            Location.Rus -> {
                getRusCities()
            }
            Location.World -> {
                getWorldCities()
            }
        }
    }
}