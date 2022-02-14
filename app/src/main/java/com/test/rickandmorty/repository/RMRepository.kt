package com.test.rickandmorty.repository

import com.test.rickandmorty.domain.model.Character
import com.test.rickandmorty.domain.model.Episode
import com.test.rickandmorty.domain.model.Location
import com.test.rickandmorty.network.response.character.RMCharacterResponse
import com.test.rickandmorty.network.response.episode.RMEpisodeResponse
import com.test.rickandmorty.network.response.location.RMLocationResponse


interface RMRepository {

    suspend fun getAllCharacters(): RMCharacterResponse

    suspend fun getCharactersNewPage(pageId: Int): RMCharacterResponse

    suspend fun getCharacter(characterId: String): Character

    suspend fun getAllLocations(): RMLocationResponse

    suspend fun getLocationNewPage(pageId: Int): RMLocationResponse

    suspend fun getLocation(locationId: Int): Location

    suspend fun getAllEpisodes(): RMEpisodeResponse

    suspend fun getEpisodeNewPage(pageId: Int): RMEpisodeResponse

    suspend fun getEpisode(episodeId: Int): Episode

}