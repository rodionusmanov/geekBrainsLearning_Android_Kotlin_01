package com.example.chotamnaulitce.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/example/chotamnaulitce/model/IUniversalCallback;", "", "onFailure", "", "e", "Ljava/io/IOException;", "onResponse", "weather", "Lcom/example/chotamnaulitce/domain/Weather;", "app_debug"})
public abstract interface IUniversalCallback {
    
    public abstract void onResponse(@org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.domain.Weather weather);
    
    public abstract void onFailure(@org.jetbrains.annotations.NotNull()
    java.io.IOException e);
}