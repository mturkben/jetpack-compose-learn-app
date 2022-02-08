package com.test.rickandmorty.network.model.location

import com.google.gson.annotations.SerializedName

data class LocationDto(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("type")
    var type: String? = null,

    @SerializedName("dimension")
    var dimension: String? = null,

    @SerializedName("residents")
    var residents: List<String>? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("created")
    var created: String? = null
)