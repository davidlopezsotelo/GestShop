package com.davidLopez.gestshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class CuentasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuentas)

        setup()
    }

    private fun setup() {

       val botonDatos = findViewById<Button>(R.id.buttonDatos)

        botonDatos.setOnClickListener{
            descargaDatos()
        }

        // calendario-------------------------------------------------------------------------------
        val etDate=findViewById<EditText>(R.id.etDateCont)

        etDate.setOnClickListener{
            showDatePickerDialog()//crear la funcion!!!!!!
        }
    }// fin setup

    private fun descargaDatos() {//------------------------------------------------------------------------

        val textoFecha=findViewById<EditText>(R.id.etDateCont)

        val fecha=textoFecha.text.toString()
        val db = FirebaseFirestore.getInstance()



        if (fecha.isNotEmpty()){

            //crear una lista que contenga todas las entradas de la base de datos del mes seleccionado


            //llenar la lista
            //mostral la lista ordenada en cada textview

        }else Toast.makeText(this,"Debes indicar la fecha.", Toast.LENGTH_SHORT).show()
    }


    private fun showDatePickerDialog() {

        val datePicker=DatePickerFragment { dia, mes, year -> onDateSelected(dia, mes, year) }
        datePicker.show(supportFragmentManager,"datePicker")


    }//ff

    fun onDateSelected(dia:Int,mes:Int,year:Int){


        val etDate=findViewById<EditText>(R.id.etDate)

        etDate.setText( " $dia- $mes- $year")



    }//ff
}