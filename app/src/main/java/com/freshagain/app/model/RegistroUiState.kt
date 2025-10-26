package com.freshagain.app.model

import android.net.Uri // <- Importar

data class RegistroUiState(
    val nombre: String = "",
    val correo: String = "",
    val clave: String = "",
    val aceptaTerminos: Boolean = false,
    val errores: RegistroErrores = RegistroErrores(),
    val imagenUri: Uri? = null // <- Añadir esta línea
)