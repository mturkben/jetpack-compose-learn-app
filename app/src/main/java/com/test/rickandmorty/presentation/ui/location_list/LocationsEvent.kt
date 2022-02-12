package com.test.rickandmorty.presentation.ui.location_list

sealed class LocationsEvent {

    object NewQuery : LocationsEvent()

    object NextPage : LocationsEvent()
}
