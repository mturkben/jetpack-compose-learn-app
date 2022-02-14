package com.test.rickandmorty.repository

import com.test.rickandmorty.domain.model.Character
import com.test.rickandmorty.domain.model.Episode
import com.test.rickandmorty.domain.model.Location
import com.test.rickandmorty.network.RMService
import com.test.rickandmorty.network.model.character.CharacterDtoMapper
import com.test.rickandmorty.network.model.episode.EpisodeDtoMapper
import com.test.rickandmorty.network.model.location.LocationDtoMapper
import com.test.rickandmorty.network.response.character.RMCharacterResponse
import com.test.rickandmorty.network.response.episode.RMEpisodeResponse
import com.test.rickandmorty.network.response.location.RMLocationResponse

class RMRepositoryImpl(
    private val rmService: RMService,
    private val characterMapper: CharacterDtoMapper,
    private val episodeMapper: EpisodeDtoMapper,
    private val locationMapper: LocationDtoMapper
) : RMRepository {

    override suspend fun getAllCharacters(): RMCharacterResponse {
        return rmService.getAllCharacters()
    }

    override suspend fun getCharactersNewPage(pageId: Int): RMCharacterResponse {
        return rmService.getCharactersNewPage(pageId)
    }

    override suspend fun getCharacter(characterId: String): Character {
        return characterMapper.mapToDomainModel(rmService.getCharacter(characterId))
    }

    override suspend fun getAllLocations(): RMLocationResponse {
        return rmService.getAllLocations()
    }

    override suspend fun getLocationNewPage(pageId: Int): RMLocationResponse {
        return rmService.getLocationNewPage(pageId)
    }

    override suspend fun getLocation(locationId: Int): Location {
        TODO("Not yet implemented")
    }

    override suspend fun getAllEpisodes(): RMEpisodeResponse {
        return rmService.getAllEpisodes()
    }

    override suspend fun getEpisodeNewPage(pageId: Int): RMEpisodeResponse {
        return rmService.getEpisodeNewPage(pageId)
    }

    override suspend fun getEpisode(episodeId: Int): Episode {
        TODO("Not yet implemented")
    }

}