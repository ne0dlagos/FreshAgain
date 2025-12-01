package com.freshagain.app.data

import com.freshagain.app.data.remote.RetrofitInstance
import com.freshagain.app.model.Prenda

class PrendaRepository {
    private val api = RetrofitInstance.api

    // GET: Obtener lista
    suspend fun obtenerPrendas(): List<Prenda> {
        return try {
            api.obtenerPrendas()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }

    // POST: Crear
    suspend fun crearPrenda(prenda: Prenda): Prenda? {
        return try {
            api.crearPrenda(prenda)
        } catch (e: Exception) {
            println("Error creando: ${e.message}")
            null
        }
    }

    // PUT: Actualizar
    suspend fun actualizarPrenda(id: Long, prenda: Prenda): Prenda? {
        return try {
            api.actualizarPrenda(id, prenda)
        } catch (e: Exception) {
            println("Error actualizando: ${e.message}")
            null
        }
    }

    // DELETE: Eliminar
    suspend fun eliminarPrenda(id: Long): Boolean {
        return try {
            val response = api.eliminarPrenda(id)
            response.isSuccessful
        } catch (e: Exception) {
            println("Error eliminando: ${e.message}")
            false
        }
    }
}