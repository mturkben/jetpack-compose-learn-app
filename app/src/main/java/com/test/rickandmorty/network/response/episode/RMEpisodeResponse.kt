package com.test.rickandmorty.network.response.episode

import com.google.gson.annotations.SerializedName
import com.test.rickandmorty.network.constant.ResponseInfo
import com.test.rickandmorty.network.model.episode.EpisodeDto

data class RMEpisodeResponse(

    @SerializedName("info")
    var info: ResponseInfo,

    @SerializedName("results")
    var result: List<EpisodeDto>

)
