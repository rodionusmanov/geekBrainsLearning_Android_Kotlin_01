package com.example.chotamnaulitce.model.retrofit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH\'\u00a8\u0006\n"}, d2 = {"Lcom/example/chotamnaulitce/model/retrofit/WeatherAPI;", "", "getWeather", "Lretrofit2/Call;", "Lcom/example/chotamnaulitce/model/DataTransferObject/WeatherDataTransferObject;", "keyValue", "", "latitude", "", "longitude", "app_debug"})
public abstract interface WeatherAPI {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/v2/informers")
    public abstract retrofit2.Call<com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject> getWeather(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "X-Yandex-API-Key")
    java.lang.String keyValue, @retrofit2.http.Query(value = "latitude")
    double latitude, @retrofit2.http.Query(value = "longitude")
    double longitude);
}