package com.freshagain.app.model

data class Prenda(
    val id: Long? = null,
    val titulo: String,
    val descripcion: String,
    val precio: Int,
    val imagenUrl: String = ""
)