package com.test.rickandmorty.presentation.ui.character_list

sealed class CharactersEvents {

    object NewSearchEvent : CharactersEvents()

    object NextPageEvent : CharactersEvents()

}