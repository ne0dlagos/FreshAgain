package com.freshagain.app.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // Dirección IP 10.0.2.2 para que el emulador acceda a localhost
    private const val BASE_URL = "http://10.0.2.2:8080/"

    val api: PrendaApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PrendaApiService::class.java)
    }
}