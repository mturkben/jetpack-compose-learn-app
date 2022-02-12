package com.test.rickandmorty.presentation

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {

    val darkMode = mutableStateOf(false)

    fun toggleTheme() {
        darkMode.value = !darkMode.value
    }
}