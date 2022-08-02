package com.example.chotamnaulitce.viewmodel.details;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/chotamnaulitce/viewmodel/details/DetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "liveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/chotamnaulitce/viewmodel/details/DetailsFragmentAppState;", "(Landroidx/lifecycle/MutableLiveData;)V", "callback", "Lcom/example/chotamnaulitce/model/IUniversalCallback;", "repositoryAddable", "Lcom/example/chotamnaulitce/model/IRepositoryAddable;", "getRepositoryAddable", "()Lcom/example/chotamnaulitce/model/IRepositoryAddable;", "setRepositoryAddable", "(Lcom/example/chotamnaulitce/model/IRepositoryAddable;)V", "repositoryLocationToWeather", "Lcom/example/chotamnaulitce/model/IRepositoryLocationToWeather;", "chooseRepository", "", "getLiveData", "getWeather", "weather", "Lcom/example/chotamnaulitce/domain/Weather;", "app_debug"})
public final class DetailsViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<com.example.chotamnaulitce.viewmodel.details.DetailsFragmentAppState> liveData = null;
    private com.example.chotamnaulitce.model.IRepositoryLocationToWeather repositoryLocationToWeather;
    public com.example.chotamnaulitce.model.IRepositoryAddable repositoryAddable;
    private final com.example.chotamnaulitce.model.IUniversalCallback callback = null;
    
    public DetailsViewModel() {
        super();
    }
    
    public DetailsViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.example.chotamnaulitce.viewmodel.details.DetailsFragmentAppState> liveData) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chotamnaulitce.model.IRepositoryAddable getRepositoryAddable() {
        return null;
    }
    
    public final void setRepositoryAddable(@org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.model.IRepositoryAddable p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.chotamnaulitce.viewmodel.details.DetailsFragmentAppState> getLiveData() {
        return null;
    }
    
    private final void chooseRepository() {
    }
    
    public final void getWeather(@org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.domain.Weather weather) {
    }
}