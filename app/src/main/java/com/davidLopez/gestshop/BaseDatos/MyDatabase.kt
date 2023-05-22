package com.davidLopez.gestshop.BaseDatos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.davidLopez.gestshop.BaseDatos.DAOs.BalanceDao
import com.davidLopez.gestshop.BaseDatos.DAOs.UsuarioDao
import com.davidLopez.gestshop.BaseDatos.entities.Balances
import com.davidLopez.gestshop.BaseDatos.entities.Usuario
import com.davidLopez.gestshop.app.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/*
creacion de la base de dastos
 */

@Database(entities = [Balances::class,Usuario::class], version = 1)
abstract class MyDatabase:RoomDatabase() {

    abstract fun daoBalance(): BalanceDao
    abstract fun usuarioDao(): UsuarioDao

    companion object {
        private lateinit var db: MyDatabase

        fun initDB(context: Context): MyDatabase {
            if (!this::db.isInitialized) { //Singleton
                db = Room.databaseBuilder(context, MyDatabase::class.java, "database-name")
                    .addCallback(callback)
                    .build()
            }
            return db
        }


        private val callback: Callback = object : Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                GlobalScope.launch {
                    withContext(Dispatchers.IO) {
                        App.getDatabase().usuarioDao().save(Usuario("david", "123456"))
                    }
                }
            }


        }

    }}
