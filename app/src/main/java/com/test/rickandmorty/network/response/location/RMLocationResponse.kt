package com.test.rickandmorty.network.response.location

import com.google.gson.annotations.SerializedName
import com.test.rickandmorty.network.constant.ResponseInfo
import com.test.rickandmorty.network.model.location.LocationDto

data class RMLocationResponse(

    @SerializedName("info")
    var info: ResponseInfo,

    @SerializedName("results")
    var result: List<LocationDto>
)