package com.test.rickandmorty.presentation.ui.episode_list

sealed class EpisodeEvent {

    object NewQuery : EpisodeEvent()

    object NextPage : EpisodeEvent()
}