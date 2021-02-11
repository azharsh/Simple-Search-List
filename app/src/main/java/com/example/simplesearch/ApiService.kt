package com.example.simplesearch

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("everything")
    fun getAllNews(
        @Query("q") q :String,
        @Query("from") from :String,
        @Query("sortBy") sortBy :String,
        @Query("apiKey") apiKey :String,
    ): Call<APIResponse>

}