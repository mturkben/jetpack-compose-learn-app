package com.test.rickandmorty.network.model.location

import com.test.rickandmorty.domain.model.Location
import com.test.rickandmorty.domain.util.DomainMapper

class LocationDtoMapper : DomainMapper<LocationDto, Location> {

    override fun mapFromDomainModel(domainModel: Location): LocationDto {
        return LocationDto(
            id = domainModel.id,
            name = domainModel.name,
            type = domainModel.type,
            dimension = domainModel.dimension,
            residents = domainModel.residents,
            url = domainModel.url,
            created = domainModel.created,
        )
    }

    override fun mapToDomainModel(model: LocationDto): Location {
        return Location(
            id = model.id,
            name = model.name,
            type = model.type,
            dimension = model.dimension,
            residents = model.residents,
            url = model.url,
            created = model.created,
        )
    }

    fun toDomainList(initial: List<LocationDto>): List<Location> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Location>): List<LocationDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}
