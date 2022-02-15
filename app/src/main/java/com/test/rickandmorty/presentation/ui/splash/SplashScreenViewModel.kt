package com.test.rickandmorty.presentation.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.rickandmorty.presentation.constant.App
import com.test.rickandmorty.presentation.constant.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel
@Inject
constructor(
    private val navigationManager: NavigationManager
) : ViewModel() {

    init {
        viewModelScope.launch {
            delay(1500)
            useNavigationManager(App)
        }
    }

    private fun useNavigationManager(direction: String) {
        navigationManager.navigate(direction)
    }
}