package com.test.rickandmorty.di

import com.google.gson.GsonBuilder
import com.test.rickandmorty.BuildConfig
import com.test.rickandmorty.network.RMService
import com.test.rickandmorty.network.model.character.CharacterDtoMapper
import com.test.rickandmorty.network.model.episode.EpisodeDtoMapper
import com.test.rickandmorty.network.model.location.LocationDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideCharacterMapper(): CharacterDtoMapper {
        return CharacterDtoMapper()
    }

    @Provides
    @Singleton
    fun provideLocationMapper(): LocationDtoMapper {
        return LocationDtoMapper()
    }

    @Provides
    @Singleton
    fun provideEpisodeMapper(): EpisodeDtoMapper {
        return EpisodeDtoMapper()
    }

    @Provides
    @Singleton
    fun provideRMService(): RMService {

        val client: OkHttpClient.Builder = OkHttpClient().newBuilder()

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
            client.addInterceptor(logging)
        }

        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(client.build())
            .build()
            .create(RMService::class.java)
    }


}