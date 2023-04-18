package com.davidLopez.gestshop.BaseDatos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
/*
DATA ACCES OBJET

El siguiente código define un DAO llamado .
 proporciona los métodos que el resto de la app usa para interactuar con los datos de la tabla
 */
@Dao
interface DaoBalance {

    @Query("SELECT * FROM Balances ORDER BY fecha ASC")
     fun getAllDatos():List<Balances>

     @Query("Select fecha from balances")

     @Insert()
     fun insert(balance:List<Balances>)

     @Delete()
     fun borrar(balance: List<Balances>)



}