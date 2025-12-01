package com.freshagain.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freshagain.app.data.PrendaRepository
import com.freshagain.app.model.Prenda
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PrendaViewModel(
    private val repository: PrendaRepository = PrendaRepository()
) : ViewModel() {

    private val _prendas = MutableStateFlow<List<Prenda>>(emptyList())
    val prendas: StateFlow<List<Prenda>> = _prendas.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        obtenerPrendas()
    }

    fun obtenerPrendas() {
        viewModelScope.launch {
            _isLoading.value = true
            val lista = repository.obtenerPrendas()
            _prendas.value = lista
            _isLoading.value = false
        }
    }

    fun agregarPrenda(prenda: Prenda, onSuccess: () -> Unit) {
        viewModelScope.launch {
            _isLoading.value = true
            val nueva = repository.crearPrenda(prenda)
            if (nueva != null) {
                obtenerPrendas()
                onSuccess()
            }
            _isLoading.value = false
        }
    }

    fun eliminarPrenda(id: Long) {
        viewModelScope.launch {
            val exito = repository.eliminarPrenda(id)
            if (exito) obtenerPrendas()
        }
    }
}