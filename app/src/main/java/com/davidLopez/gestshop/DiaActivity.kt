package com.davidLopez.gestshop

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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

    //calcular ----------------------------------------------------------------------------------

    fun calcular(){

        val textSaldo=findViewById<EditText>(R.id.editTextSaldo_caja)
        val textIngresos=findViewById<EditText>(R.id.editTextIngresos)
        val textGasto=findViewById<EditText>(R.id.editTextGastos)
        val textResultado=findViewById<TextView>(R.id.textResultado)

        var saldo=0.00
        var ingresos=0.00
        var gastos=0.00
        var resultado=0.00


        saldo= textSaldo.text.toString().toDouble()
        ingresos= textIngresos.text.toString().toDouble()
        gastos= textGasto.text.toString().toDouble()
        resultado=saldo+ingresos-gastos

        textResultado.setText(" "+resultado)
    }




}//Fin class