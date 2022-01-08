package com.example.homework.di

import com.example.homework.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {

    fun inject(mainActivityViewModel: MainActivityViewModel)
}