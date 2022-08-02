package com.example.chotamnaulitce.model.DataTransferObject;

import java.lang.System;

@kotlinx.android.parcel.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fH\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001c"}, d2 = {"Lcom/example/chotamnaulitce/model/DataTransferObject/WeatherDataTransferObject;", "Landroid/os/Parcelable;", "fact", "Lcom/example/chotamnaulitce/model/DataTransferObject/Fact;", "info", "Lcom/example/chotamnaulitce/model/DataTransferObject/Info;", "(Lcom/example/chotamnaulitce/model/DataTransferObject/Fact;Lcom/example/chotamnaulitce/model/DataTransferObject/Info;)V", "getFact", "()Lcom/example/chotamnaulitce/model/DataTransferObject/Fact;", "getInfo", "()Lcom/example/chotamnaulitce/model/DataTransferObject/Info;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class WeatherDataTransferObject implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "fact")
    private final com.example.chotamnaulitce.model.DataTransferObject.Fact fact = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "info")
    private final com.example.chotamnaulitce.model.DataTransferObject.Info info = null;
    public static final android.os.Parcelable.Creator<com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject copy(@org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.model.DataTransferObject.Fact fact, @org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.model.DataTransferObject.Info info) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public WeatherDataTransferObject(@org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.model.DataTransferObject.Fact fact, @org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.model.DataTransferObject.Info info) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chotamnaulitce.model.DataTransferObject.Fact component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chotamnaulitce.model.DataTransferObject.Fact getFact() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chotamnaulitce.model.DataTransferObject.Info component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chotamnaulitce.model.DataTransferObject.Info getInfo() {
        return null;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.chotamnaulitce.model.DataTransferObject.WeatherDataTransferObject[] newArray(int size) {
            return null;
        }
    }
}