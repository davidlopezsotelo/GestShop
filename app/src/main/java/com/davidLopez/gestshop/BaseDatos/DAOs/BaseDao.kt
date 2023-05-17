package com.davidLopez.gestshop.BaseDatos.DAOs

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao <T> {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun save(t: T): Long

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertAll(vararg t: T)

    @Delete
    fun delete(t: T)

    @Update
    fun update(t: T)
}