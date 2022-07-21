package com.example.chotamnaulitce.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.chotamnaulitce.domain.City
import com.example.chotamnaulitce.domain.getDefaultCity

@Entity(tableName = "weather_entity_table")
class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    var temperatureActual: Int,
    var temperatureFeels: Int,
    var humidity: Int,
    var condition: String,
    var windSpeed: Double,
    var windDirection: String
)