package com.freshagain.app.data.remote

import com.freshagain.app.model.ClimaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ExternalApiService {
    // Consulta del clima actual en SCL
    @GET("v1/forecast")
    suspend fun obtenerClimaActual(
        @Query("latitude") lat: Double = -33.4489,
        @Query("longitude") lon: Double = -70.6693,
        @Query("current_weather") current: Boolean = true
    ): ClimaResponse
}