package com.davidLopez.gestshop.BaseDatos.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.davidLopez.gestshop.BaseDatos.entities.Balances

/*
DATA ACCES OBJET

El siguiente código define un DAO llamado .
 proporciona los métodos que el resto de la app usa para interactuar con los datos de la tabla
 */
@Dao
interface BalanceDao {


     @Query("Select * from balances WHERE anio LIKE :anio AND mes LIKE:mes ORDER BY dia ASC")
      suspend fun getDatosFecha(anio:Int,mes:Int):List<Balances>

     @Insert(onConflict = OnConflictStrategy.IGNORE)//?????????
     fun insertDia( balance: Balances)

     @Update
     suspend fun actualizarDia(balance: Balances)

     @Delete()
     suspend fun borrarDia(balance: Balances)

}