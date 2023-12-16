package com.example.uf1_proyecto.where.cities

data class City(
    val name: String,
    val photo: String,
    val best: String,
    val country: String,
    val description: String,
    val activities: List<String>,
    val places: List<String>,
    val typical: List<String>,
    val languages: String,
    val latitude: Double,
    val longitude: Double
)