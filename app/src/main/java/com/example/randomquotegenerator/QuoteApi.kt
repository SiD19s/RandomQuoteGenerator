package com.example.randomquotegenerator

import retrofit2.http.GET

interface QuoteApi {
    @GET("random") // put the end of the url
    suspend fun getRandom(): Quote
}

data class Quote(
    var content: String,
    var author: String
)