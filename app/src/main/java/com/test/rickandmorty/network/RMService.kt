package com.test.rickandmorty.network

import com.test.rickandmorty.network.model.character.CharacterDto
import com.test.rickandmorty.network.model.episode.EpisodeDto
import com.test.rickandmorty.network.model.location.LocationDto
import com.test.rickandmorty.network.response.character.RMCharacterResponse
import com.test.rickandmorty.network.response.episode.RMEpisodeResponse
import com.test.rickandmorty.network.response.location.RMLocationResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RMService {

    @GET("character")
    suspend fun getAllCharacters(): RMCharacterResponse

    @GET("character/")
    suspend fun getCharactersNewPage(@Query("page") page: Int): RMCharacterResponse

    @GET("character/{characterId}")
    suspend fun getCharacter(@Path("characterId") characterId: Int): CharacterDto

    @GET("location")
    suspend fun getAllLocations(): RMLocationResponse

    @GET("location")
    suspend fun getLocationNewPage(@Query("page") page: Int): RMLocationResponse

    @GET("location/{locationId}")
    suspend fun getLocation(@Path("locationId") locationId: Int): LocationDto

    @GET("episode")
    suspend fun getAllEpisodes(): RMEpisodeResponse

    @GET("episode")
    suspend fun getEpisodeNewPage(@Query("page") page: Int): RMEpisodeResponse

    @GET("episode/{episodeId}")
    suspend fun getEpisode(@Path("episodeId") episodeId: Int): EpisodeDto
}