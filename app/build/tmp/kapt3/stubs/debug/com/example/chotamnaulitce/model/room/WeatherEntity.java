package com.example.chotamnaulitce.model.room;

import java.lang.System;

@androidx.room.Entity(tableName = "weather_entity_table")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0010R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\'\u00a8\u0006("}, d2 = {"Lcom/example/chotamnaulitce/model/room/WeatherEntity;", "", "id", "", "name", "", "latitude", "", "longitude", "temperatureActual", "", "temperatureFeels", "humidity", "condition", "windSpeed", "windDirection", "(JLjava/lang/String;DDIIILjava/lang/String;DLjava/lang/String;)V", "getCondition", "()Ljava/lang/String;", "setCondition", "(Ljava/lang/String;)V", "getHumidity", "()I", "setHumidity", "(I)V", "getId", "()J", "getLatitude", "()D", "getLongitude", "getName", "getTemperatureActual", "setTemperatureActual", "getTemperatureFeels", "setTemperatureFeels", "getWindDirection", "setWindDirection", "getWindSpeed", "setWindSpeed", "(D)V", "app_debug"})
public final class WeatherEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    private final double latitude = 0.0;
    private final double longitude = 0.0;
    private int temperatureActual;
    private int temperatureFeels;
    private int humidity;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String condition;
    private double windSpeed;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String windDirection;
    
    public WeatherEntity(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, double latitude, double longitude, int temperatureActual, int temperatureFeels, int humidity, @org.jetbrains.annotations.NotNull()
    java.lang.String condition, double windSpeed, @org.jetbrains.annotations.NotNull()
    java.lang.String windDirection) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final double getLatitude() {
        return 0.0;
    }
    
    public final double getLongitude() {
        return 0.0;
    }
    
    public final int getTemperatureActual() {
        return 0;
    }
    
    public final void setTemperatureActual(int p0) {
    }
    
    public final int getTemperatureFeels() {
        return 0;
    }
    
    public final void setTemperatureFeels(int p0) {
    }
    
    public final int getHumidity() {
        return 0;
    }
    
    public final void setHumidity(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCondition() {
        return null;
    }
    
    public final void setCondition(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final double getWindSpeed() {
        return 0.0;
    }
    
    public final void setWindSpeed(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWindDirection() {
        return null;
    }
    
    public final void setWindDirection(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
}