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
data class Balances(

    // se construyen las columnas:

    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val fecha: String,
    val ingresos: Double,
    val gastos: Double,
    val resultado: Double,
    //***********************************************************************
    /*
    creo los dias para seleccionar cada archivo for fecha y luego
    mostrarlo por dia mes, mes o resumen mensual de año
     */
    val dia: Int,
    val mes: Int,
    val anio: Int,
    )


