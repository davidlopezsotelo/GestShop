package com.davidLopez.gestshop.DataBase

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.davidLopez.gestshop.DatePickerFragment
import com.davidLopez.gestshop.R
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class InformesActivity : AppCompatActivity() {

    val db = Firebase.firestore

    var miDia = 0
    var miMes = 0
    var miYear = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informes)

        setup()
    }

    private fun setup() {

        // calendario--------------------------------------
        val etDate = findViewById<EditText>(R.id.etDate_info)

        etDate.setOnClickListener {
            showDatePickerDialog()//crear la funcion!!!!!!
        }


    }//ff

    // CALENDARIO-----------------------------------------------------------------------------------
    //funcion que inicializara el calendario
    private fun showDatePickerDialog() {

        val datePicker = DatePickerFragment { dia, mes, year -> onDateSelected(dia, mes, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }//ff

// funcion que selecciona fecha

    fun onDateSelected(dia: Int, mes: Int, year: Int) {

        val etDate = findViewById<EditText>(R.id.etDate_info)
        miDia = dia
        miMes = mes
        miYear = year


       etDate.setText(" $dia- $mes- $year")

        muestraMes()
        muestraAnio()
        informeMes()
        informeAnio()

    }//ff

    @SuppressLint("SetTextI18n")
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

    fun informeMes() {

        val etDate = findViewById<EditText>(R.id.etDate_info)
        val etDia = findViewById<TextView>(R.id.etDia)
        val etIngresos = findViewById<TextView>(R.id.etIngresos)
        val etGastos = findViewById<TextView>(R.id.etGastos)
        val etTotal = findViewById<TextView>(R.id.etTotal)

        var fecha = etDate.text.toString()

//----------------------------para mostrar el dia del mes-------------------------------------------ok
        val informeDia = db.collection("contabilidad").whereEqualTo("mes", miMes)
        informeDia.get().addOnSuccessListener { resultado ->

            var arraydia = ArrayList<String>()

            for (documento in resultado) {
               arraydia.add(documento["dia "].toString())// poner bien la variable
            }

            // creamos un StringBuilder para mostrar los elementos de forma vertical
            val stringBuilder=StringBuilder()

            for (element in arraydia){
                stringBuilder.append(element).append("\n")
            }
            etDia.text= stringBuilder.toString()
        }

//----------------------------para mostrar los ingresos del mes-------------------------------------------
        val informeIngresos = db.collection("contabilidad").whereEqualTo("mes", miMes)
        informeIngresos.get().addOnSuccessListener { resultado ->

            var ingresos = ArrayList<String>()
            for (documento in resultado) {
                ingresos.add( documento["ingresos"].toString())
            }

            // creamos un StringBuilder para mostrar los elementos de forma vertical
            val stringBuilder=StringBuilder()

            for (element in ingresos){
                stringBuilder.append(element).append("\n")
            }
            etIngresos.text= stringBuilder.toString()
        }

//----------------------------para mostrar los gastos  del mes-------------------------------------------
        val informeGastos = db.collection("contabilidad").whereEqualTo("mes", miMes)
        informeGastos.get().addOnSuccessListener { resultado ->
            var gastos = ArrayList<String>()
            for (documento in resultado) {
                gastos.add(documento["gastos"].toString())
            }

            // creamos un StringBuilder para mostrar los elementos de forma vertical
            val stringBuilder=StringBuilder()

            for (element in gastos){
                stringBuilder.append(element).append("\n")
            }
            etGastos.text= stringBuilder.toString()
        }


//----------------------------para mostrar los resultados  del mes-------------------------------------------

        val informeResultados = db.collection("contabilidad").whereEqualTo("mes", miMes)

        informeResultados.get().addOnSuccessListener { resultado ->
            var resultados = ArrayList<String>()
            for (documento in resultado) {
                resultados.add(documento["resultado"].toString())
            }

            // creamos un StringBuilder para mostrar los elementos de forma vertical
            val stringBuilder=StringBuilder()

            for (element in resultados){
                stringBuilder.append(element).append("\n")
            }
            etTotal.text= stringBuilder.toString()
        }
    }

//-----------------muestra solo la fecha seleccionada-------------------------------------
    /*
        val infoMes=db.collection("contabilidad").document(fecha)

        infoMes.get().addOnSuccessListener {
            etFecha.text = it.get("miMes")as String?
            etIngresos.text = it.get("ingresos")as String?
            etGastos.text = it.get("gastos")as String?
            etTotal.text = it.get("resultado")as String?
        }*/
    // -----------------mostrat todas las entradas del mes seleccionad-------------

    /*        val muetraMesTotal =db.collection("contabilidad").whereEqualTo("mes",miMes)

        val texREsumen=findViewById<TextView>(R.id.textResum)

        muetraMesTotal.get().addOnSuccessListener {resultado ->
            var datas=""
            for (documento in resultado){

            datas += "${documento.id}: ${documento.data}\n"
            }
            texREsumen.text=datas
        }*/


    // hacer selec en la base de datos sobre el mes seleccionado y
    //  guardar los datos en un array o list

    // bucle for que recorre los dias del mes (array)
    // y los pinta en los texview de forma dinamica


    fun muestraAnio() { //
        val anio = findViewById<TextView>(R.id.movYear)

        anio.text = "TOTAL MOVIMIENTOS AÑO: $miYear"
    }


    fun informeAnio() {

        val etDate = findViewById<EditText>(R.id.etDate_info)
        val etFecha = findViewById<TextView>(R.id.etMesAnio)
        val etIngresos = findViewById<TextView>(R.id.etIngresosAnio)
        val etGastos = findViewById<TextView>(R.id.etGastos2)
        val etTotal = findViewById<TextView>(R.id.etTotalAnio)

        var fecha = etDate.text.toString()


        /*   val infoMes=db.collection("contabilidad").document(fecha)

        infoMes.get().addOnSuccessListener {
            etFecha.text = it.get("miMes")as String?
            etIngresos.text = it.get("ingresos")as String?
            etGastos.text = it.get("gastos")as String?
            etTotal.text = it.get("resultado")as String?

        }*/

    }
}

