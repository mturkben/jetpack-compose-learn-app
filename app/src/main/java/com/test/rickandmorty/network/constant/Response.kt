package com.test.rickandmorty.network.constant

data class ResponseInfo(
    var count: Int? = null,
    var pages: Int? = null,
    var next: String? = null,
    var prev: String? = null,
)