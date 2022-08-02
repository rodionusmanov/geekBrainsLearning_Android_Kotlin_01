package com.example.chotamnaulitce

import android.app.Application
import androidx.room.Room
import com.example.chotamnaulitce.model.room.WeatherDatabase
import com.example.chotamnaulitce.utils.ROOM_DB_NAME_WEATHER

class ChoTamNaUlitceApp : Application() {
    override fun onCreate() {
        super.onCreate()
        choTamNaUlitceApp = this
    }

    companion object {
        private var choTamNaUlitceApp: ChoTamNaUlitceApp? = null
        private var weatherDatabase: WeatherDatabase? = null
        fun getChoTamNaUlitce() = choTamNaUlitceApp!!
        fun getWeatherDatabase(): WeatherDatabase {
            if (weatherDatabase == null) {
                weatherDatabase = Room.databaseBuilder(
                    getChoTamNaUlitce(),
                    WeatherDatabase::class.java,
                    ROOM_DB_NAME_WEATHER
                ).build()
            }
            return weatherDatabase!!
        }
    }
}