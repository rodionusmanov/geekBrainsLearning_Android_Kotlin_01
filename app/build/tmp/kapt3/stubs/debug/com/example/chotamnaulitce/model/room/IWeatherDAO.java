package com.example.chotamnaulitce.model.room;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\'JX\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000eH\'J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0004H\'\u00a8\u0006\u001a"}, d2 = {"Lcom/example/chotamnaulitce/model/room/IWeatherDAO;", "", "getWeatherAll", "", "Lcom/example/chotamnaulitce/model/room/WeatherEntity;", "getWeatherByLocation", "mLatitude", "", "mLongitude", "insertNative", "", "id", "", "name", "", "latitude", "longitude", "temperatureActual", "", "temperatureFeels", "humidity", "condition", "windSpeed", "windDirection", "insertRoom", "weatherEntity", "app_debug"})
public abstract interface IWeatherDAO {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertRoom(@org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.model.room.WeatherEntity weatherEntity);
    
    @androidx.room.Query(value = "INSERT INTO weather_entity_table (id, name, latitude, longitude, temperatureActual, temperatureFeels, humidity, condition, windSpeed, windDirection) VALUES(:id, :name, :latitude, :longitude, :temperatureActual, :temperatureFeels, :humidity, :condition, :windSpeed, :windDirection)")
    public abstract void insertNative(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, double latitude, double longitude, int temperatureActual, int temperatureFeels, int humidity, @org.jetbrains.annotations.NotNull()
    java.lang.String condition, double windSpeed, @org.jetbrains.annotations.NotNull()
    java.lang.String windDirection);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM weather_entity_table WHERE latitude=:mLatitude AND longitude=:mLongitude LIMIT 1")
    public abstract java.util.List<com.example.chotamnaulitce.model.room.WeatherEntity> getWeatherByLocation(double mLatitude, double mLongitude);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM weather_entity_table")
    public abstract java.util.List<com.example.chotamnaulitce.model.room.WeatherEntity> getWeatherAll();
}