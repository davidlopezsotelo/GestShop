package com.davidLopez.gestshop.BaseDatos

import androidx.room.Database
import androidx.room.RoomDatabase

/*
creacion de la base de dastos
 */

@Database(entities = [Balances::class], version = 1)
abstract class Database:RoomDatabase() {

    abstract fun daoBalance():DaoBalance
}
