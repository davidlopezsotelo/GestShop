package com.davidLopez.gestshop.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.davidLopez.gestshop.DatePickerFragment
import com.davidLopez.gestshop.R


class InformesActivity : AppCompatActivity() {

    var miDia = 0
    var miMes = 0
    var miYear = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informes)

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




        if (fecha.isNotEmpty()){

            muestraMes()
            //crear una lista que contenga todas las entradas de la base de datos del mes seleccionado



            //llenar la lista
            //mostral la lista ordenada en cada textview

        }else Toast.makeText(this,"Debes indicar la fecha.", Toast.LENGTH_SHORT).show()
    }


    private fun showDatePickerDialog() {

        val datePicker= DatePickerFragment { dia, mes, year -> onDateSelected(dia, mes, year) }
        datePicker.show(supportFragmentManager,"datePicker")


    }//ff

    fun onDateSelected(dia:Int,mes:Int,year:Int){
        val etDate=findViewById<EditText>(R.id.etDate)
        miDia = dia
        miMes = mes
        miYear = year

        etDate.setText( " $dia- $mes- $year")
    }//ff

    fun muestraMes() {
        val nombreMes = findViewById<TextView>(R.id.movMes)

        when (miMes) {
            1 -> nombreMes.text = "TOTAL MOVIMIENTOS MES: ENERO"
            2 -> nombreMes.text = "TOTAL MOVIMIENTOS MES: FEBREO"
            3 -> nombreMes.text = "TOTAL MOVIMIENTOS MES: MARZO"
            4 -> nombreMes.text = "TOTAL MOVIMIENTOS MES: ABRIL"
            5 -> nombreMes.text = "TOTAL MOVIMIENTOS MES: MAYO"
            6 -> nombreMes.text = "TOTAL MOVIMIENTOS MES: JUNIO"
            7 -> nombreMes.text = "TOTAL MOVIMIENTOS MES: JULIO"
            8 -> nombreMes.text = "TOTAL MOVIMIENTOS MES: AGOSTO"
            9 -> nombreMes.text = "TOTAL MOVIMIENTOS MES: SEPTIEMBRE"
            10 -> nombreMes.text = "TOTAL MOVIMIENTOS MES: OCTUBRE"
            11 -> nombreMes.text = "TOTAL MOVIMIENTOS MES: NOVIEMBRE"
            12 -> nombreMes.text = "TOTAL MOVIMIENTOS MES: DICIEMBRE"
        }
    }
}