package com.example.learning.tab2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JikanApiService {
    companion object {
        private const val BASE_URL = "https://api.jikan.moe"
        private var retrofit : Retrofit? = null

        fun getInstance() : Retrofit {
            if(retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit!!
        }
    }
}