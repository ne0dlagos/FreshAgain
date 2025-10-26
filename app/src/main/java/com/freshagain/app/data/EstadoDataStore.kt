package com.freshagain.app.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Declara el DataStore con un nombre de archivo
val Context.dataStore by preferencesDataStore(name = "preferencias_usuario")

class EstadoDataStore(private val context: Context) {

    // Clave para guardar si el usuario está registrado
    private val USUARIO_REGISTRADO = booleanPreferencesKey("usuario_registrado")

    // Función para guardar el estado
    suspend fun guardarEstadoRegistro(estaRegistrado: Boolean) {
        context.dataStore.edit { preferencias ->
            preferencias[USUARIO_REGISTRADO] = estaRegistrado
        }
    }

    // Función para leer el estado
    fun obtenerEstadoRegistro(): Flow<Boolean> {
        return context.dataStore.data.map { preferencias ->
            preferencias[USUARIO_REGISTRADO] ?: false
        }
    }
}