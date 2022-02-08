package com.test.rickandmorty.presentation.ui.characters

sealed class CharactersEvents {

    object NewSearchEvent : CharactersEvents()

    object NextPageEvent : CharactersEvents()

}