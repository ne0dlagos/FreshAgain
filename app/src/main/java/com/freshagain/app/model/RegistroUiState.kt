package com.freshagain.app.model

data class RegistroUiState(
    val nombre: String = "",
    val correo: String = "",
    val clave: String = "",
    val aceptaTerminos: Boolean = false,
    val errores: RegistroErrores = RegistroErrores()
)