package com.example.chotamnaulitce.viewmodel.citieslist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/example/chotamnaulitce/viewmodel/citieslist/CitiesListViewModel;", "Landroidx/lifecycle/ViewModel;", "liveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/chotamnaulitce/viewmodel/citieslist/CitiesListFragmentAppState;", "(Landroidx/lifecycle/MutableLiveData;)V", "repositoryCitiesList", "Lcom/example/chotamnaulitce/model/IRepositoryCitiesList;", "getRepositoryCitiesList", "()Lcom/example/chotamnaulitce/model/IRepositoryCitiesList;", "setRepositoryCitiesList", "(Lcom/example/chotamnaulitce/model/IRepositoryCitiesList;)V", "chooseRepository", "", "getLiveData", "getWeatherListForRus", "getWeatherListForWorld", "isConnected", "", "sentRequest", "location", "Lcom/example/chotamnaulitce/model/Location;", "app_debug"})
public final class CitiesListViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<com.example.chotamnaulitce.viewmodel.citieslist.CitiesListFragmentAppState> liveData = null;
    public com.example.chotamnaulitce.model.IRepositoryCitiesList repositoryCitiesList;
    
    public CitiesListViewModel() {
        super();
    }
    
    public CitiesListViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.example.chotamnaulitce.viewmodel.citieslist.CitiesListFragmentAppState> liveData) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chotamnaulitce.model.IRepositoryCitiesList getRepositoryCitiesList() {
        return null;
    }
    
    public final void setRepositoryCitiesList(@org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.model.IRepositoryCitiesList p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.chotamnaulitce.viewmodel.citieslist.CitiesListFragmentAppState> getLiveData() {
        return null;
    }
    
    private final void chooseRepository() {
    }
    
    public final void getWeatherListForRus() {
    }
    
    public final void getWeatherListForWorld() {
    }
    
    private final void sentRequest(com.example.chotamnaulitce.model.Location location) {
    }
    
    private final boolean isConnected() {
        return false;
    }
}