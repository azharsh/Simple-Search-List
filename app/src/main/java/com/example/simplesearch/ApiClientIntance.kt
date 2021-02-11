package com.example.simplesearch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClientIntance {

    companion object{

        private var retrofit: Retrofit? = null

        private val BASE_URL = "http://newsapi.org/v2/"

        fun getRetrofitInstance(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }


}