package com.example.chotamnaulitce.view.details;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 32\u00020\u0001:\u00013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0003J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u0013H\u0002J6\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001f0*2\u0006\u0010+\u001a\u00020\u00152\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130-H\u0002J*\u0010.\u001a\u00020\u001f*\u00020\u00172\u0006\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u00132\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001f02H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/example/chotamnaulitce/view/details/DetailsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/chotamnaulitce/databinding/DetailsWeatherFragmentBinding;", "binding", "getBinding", "()Lcom/example/chotamnaulitce/databinding/DetailsWeatherFragmentBinding;", "receiver", "Landroid/content/BroadcastReceiver;", "viewModel", "Lcom/example/chotamnaulitce/viewmodel/details/DetailsViewModel;", "getViewModel", "()Lcom/example/chotamnaulitce/viewmodel/details/DetailsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "weatherLocal", "Lcom/example/chotamnaulitce/domain/Weather;", "fieldToString", "", "field", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "onViewCreated", "view", "renderData", "detailsFragmentAppState", "Lcom/example/chotamnaulitce/viewmodel/details/DetailsFragmentAppState;", "returnToTextField", "value", "Lcom/google/android/material/textfield/TextInputEditText;", "string", "toTextField", "Lkotlin/Function2;", "textInput", "fToString", "Lkotlin/Function1;", "withAction", "text", "returnText", "returnAction", "Lkotlin/Function0;", "Companion", "app_debug"})
public final class DetailsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.chotamnaulitce.view.details.DetailsFragment.Companion Companion = null;
    private static final java.lang.String BUNDLE_WEATHER_EXTRA = "BWE_key";
    private com.example.chotamnaulitce.databinding.DetailsWeatherFragmentBinding _binding;
    private final kotlin.Lazy viewModel$delegate = null;
    private com.example.chotamnaulitce.domain.Weather weatherLocal;
    private final android.content.BroadcastReceiver receiver = null;
    private java.util.HashMap _$_findViewCache;
    
    public DetailsFragment() {
        super();
    }
    
    private final com.example.chotamnaulitce.databinding.DetailsWeatherFragmentBinding getBinding() {
        return null;
    }
    
    private final com.example.chotamnaulitce.viewmodel.details.DetailsViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void renderData(com.example.chotamnaulitce.viewmodel.details.DetailsFragmentAppState detailsFragmentAppState) {
    }
    
    private final void withAction(android.view.View $this$withAction, java.lang.String text, java.lang.String returnText, kotlin.jvm.functions.Function0<kotlin.Unit> returnAction) {
    }
    
    private final kotlin.jvm.functions.Function2<com.google.android.material.textfield.TextInputEditText, java.lang.String, kotlin.Unit> toTextField(java.lang.Object textInput, kotlin.jvm.functions.Function1<java.lang.Object, java.lang.String> fToString) {
        return null;
    }
    
    private final java.lang.String fieldToString(java.lang.Object field) {
        return null;
    }
    
    private final void returnToTextField(com.google.android.material.textfield.TextInputEditText value, java.lang.String string) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/chotamnaulitce/view/details/DetailsFragment$Companion;", "", "()V", "BUNDLE_WEATHER_EXTRA", "", "newInstance", "Lcom/example/chotamnaulitce/view/details/DetailsFragment;", "weather", "Lcom/example/chotamnaulitce/domain/Weather;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.chotamnaulitce.view.details.DetailsFragment newInstance(@org.jetbrains.annotations.NotNull()
        com.example.chotamnaulitce.domain.Weather weather) {
            return null;
        }
    }
}