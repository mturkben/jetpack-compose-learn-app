package com.test.rickandmorty.presentation.ui.character_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.rickandmorty.domain.model.Character

class CharacterDetailViewModelFactory(private val character: Character) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharacterDetailViewModel(character = character) as T
    }

}