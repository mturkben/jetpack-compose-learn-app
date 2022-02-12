package com.test.rickandmorty.presentation.ui.character_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class CharacterDetailViewModel
constructor(
    private val characterId: String?
) : ViewModel() {

    val getCharacterId: MutableState<String?> = mutableStateOf(null)

    init {
        getCharacterId.value = characterId
    }

}