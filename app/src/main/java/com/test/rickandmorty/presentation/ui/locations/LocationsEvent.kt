package com.test.rickandmorty.presentation.ui.locations

sealed class LocationsEvent {

    object NewQuery : LocationsEvent()

    object NextPage : LocationsEvent()
}
