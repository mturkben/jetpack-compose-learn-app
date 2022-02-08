package com.test.rickandmorty.di

import com.test.rickandmorty.network.RMService
import com.test.rickandmorty.network.model.character.CharacterDtoMapper
import com.test.rickandmorty.network.model.episode.EpisodeDtoMapper
import com.test.rickandmorty.network.model.location.LocationDtoMapper
import com.test.rickandmorty.repository.RMRepository
import com.test.rickandmorty.repository.RMRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRMRepository1(
        rmService: RMService,
        locationMapper: LocationDtoMapper,
        episodeMapper: EpisodeDtoMapper,
        characterMapper: CharacterDtoMapper
    ): RMRepository {
        return RMRepositoryImpl(
            rmService = rmService,
            characterMapper = characterMapper,
            episodeMapper = episodeMapper,
            locationMapper = locationMapper
        )
    }


}