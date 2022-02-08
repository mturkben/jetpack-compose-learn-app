package com.test.rickandmorty.presentation.ui.episodes

sealed class EpisodeEvent {

    object NewQuery : EpisodeEvent()

    object NextPage : EpisodeEvent()
}