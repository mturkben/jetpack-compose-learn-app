package com.test.rickandmorty.network.model.character

import com.test.rickandmorty.domain.model.Character
import com.test.rickandmorty.domain.util.DomainMapper

class CharacterDtoMapper : DomainMapper<CharacterDto, Character> {

    override fun mapFromDomainModel(domainModel: Character): CharacterDto {
        return CharacterDto(
            id = domainModel.id,
            name = domainModel.name,
            status = domainModel.status,
            species = domainModel.species,
            type = domainModel.type,
            gender = domainModel.gender,
            origin = domainModel.origin,
            location = domainModel.location,
            image = domainModel.image,
            episode = domainModel.episode,
            url = domainModel.url,
            created = domainModel.created
        )
    }

    override fun mapToDomainModel(model: CharacterDto): Character {
        return Character(
            id = model.id,
            name = model.name,
            status = model.status,
            species = model.species,
            type = model.type,
            gender = model.gender,
            origin = model.origin,
            location = model.location,
            image = model.image,
            episode = model.episode,
            url = model.url,
            created = model.created
        )
    }

    fun toDomainList(initial: List<CharacterDto>): List<Character> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Character>): List<CharacterDto> {
        return initial.map { mapFromDomainModel(it) }
    }

}