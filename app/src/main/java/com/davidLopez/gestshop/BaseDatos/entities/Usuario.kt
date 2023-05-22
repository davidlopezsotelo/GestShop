package com.davidLopez.gestshop.BaseDatos.entities

import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "usuarios",
    indices = [
        Index(value = ["nombre"], unique = true)
    ]
)
data class Usuario(val nombre: String, val password: String? = "" ): BaseEntity()