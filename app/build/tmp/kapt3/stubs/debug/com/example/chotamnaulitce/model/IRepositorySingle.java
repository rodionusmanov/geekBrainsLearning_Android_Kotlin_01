package com.example.chotamnaulitce.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/example/chotamnaulitce/model/IRepositorySingle;", "", "getWeather", "Lcom/example/chotamnaulitce/domain/Weather;", "latitude", "", "longitude", "getWeatherList", "", "location", "Lcom/example/chotamnaulitce/model/Location;", "app_debug"})
public abstract interface IRepositorySingle {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.chotamnaulitce.domain.Weather> getWeatherList(@org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.model.Location location);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.chotamnaulitce.domain.Weather getWeather(double latitude, double longitude);
}