package com.davidLopez.gestshop.BaseDatos

import android.app.Application
import androidx.room.Room

class App:Application() {

    companion object{
        lateinit var db:Database
    }


    override fun onCreate() {
        super.onCreate()
        db= Room.databaseBuilder(
            this,
            Database::class.java,"miBaseDatos"
        ).build()
    }
}