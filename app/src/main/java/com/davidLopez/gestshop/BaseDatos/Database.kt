package com.davidLopez.gestshop.BaseDatos

import androidx.room.RoomDatabase

/*

creacion de la base de dastos

 */

@androidx.room.Database(entities = [Balances::class], version = 1)
abstract class Database:RoomDatabase() {

    abstract fun getDaoBalance():DaoBalance
}