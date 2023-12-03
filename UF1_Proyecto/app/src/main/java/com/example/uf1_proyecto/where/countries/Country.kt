package com.example.uf1_proyecto.where.countries

data class Country(
    val name: String,
    val photo: String,
    val description: String,
    val activities: List<String>,
    val places: List<String>,
    val typical: List<String>,
    val languages: String
)