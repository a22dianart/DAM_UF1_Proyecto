package com.example.uf1_proyecto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Trip(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val itemName: String,
    @ColumnInfo(name = "photo")
    val photo: String,
    @ColumnInfo(name = "activities")
    var activities: List<String>?,
    @ColumnInfo(name = "dayStart")
    var dayStart: Int?,
    @ColumnInfo(name = "monthStart")
    var monthStart: Int?,
    @ColumnInfo(name = "yearStart")
    var yearStart: Int?,
    @ColumnInfo(name = "dayEnd")
    var dayEnd: Int?,
    @ColumnInfo(name = "monthEnd")
    var monthEnd: Int?,
    @ColumnInfo(name = "yearEnd")
    var yearEnd: Int?,
    @ColumnInfo(name = "transport")
    var transport: String?,
    @ColumnInfo(name = "stay")
    var stay: String?,
    @ColumnInfo(name = "notes")
    var notes: String?
)
