package com.freshagain.app.ui.utils

import androidx.activity.compose.LocalActivity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable

/**
 * Función utilitaria para obtener la clase de tamaño de ventana (WindowSizeClass).
 * Calcula si la pantalla es Compacta, Mediana o Expandida
 */
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun obtenerWindowSizeClass(): WindowSizeClass {
    return calculateWindowSizeClass(LocalActivity.current as android.app.Activity)
}