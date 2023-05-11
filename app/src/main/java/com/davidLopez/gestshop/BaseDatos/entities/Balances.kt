package com.davidLopez.gestshop.BaseDatos.entities

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
    var id:Int,

    @ColumnInfo(name = "fecha")
    var fecha: String,//cambiar a date??

    @ColumnInfo(name = "ingresos")
    var ingresos: Double,

    @ColumnInfo(name = "gastos")
    var gastos: Double,

    @ColumnInfo(name = "resultado")
    var resultado: Double,

    //***********************************************************************
    /*
    creo los dias para seleccionar cada archivo for fecha y luego
    mostrarlo por dia mes, mes o resumen mensual de año
     */

    @ColumnInfo(name = "dia")
    @Nonnull
    var dia: Int,


    @ColumnInfo(name = "mes")
    @Nonnull
    var mes: Int,


    @ColumnInfo(name = "anio")
    @Nonnull
    var anio: Int,
    )

