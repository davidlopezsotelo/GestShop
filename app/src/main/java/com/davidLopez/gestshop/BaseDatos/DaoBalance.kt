package com.davidLopez.gestshop.BaseDatos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoBalance {

    @Query("SELECT * FROM Balances ORDER BY fecha ASC")
     fun getAllDatos():List<Balances>

     @Insert()
     fun insert(balance:List<Balances>)

}