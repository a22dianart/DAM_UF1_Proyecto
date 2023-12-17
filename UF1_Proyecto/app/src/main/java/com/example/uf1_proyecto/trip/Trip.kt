package com.example.uf1_proyecto.trip



data class Trip(
    val id: Int = 0,
    val name: String,
    val photo: String,
    var activities: List<String>,
    var selected1Activity: Int?=null,
    var selected2Activity: Int?=null,
    var selected3Activity: Int?=null,
    var selected4Activity: Int?=null,
    var selected5Activity: Int?=null,
    var selected6Activity: Int?=null,
    var dayStart: Int?=null,
    var monthStart: Int?=null,
    var yearStart: Int?=null,
    var dayEnd: Int?=null,
    var monthEnd: Int?=null,
    var yearEnd: Int?=null,
    var transport: Int?=null,
    var stay: String?=null,
    var notes: String?=null
)
