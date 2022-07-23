package com.vedantbhamare.catappgdp

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("breeds")
    suspend fun getCats(): Response<List<CatModel>>
}

object APIService {
    val api_instance: ApiInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api_instance = retrofit.create(ApiInterface::class.java)
    }
}