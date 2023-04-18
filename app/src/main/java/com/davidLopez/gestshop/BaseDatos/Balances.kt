package com.davidLopez.gestshop.BaseDatos

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity
data class Balances (
    @PrimaryKey(autoGenerate = true)
    val Id:Int,
    val fecha:Date,
    val ingresos:Double,
    val gastos:Double,
    val resultado:Double
        )


