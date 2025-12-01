package com.freshagain.app.data.remote

import com.freshagain.app.model.Prenda
import retrofit2.Response
import retrofit2.http.*

interface PrendaApiService {
    @GET("api/prendas")
    suspend fun obtenerPrendas(): List<Prenda>

    @POST("api/prendas")
    suspend fun crearPrenda(@Body prenda: Prenda): Prenda

    @PUT("api/prendas/{id}")
    suspend fun actualizarPrenda(@Path("id") id: Long, @Body prenda: Prenda): Prenda

    @DELETE("api/prendas/{id}")
    suspend fun eliminarPrenda(@Path("id") id: Long): Response<Unit>
}