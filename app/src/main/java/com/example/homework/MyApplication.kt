package com.example.homework

import android.app.Application
import com.example.homework.di.DaggerRetroComponent
import com.example.homework.di.RetroComponent
import com.example.homework.di.RetroModule


class MyApplication: Application() {

    private lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()

        retroComponent = DaggerRetroComponent.builder()
            .retroModule(RetroModule())
            .build()
    }

    fun getRetroComponent(): RetroComponent {
        return retroComponent
    }
}