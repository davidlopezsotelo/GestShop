package com.davidLopez.gestshop.app

import android.app.Application
import android.content.Context
import android.util.Log
import com.davidLopez.gestshop.BaseDatos.MyDatabase
import com.davidLopez.gestshop.BaseDatos.entities.Usuario

class App :Application() {
    init {
        instancia = this

    }

    companion object {
        private lateinit var instancia: App

        fun saveUser(usuario: Usuario) {
            val prefs =
                instancia.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE)!!
            prefs.edit().apply {
                putLong(Constantes.USUARIO_ID, usuario.id)
                putString(Constantes.USUARIO_NOMBRE, usuario.nombre)
            }.apply()

        }

        fun getUsuario(): Usuario? {
            val prefs =
                instancia.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE)!!

            val id =prefs.getLong(Constantes.USUARIO_ID, 0)

            val nombre = prefs.getString(Constantes.USUARIO_NOMBRE, null)
            nombre?.let {
                return Usuario(it).apply {
                    this.id
                }
            }
            return null
        }

        fun clear() {
            val prefs =
                instancia.getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE)!!
            val edit = prefs.edit()!!
            edit.clear().apply()
        }

        private lateinit var db: MyDatabase

        fun getDatabase(): MyDatabase {
            return db
        }

    }//Fin companion objet




    override fun onCreate() {
        super.onCreate()
        db = MyDatabase.initDB(this)
        if (db.isOpen) {
            Log.d("Database", "DATABASE OPENED")
        }
    }






}