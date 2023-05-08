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
     fun getDatosFecha(anio:Int,mes:Int):List<Balances>



     @Insert()//?????????
     fun insertDia(fecha:String,ingresos: Double,gastos: Double,resultado: Double,
                    dia:Int,mes: Int,anio: Int): List<Balances>

     @Delete()
     fun borrarDia(balance: Balances)

}