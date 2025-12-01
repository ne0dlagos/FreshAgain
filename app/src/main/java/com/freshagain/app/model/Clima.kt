package com.freshagain.app.model

import com.google.gson.annotations.SerializedName

data class ClimaResponse(
    @SerializedName("current_weather")
    val currentWeather: CurrentWeather
)

data class CurrentWeather(
    val temperature: Double,
    val windspeed: Double,
    val weathercode: Int
)