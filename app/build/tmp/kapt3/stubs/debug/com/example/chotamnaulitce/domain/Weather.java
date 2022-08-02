package com.example.chotamnaulitce.domain;

import java.lang.System;

@kotlinx.android.parcel.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000eJ\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\tH\u00c6\u0003J\t\u0010*\u001a\u00020\u000bH\u00c6\u0003J\t\u0010+\u001a\u00020\tH\u00c6\u0003J\t\u0010,\u001a\u00020\tH\u00c6\u0003JY\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tH\u00c6\u0001J\t\u0010.\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u00d6\u0003J\t\u00103\u001a\u00020\u0005H\u00d6\u0001J\t\u00104\u001a\u00020\tH\u00d6\u0001J\u0019\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\r\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006:"}, d2 = {"Lcom/example/chotamnaulitce/domain/Weather;", "Landroid/os/Parcelable;", "city", "Lcom/example/chotamnaulitce/domain/City;", "temperatureActual", "", "temperatureFeels", "humidity", "condition", "", "windSpeed", "", "windDirection", "icon", "(Lcom/example/chotamnaulitce/domain/City;IIILjava/lang/String;DLjava/lang/String;Ljava/lang/String;)V", "getCity", "()Lcom/example/chotamnaulitce/domain/City;", "getCondition", "()Ljava/lang/String;", "setCondition", "(Ljava/lang/String;)V", "getHumidity", "()I", "setHumidity", "(I)V", "getIcon", "setIcon", "getTemperatureActual", "setTemperatureActual", "getTemperatureFeels", "setTemperatureFeels", "getWindDirection", "setWindDirection", "getWindSpeed", "()D", "setWindSpeed", "(D)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Weather implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private final com.example.chotamnaulitce.domain.City city = null;
    private int temperatureActual;
    private int temperatureFeels;
    private int humidity;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String condition;
    private double windSpeed;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String windDirection;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String icon;
    public static final android.os.Parcelable.Creator<com.example.chotamnaulitce.domain.Weather> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chotamnaulitce.domain.Weather copy(@org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.domain.City city, int temperatureActual, int temperatureFeels, int humidity, @org.jetbrains.annotations.NotNull()
    java.lang.String condition, double windSpeed, @org.jetbrains.annotations.NotNull()
    java.lang.String windDirection, @org.jetbrains.annotations.NotNull()
    java.lang.String icon) {
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
    
    public Weather(@org.jetbrains.annotations.NotNull()
    com.example.chotamnaulitce.domain.City city, int temperatureActual, int temperatureFeels, int humidity, @org.jetbrains.annotations.NotNull()
    java.lang.String condition, double windSpeed, @org.jetbrains.annotations.NotNull()
    java.lang.String windDirection, @org.jetbrains.annotations.NotNull()
    java.lang.String icon) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chotamnaulitce.domain.City component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.chotamnaulitce.domain.City getCity() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getTemperatureActual() {
        return 0;
    }
    
    public final void setTemperatureActual(int p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getTemperatureFeels() {
        return 0;
    }
    
    public final void setTemperatureFeels(int p0) {
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getHumidity() {
        return 0;
    }
    
    public final void setHumidity(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCondition() {
        return null;
    }
    
    public final void setCondition(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double getWindSpeed() {
        return 0.0;
    }
    
    public final void setWindSpeed(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWindDirection() {
        return null;
    }
    
    public final void setWindDirection(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIcon() {
        return null;
    }
    
    public final void setIcon(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.example.chotamnaulitce.domain.Weather> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.chotamnaulitce.domain.Weather createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.chotamnaulitce.domain.Weather[] newArray(int size) {
            return null;
        }
    }
}