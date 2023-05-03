package com.davidLopez.gestshop.BaseDatos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

/*

Define cada entidad de Room como una clase con @Entity como anotación.
 Una entidad de Room incluye campos para cada columna de la tabla correspondiente en la base de datos,
  incluidas una o más columnas que conforman la clave primaria.

*/

@Entity
data class Balances(

    // se construyen las columnas:

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val Id: Long=0,

    @ColumnInfo(name = "fecha")
    @Nonnull
    val fecha: String,


    @ColumnInfo(name = "ingresos")
    @Nonnull
    val ingresos: Double,


    @ColumnInfo(name = "gastos")
    @Nonnull
    val gastos: Double,


    @ColumnInfo(name = "resultado")
    @Nonnull
    val resultado: Double,

    //***********************************************************************
    /*
    creo los dias para seleccionar cada archivo for fecha y luego
    mostrarlo por dia mes, mes o resumen mensual de año
     */

    @ColumnInfo(name = "dia")
    @Nonnull
    val dia: Int,


    @ColumnInfo(name = "mes")
    @Nonnull
    val mes: Int,


    @ColumnInfo(name = "anio")
    @Nonnull
    val anio: Int,
    )


