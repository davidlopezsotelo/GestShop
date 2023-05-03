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


     @Query("Select * from balances WHERE anio LIKE :anio AND mes LIKE:mes ORDER BY dia ASC")
     fun getDatosFecha(anio:Int,mes:Int):Balances
     //TODO()
     /*
     SEGUIR DESDE AQUI PARA MOSTRAR LOS DATOS POR PANTALLA
      */

     @Insert()
     fun insertDia(balance:Balances)

     @Delete()
     fun borrarDia(balance: Balances)



}