package com.davidLopez.gestshop.Log

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidLopez.gestshop.BaseDatos.entities.Usuario
import com.davidLopez.gestshop.app.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsuarioViewModel:ViewModel() {
    private val db = App.getUsuario()

    fun save(usuario: Usuario): MutableLiveData<Boolean> {
        val data = MutableLiveData<Boolean>()
        viewModelScope.launch {
            try {
                val id = withContext(Dispatchers.IO) {
                    //db.usuarioDao().save(usuario)
                }
                //usuario.id = id
                App.saveUser(usuario)
                data.value = true
            } catch (ex: SQLiteConstraintException) {
                data.value = false
            }
        }
        return data
    }

    fun login(usuario: Usuario): MutableLiveData<Result> {
        val data = MutableLiveData<Result>()
        viewModelScope.launch {
            /*try {
                val usuarioFromDB: Usuario? = withContext(Dispatchers.IO) {
                    db.usuarioDao().findOneByName(usuario.nombre)
                }
                usuarioFromDB?.let {
                    if (it.password == usuario.password) {
                        App.saveUser(usuarioFromDB)
                        data.value = Result(true)
                    } else
                        data.value = Result(false, "Revisa los datos introducidos")
                } ?: run {
                    data.value = Result(false, "Revisa los datos introducidos")
                }
            } catch (ex: SQLiteConstraintException) {
                data.value = Result(false, "Revisa los datos introducidos")
            }*/

        }

        return data
    }
}

data class Result(val result: Boolean, val msg: String = "")
