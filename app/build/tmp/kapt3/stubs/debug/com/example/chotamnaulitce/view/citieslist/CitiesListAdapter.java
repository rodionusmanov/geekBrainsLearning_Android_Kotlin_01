package com.example.chotamnaulitce.view.citieslist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/chotamnaulitce/view/citieslist/CitiesListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/chotamnaulitce/view/citieslist/CitiesListAdapter$WeatherViewHolder;", "dataList", "", "Lcom/example/chotamnaulitce/domain/Weather;", "callback", "Lcom/example/chotamnaulitce/view/details/IOnItemClick;", "(Ljava/util/List;Lcom/example/chotamnaulitce/view/details/IOnItemClick;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "WeatherViewHolder", "app_debug"})
public final class CitiesListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.chotamnaulitce.view.citieslist.CitiesListAdapter.WeatherViewHolder> {
    private final java.util.List<com.example.chotamnaulitce.domain.Weather> dataList = null;
    private final com.example.chotamnaulitce.view.details.IOnItemClick callback = null;
    
    public CitiesListAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.chotamnaulitce.domain.Weather> dataList, @org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.view.details.IOnItemClick callback) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.chotamnaulitce.view.citieslist.CitiesListAdapter.WeatherViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.view.citieslist.CitiesListAdapter.WeatherViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/example/chotamnaulitce/view/citieslist/CitiesListAdapter$WeatherViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/example/chotamnaulitce/view/citieslist/CitiesListAdapter;Landroid/view/View;)V", "bind", "", "weather", "Lcom/example/chotamnaulitce/domain/Weather;", "app_debug"})
    public final class WeatherViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public WeatherViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.chotamnaulitce.domain.Weather weather) {
        }
    }
}