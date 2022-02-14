package com.test.rickandmorty.presentation.ui.character_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.rickandmorty.domain.model.Character
import com.test.rickandmorty.repository.RMRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel
@Inject
constructor(
    private var rmRepository: RMRepository
) : ViewModel() {

    val character: MutableState<Character?> = mutableStateOf(null)

    val loading: MutableState<Boolean> = mutableStateOf(true)


    fun onTriggerEvent(event: CharacterDetailEvents) {
        when (event) {
            is CharacterDetailEvents.GetCharacterEvent -> {
                getCharacter(event.characterId)
            }
            else -> {}
        }
    }


    private fun getCharacter(characterId: String) {
        viewModelScope.launch {
            character.value = rmRepository.getCharacter(characterId)
            loading.value = false
        }
    }
}