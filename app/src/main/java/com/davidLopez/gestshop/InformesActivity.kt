package com.davidLopez.gestshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class InformesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informes)


        setup()
    }


    var miDia = 0
    var miMes=0
    var miYear=0

    private fun setup() {

        // calendario--------------------------------------
        val etDate=findViewById<EditText>(R.id.etDate_info)

        etDate.setOnClickListener{
            showDatePickerDialog()//crear la funcion!!!!!!
        }


    }//ff


    // CALENDARIO-----------------------------------------------------------------------------------



    //funcion que inicializara el calendario
    private fun showDatePickerDialog() {

        val datePicker=DatePickerFragment { dia, mes, year -> onDateSelected(dia, mes, year) }
        datePicker.show(supportFragmentManager,"datePicker")
    }//ff


    fun onDateSelected(dia:Int,mes:Int,year:Int){

        val etDate=findViewById<EditText>(R.id.etDate_info)
        miDia=dia
        miMes=mes
        miYear=year

        etDate.setText( " $dia- $mes- $year")
        muestraMes()
       // muestraAnio()

        informeMes()
        //informeAnio()


    }//ff

    fun muestraMes() {
        val nombreMes = findViewById<TextView>(R.id.movMes)


        when (miMes) {
            1 -> {
                nombreMes.setText("TOTAL MOVIMIENTOS MES: ENERO")
            }
            2 -> {
                nombreMes.setText("TOTAL MOVIMIENTOS MES: FEBREO")
            }
            3 -> {
                nombreMes.setText("TOTAL MOVIMIENTOS MES: MARZO")
            }
            4 -> {
                nombreMes.setText("TOTAL MOVIMIENTOS MES: ABRIL")
            }
            5 -> {
                nombreMes.setText("TOTAL MOVIMIENTOS MES: MAYO")
            }
            6 -> {
                nombreMes.setText("TOTAL MOVIMIENTOS MES: JUNIO")
            }
            7 -> {
                nombreMes.setText("TOTAL MOVIMIENTOS MES: JULIO")
            }
            8 -> {
                nombreMes.setText("TOTAL MOVIMIENTOS MES: AGOSTO")
            }
            9 -> {
                nombreMes.setText("TOTAL MOVIMIENTOS MES: SEPTIEMBRE")
            }
            10 -> {
                nombreMes.setText("TOTAL MOVIMIENTOS MES: OCTUBRE")
            }
            11 -> {
                nombreMes.setText("TOTAL MOVIMIENTOS MES: NOVIEMBRE")
            }
            12 -> {
                nombreMes.setText("TOTAL MOVIMIENTOS MES: DICIEMBRE")
            }
        }
    }


    fun muestraAnio(){
      val anio=findViewById<EditText>(R.id.movYear)

      anio.setText("TOTAL MOVIMIENTOS AÑO: $miYear")
    }
    // funcion que muestra los movimientos mensuales

    fun informeMes(){

        val db=Firebase.firestore

        val etDate=findViewById<EditText>(R.id.etDate_info)

        val etFecha=findViewById<TextView>(R.id.etFecha)
        val etIngresos=findViewById<TextView>(R.id.etIngresos)
        val etGastos=findViewById<TextView>(R.id.etGastos)
        val etTotal =findViewById<TextView>(R.id.etTotal)

        var fecha=etDate.text.toString()

//-----------------muestra  fecha seleccionada-------------------------------------
        val infoMes=db.collection("contabilidad").document(fecha)

        infoMes.get().addOnSuccessListener {
            etFecha.setText(it.get("fecha")as String?)
            etIngresos.setText(it.get("ingresos")as String?)
            etGastos.setText(it.get("gastos")as String?)
            etTotal.setText(it.get("resultado")as String?)

        }

        // -----------------mostrat todas las entradas del mes seleccionado-------------



    }


    // funcion que muestra los movimentos anuales

    fun informeAnio(){


    }
}