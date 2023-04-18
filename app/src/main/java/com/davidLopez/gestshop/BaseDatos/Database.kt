package com.davidLopez.gestshop.BaseDatos

import androidx.room.RoomDatabase

@androidx.room.Database(entities = [Balances::class], version = 1)
abstract class Database:RoomDatabase() {

    abstract fun getDaoBalance():DaoBalance
}