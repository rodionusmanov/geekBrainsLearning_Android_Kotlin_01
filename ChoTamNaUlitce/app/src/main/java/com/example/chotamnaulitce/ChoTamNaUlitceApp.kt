package com.example.chotamnaulitce

import android.app.Application

class ChoTamNaUlitceApp:Application() {
    override fun onCreate() {
        super.onCreate()
        choTamNaUlitceApp = this
    }

    companion object {
        private var choTamNaUlitceApp:ChoTamNaUlitceApp? = null

        fun getChoTamNaUlitce() = choTamNaUlitceApp!!
    }
}