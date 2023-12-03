package com.example.uf1_proyecto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Trip(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "photo")
    val photo: String,
    @ColumnInfo(name = "activities")
    var activities: List<String>? =null,
    @ColumnInfo(name = "dayStart")
    var dayStart: Int?=null,
    @ColumnInfo(name = "monthStart")
    var monthStart: Int?=null,
    @ColumnInfo(name = "yearStart")
    var yearStart: Int?=null,
    @ColumnInfo(name = "dayEnd")
    var dayEnd: Int?=null,
    @ColumnInfo(name = "monthEnd")
    var monthEnd: Int?=null,
    @ColumnInfo(name = "yearEnd")
    var yearEnd: Int?=null,
    @ColumnInfo(name = "transport")
    var transport: String?=null,
    @ColumnInfo(name = "stay")
    var stay: String?=null,
    @ColumnInfo(name = "notes")
    var notes: String?=null
)
