package com.test.rickandmorty.network.model.episode

import com.google.gson.annotations.SerializedName


data class EpisodeDto(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("air_date")
    var air_date: String? = null,

    @SerializedName("episode")
    var episode: String? = null,

    @SerializedName("characters")
    var characters: List<String>? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("created")
    var created: String? = null,
)