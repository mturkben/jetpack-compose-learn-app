package com.test.rickandmorty.network.constant

enum class CharacterStatus {
    Alive, Dead, unknown
}

enum class CharacterGender {
    Female, Male, Genderless, unknown
}


data class CharacterOrigin(
    val name: String?,
    val url: String?
)

data class CharacterLocation(
    val name: String?,
    val url: String?
)