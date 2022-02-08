package com.test.rickandmorty.domain.model

import com.test.rickandmorty.network.constant.CharacterGender
import com.test.rickandmorty.network.constant.CharacterLocation
import com.test.rickandmorty.network.constant.CharacterOrigin
import com.test.rickandmorty.network.constant.CharacterStatus

data class Character(
    val id: Int?,
    val name: String?,
    val status: CharacterStatus?,
    val species: String?,
    val type: String?,
    val gender: CharacterGender?,
    val origin: CharacterOrigin?,
    val location: CharacterLocation?,
    val image: String?,
    val episode: List<String>?,
    val url: String?,
    val created: String?,
)