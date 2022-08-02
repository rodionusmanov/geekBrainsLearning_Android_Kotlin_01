package com.example.chotamnaulitce.view.details

import com.example.chotamnaulitce.domain.Weather

fun interface IOnItemClick {
    fun onItemClick(weather: Weather)
}