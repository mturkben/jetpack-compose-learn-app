package com.test.rickandmorty.presentation.ui.character_detail

sealed class CharacterDetailEvents {

    data class GetCharacterEvent(
        var characterId: String
    ) : CharacterDetailEvents()
}