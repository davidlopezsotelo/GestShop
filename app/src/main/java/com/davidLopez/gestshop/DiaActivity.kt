package com.davidLopez.gestshop

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class DiaActivity : AppCompatActivity() {//Fin class
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dia)

        setup()
    }


    private fun setup(){

        // variables para definir botones

        val botonResultado=findViewById<Button>(R.id.buttonResultado)
       // val botonGuardar=findViewById<Button>(R.id.buttonGuardaDia)
        val botonMenu=findViewById<Button>(R.id.buttonMenu)

        // calendario-------------------------------------------------------------------------------
        val etDate=findViewById<EditText>(R.id.etDate)

        etDate.setOnClickListener{
            showDatePickerDialog()//crear la funcion!!!!!!
        }


        botonMenu.setOnClickListener{
            val i= Intent(this,MenuActivity::class.java)
            startActivity(i)
            finish()
        }

        botonResultado.setOnClickListener {
            calcular()
        }

        /*botonGuardar.setOnClickListener{
            val i=Intent(this,GuardarActivity::class.java)
            startActivity(i)
            guardar()

        }*/



    } //fin setup(

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

    //calcular ----------------------------------------------------------------------------------

    private fun calcular(){

        val textoFecha=findViewById<EditText>(R.id.etDate)
        val textSaldo=findViewById<EditText>(R.id.editTextSaldo_caja)
        val textIngresos=findViewById<EditText>(R.id.editTextIngresos)
        val textGasto=findViewById<EditText>(R.id.editTextGastos)
        val textResultado=findViewById<TextView>(R.id.textResultado)
        val fecha=textoFecha.text.toString()

        var saldo=0.00
        var ingresos=0.00
        var gastos=0.00
        var resultado=0.00


        if (fecha.isNotEmpty()) {

            saldo = textSaldo.text.toString().toDouble()
            ingresos = textIngresos.text.toString().toDouble()
            gastos = textGasto.text.toString().toDouble()
            resultado = (saldo + ingresos - gastos)
            //redondeamos a dos decimales:
            val df= DecimalFormat("#.##")
            df.roundingMode = RoundingMode.DOWN
            val roundoff = df.format(resultado)

            textResultado.setText(" "+ roundoff)

        }else{
            Toast.makeText(this,"Deves indicar la fecha.", Toast.LENGTH_SHORT).show()
        }



        //Shared preference para conservar los datos al volver a la vista

        //sobreescribir el metodo onPause() donde  se ejecutara el shared:






        val botonGuardar=findViewById<Button>(R.id.buttonGuardaDia)
        botonGuardar.setOnClickListener{

            if (fecha.isNotEmpty()) {
                //guardamos los datos en un binding
                val intent = Intent(this, GuardarActivity::class.java)
                intent.putExtra("date", fecha)
                intent.putExtra("saldo", saldo)
                intent.putExtra("ingresos", ingresos)
                intent.putExtra("gastos", gastos)
                intent.putExtra("resultado", resultado)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Deves indicar la fecha.", Toast.LENGTH_SHORT).show()
            }
        }

    }





}