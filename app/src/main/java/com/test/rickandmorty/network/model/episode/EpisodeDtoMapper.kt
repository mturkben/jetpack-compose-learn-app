package com.test.rickandmorty.network.model.episode

import com.test.rickandmorty.domain.model.Episode
import com.test.rickandmorty.domain.util.DomainMapper

class EpisodeDtoMapper : DomainMapper<EpisodeDto, Episode> {

    override fun mapFromDomainModel(domainModel: Episode): EpisodeDto {
        return EpisodeDto(
            id = domainModel.id,
            name = domainModel.name,
            air_date = domainModel.airDate,
            episode = domainModel.episode,
            characters = domainModel.characters,
            url = domainModel.url,
            created = domainModel.created,
        )
    }

    override fun mapToDomainModel(model: EpisodeDto): Episode {
        return Episode(
            id = model.id,
            name = model.name,
            airDate = model.air_date,
            episode = model.episode,
            characters = model.characters,
            url = model.url,
            created = model.created,
        )
    }

    fun toDomainList(initial: List<EpisodeDto>): List<Episode> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Episode>): List<EpisodeDto> {
        return initial.map { mapFromDomainModel(it) }
    }

}