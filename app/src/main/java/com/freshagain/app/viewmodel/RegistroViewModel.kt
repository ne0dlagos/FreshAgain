package com.freshagain.app.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.freshagain.app.model.RegistroErrores
import com.freshagain.app.model.RegistroUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegistroViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(RegistroUiState())
    val uiState: StateFlow<RegistroUiState> = _uiState.asStateFlow()

    fun onNombreChange(valor: String) {
        _uiState.update {
            it.copy(
                nombre = valor,
                errores = it.errores.copy(nombre = null)
            )
        }
    }

    fun onCorreoChange(valor: String) {
        _uiState.update {
            it.copy(
                correo = valor,
                errores = it.errores.copy(correo = null)
            )
        }
    }

    fun onClaveChange(valor: String) {
        _uiState.update {
            it.copy(
                clave = valor,
                errores = it.errores.copy(clave = null)
            )
        }
    }

    fun onAceptaTerminosChange(valor: Boolean) {
        _uiState.update { it.copy(aceptaTerminos = valor) }
    }
    fun onImagenChange(uri: Uri?) {
        _uiState.update { it.copy(imagenUri = uri) }
    }
    fun validarFormulario(): Boolean {
        val estadoActual = _uiState.value
        val errores = RegistroErrores(
            nombre = if (estadoActual.nombre.isBlank()) "Campo obligatorio" else null,
            correo = if (!estadoActual.correo.contains("@")) "Correo inválido" else null,
            clave = if (estadoActual.clave.length < 6) "Debe tener al menos 6 caracteres" else null
        )

        _uiState.update { it.copy(errores = errores) }

        // Retorna true si NO hay errores
        return listOfNotNull(
            errores.nombre,
            errores.correo,
            errores.clave
        ).isEmpty()
    }
}