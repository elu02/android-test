package com.example.learning.tab2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JikanApiInterface {
    @GET("/v3/search/anime")
    fun getAnimeList(@Query("q") query: String) : Call<AnimeResults>
}