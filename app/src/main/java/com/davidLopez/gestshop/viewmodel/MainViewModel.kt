package com.davidLopez.gestshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidLopez.gestshop.BaseDatos.App.Companion.db

import com.davidLopez.gestshop.BaseDatos.Balances
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel:ViewModel() {
    val balancesList=MutableLiveData<List<Balances>>()
    var parametroBusqueda=MutableLiveData<String>()


    //https://www.youtube.com/watch?v=2oKaBiR_Vws&list=PLnGrQz5b3ksbSE3NmpFnEyJ1KwEdgeVDi&index=4

    fun iniciar(){

        viewModelScope.launch {
            var result= withContext(Dispatchers.IO){
                db.daoBalance().insertDia(arrayListOf<Balances>(
                    Balances(0,"12-5-2023",800.00,200.00,152.00,12,5,2023)
                ))
            }
        }
    }
}