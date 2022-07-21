package com.example.chotamnaulitce.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRoom(weatherEntity: WeatherEntity)

    @Query("INSERT INTO weather_entity_table (id, name, latitude, longitude, temperatureActual, temperatureFeels, humidity, condition, windSpeed, windDirection) VALUES(:id, :name, :latitude, :longitude, :temperatureActual, :temperatureFeels, :humidity, :condition, :windSpeed, :windDirection)")
    fun insertNative(
        id: Long,
        name: String,
        latitude: Double,
        longitude: Double,
        temperatureActual: Int,
        temperatureFeels: Int,
        humidity: Int,
        condition: String,
        windSpeed: Double,
        windDirection: String
    )

    @Query("SELECT * FROM weather_entity_table WHERE latitude=:mLatitude AND longitude=:mLongitude LIMIT 1")
    fun getWeatherOne(mLatitude: Double, mLongitude: Double):List<WeatherEntity>

    @Query("SELECT * FROM weather_entity_table")
    fun getWeatherAll():List<WeatherEntity>

}