package com.davidLopez.gestshop.BaseDatos.DAOs

import androidx.room.Dao
import androidx.room.Query
import com.davidLopez.gestshop.BaseDatos.entities.Usuario

@Dao
interface UsuarioDao: BaseDao<Usuario> {

    @Query("SELECT * from usuarios where nombre = :nombre")
    fun findOneByName(nombre: String): Usuario?
}