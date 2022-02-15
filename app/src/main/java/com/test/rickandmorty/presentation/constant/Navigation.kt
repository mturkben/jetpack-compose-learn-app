package com.test.rickandmorty.presentation.constant

import kotlinx.coroutines.flow.MutableStateFlow


class NavigationManager {

    var commands: MutableStateFlow<String?> = MutableStateFlow(null)

    fun navigate(
        directions: String
    ) {
        commands.value = directions
    }
}