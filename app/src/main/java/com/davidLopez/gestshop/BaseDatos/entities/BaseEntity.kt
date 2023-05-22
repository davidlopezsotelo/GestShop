package com.davidLopez.gestshop.BaseDatos.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.*

abstract class BaseEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

}