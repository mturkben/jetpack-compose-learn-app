package com.test.rickandmorty.network.response.character

import com.google.gson.annotations.SerializedName
import com.test.rickandmorty.network.constant.ResponseInfo
import com.test.rickandmorty.network.model.character.CharacterDto

data class RMCharacterResponse(

    @SerializedName("info")
    var info: ResponseInfo,

    @SerializedName("results")
    var results: List<CharacterDto>,
)