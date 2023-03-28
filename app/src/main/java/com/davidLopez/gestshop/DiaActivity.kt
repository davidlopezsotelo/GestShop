package com.davidLopez.gestshop

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class DiaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dia)

        setup()
    }


    private fun setup(){

        // variables para definir botones

        val botonResultado=findViewById<Button>(R.id.buttonResultado)
        val botonGuardar=findViewById<Button>(R.id.buttonGuardaDia)
        val botonMenu=findViewById<Button>(R.id.buttonMenu)

        // calendario
        val etDate=findViewById<EditText>(R.id.etDate)

        etDate.setOnClickListener{
            showDatePickerDialog()//crear la funcion!!!!!!
        }


        botonMenu.setOnClickListener{
            val i= Intent(this,MenuActivity::class.java)
            startActivity(i)
            finish()
        }



    }

    // CALENDARIO--------------------------------------------------------------------------

    //Crear la clase DatePickerDialog________________>

    //funcion que inicializara el calendario
    private fun showDatePickerDialog() {

        val datePicker=DatePickerFragment { dia, mes, year -> onDateSelected(dia, mes, year) }
        datePicker.show(supportFragmentManager,"datePicker")
    }

    //funcion que realizara cuando se seleccione el dia------------------------
    fun onDateSelected(dia:Int,mes:Int,year:Int){

        val etDate=findViewById<EditText>(R.id.etDate)

        etDate.setText("Fecha: $dia/ $mes/ $year")


    }

}