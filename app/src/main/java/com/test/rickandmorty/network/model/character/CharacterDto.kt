package com.test.rickandmorty.network.model.character

import com.google.gson.annotations.SerializedName
import com.test.rickandmorty.network.constant.CharacterGender
import com.test.rickandmorty.network.constant.CharacterLocation
import com.test.rickandmorty.network.constant.CharacterOrigin
import com.test.rickandmorty.network.constant.CharacterStatus

data class CharacterDto(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("status")
    var status: CharacterStatus? = null,

    @SerializedName("species")
    var species: String? = null,

    @SerializedName("type")
    var type: String? = null,

    @SerializedName("gender")
    var gender: CharacterGender? = null,

    @SerializedName("origin")
    var origin: CharacterOrigin? = null,

    @SerializedName("location")
    var location: CharacterLocation? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("episode")
    var episode: List<String>? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("created")
    var created: String? = null,
)