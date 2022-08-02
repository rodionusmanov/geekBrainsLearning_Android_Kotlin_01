package com.example.chotamnaulitce.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/chotamnaulitce/model/IRepositoryLocationToWeather;", "", "getWeather", "", "weather", "Lcom/example/chotamnaulitce/domain/Weather;", "callback", "Lcom/example/chotamnaulitce/model/IUniversalCallback;", "app_debug"})
public abstract interface IRepositoryLocationToWeather {
    
    public abstract void getWeather(@org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.domain.Weather weather, @org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.model.IUniversalCallback callback);
}