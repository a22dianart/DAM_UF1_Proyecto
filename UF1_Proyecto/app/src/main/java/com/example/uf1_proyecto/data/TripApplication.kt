package com.example.uf1_proyecto.data
import android.app.Application



class TripApplication : Application(){
    val database: TripRoomDatabase by lazy { TripRoomDatabase.getDatabase(this) }

}