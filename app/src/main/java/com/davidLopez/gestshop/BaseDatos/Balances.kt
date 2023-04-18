package com.davidLopez.gestshop.BaseDatos

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/*

Define cada entidad de Room como una clase con @Entity como anotación.
 Una entidad de Room incluye campos para cada columna de la tabla correspondiente en la base de datos,
  incluidas una o más columnas que conforman la clave primaria.

*/

@Entity
data class Balances (

    // se construyen las columnas:

    @PrimaryKey(autoGenerate = true)
    val Id:Int,
    val fecha:Date,
    val ingresos:Double,
    val gastos:Double,
    val resultado:Double
        )


