package com.davidLopez.gestshop.BaseDatos

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLite (context: Context) : SQLiteOpenHelper(context,"GestShop.db",null,1) {

    //creamos un companion objet para que no halla errores al introducir los datos

    companion object {

        val TABLA_USUARIOS ="usuarios"
        val CAMPO_ID ="_id"
        val CAMPO_NOMBRE ="nombre"
        val CAMPO_EMAIL ="email"

        val CAMPO_PASWORD ="pasword"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        //creamos usuario

       val creacionUsuario ="CREATE TABLE ${TABLA_USUARIOS}" +
                "(${CAMPO_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${CAMPO_NOMBRE} TEXT, ${CAMPO_EMAIL} TEXT, ${CAMPO_PASWORD} TEXT)"

        db!!.execSQL(creacionUsuario)
    }

    //borrar tabla usuarios

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val borrarUsuario ="DROP TABLE IF EXISTS ${TABLA_USUARIOS}"

        db!!.execSQL(borrarUsuario)
        onCreate(db)
    }

    // funcion para insertar usuario en base de datos

    fun insertUsuario(nombre:String,email:String,pasword:String){
        val datos = ContentValues()
        datos.put(CAMPO_NOMBRE,nombre)
        datos.put(CAMPO_EMAIL,email)
        datos.put(CAMPO_PASWORD,pasword)

        val db=this.writableDatabase
        db.insert(TABLA_USUARIOS,null,datos)
        db.close()
    }

    // funcion para borrar usuario

    fun borrarUsuario(id:Int): Int {

        val args = arrayOf(id.toString())

        val db=this.writableDatabase
        val borrados=db.delete(TABLA_USUARIOS,"${CAMPO_ID}=?",args)

        db.close()
        return borrados
    }// ff

    // funcion para modificar usuario

    fun modificarUsuario(id:Int,nombre:String,email:String,pasword:String){

        val args = arrayOf(id.toString())

        val datos =ContentValues()

        datos.put(CAMPO_NOMBRE,nombre)
        datos.put(CAMPO_EMAIL,email)
        datos.put(CAMPO_PASWORD,pasword)

        val db=this.writableDatabase
        db.update(TABLA_USUARIOS,datos,"${CAMPO_ID}=?",args)
        db.close()
    }





}