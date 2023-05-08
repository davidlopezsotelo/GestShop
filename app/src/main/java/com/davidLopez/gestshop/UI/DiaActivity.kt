package com.davidLopez.gestshop.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.davidLopez.gestshop.BaseDatos.Database
import com.davidLopez.gestshop.DatePickerFragment
import com.davidLopez.gestshop.R
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.properties.Delegates

class DiaActivity : AppCompatActivity() {//Fin class
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dia)

        setup()
    }

    lateinit var room: Database

    var miDia = 0
    var miMes=0
    var miYear=0


    private fun setup(){

        // variables para definir botones

        val botonResultado=findViewById<Button>(R.id.buttonResultado)
        val botonMenu=findViewById<Button>(R.id.buttonMenu)


        // calendario-------------------------------------------------------------------------------
        val etDate=findViewById<EditText>(R.id.etDate)

        etDate.setOnClickListener{
            showDatePickerDialog()//crear la funcion!!!!!!
        }


        botonMenu.setOnClickListener{
            val i= Intent(this, MenuActivity::class.java)
            startActivity(i)
            finish()
        }

        botonResultado.setOnClickListener {
            calcular()
        }

    } //fin setup

    // CALENDARIO-----------------------------------------------------------------------------------

            //Crear la clase DatePickerDialog________________>

    //funcion que inicializara el calendario
    private fun showDatePickerDialog() {
        val datePicker= DatePickerFragment { dia, mes, year -> onDateSelected(dia, mes, year) }
        datePicker.show(supportFragmentManager,"datePicker")


    }//ff

    fun onDateSelected(dia:Int,mes:Int,year:Int){

        val etDate=findViewById<EditText>(R.id.etDate)

        miDia= dia
        miMes=mes
        miYear=year

        etDate.setText( " $dia- $mes- $year")

    }//ff

    //---------------------------------------------------------------------------------------

    // funcion para calcular -------------------------------------------------------------------------------------

    private fun calcular(){

        val textoFecha=findViewById<EditText>(R.id.etDate)
        val textSaldo=findViewById<EditText>(R.id.editTextSaldo_caja)
        val textIngresos=findViewById<EditText>(R.id.editTextIngresos)
        val textGasto=findViewById<EditText>(R.id.editTextGastos)
        val textResultado=findViewById<TextView>(R.id.textResultado)
        val textSaldoFinal=findViewById<TextView>(R.id.textNewSaldo)

        val fecha=textoFecha.text.toString()

        var saldo=0.00
        var ingresos=0.00
        var gastos=0.00
        var resultado=0.00
        var saldoFin=0.00




        if (fecha.isNotEmpty()) {

            saldo = textSaldo.text.toString().toDouble()
            ingresos = textIngresos.text.toString().toDouble()
            gastos = textGasto.text.toString().toDouble()
            resultado = ( ingresos - gastos)
            saldoFin=(saldo + resultado )

            //redondeamos a dos decimales:
            val df= DecimalFormat("#.##")
            df.roundingMode = RoundingMode.DOWN

            //enviamos los resultados a cada edit text:

            val roundoff = df.format(resultado)
            textResultado.setText(" "+ roundoff)
             //------------------------------------------------------------  REVISAR EL REDONDEO!!!!!!!!!!!!!!!!!!!!!!!!!!!
            val roundoff2=df.format(saldoFin)
            textSaldoFinal.setText(" "+ roundoff2)

        }else{
            Toast.makeText(this,"Debes indicar la fecha.", Toast.LENGTH_SHORT).show()
        }

        val botonGuardar=findViewById<Button>(R.id.buttonGuardaDia)
        botonGuardar.setOnClickListener{

            if (fecha.isNotEmpty()) {//--------BINDING----------------------------------------------

                //guardamos los datos en un binding y los pasamos a la activity guardar
                //para validar los datos y pasarlos a la BD

                val intent = Intent(this, GuardarActivity::class.java)
                intent.putExtra("date", fecha)
                intent.putExtra("saldo", saldo)
                intent.putExtra("ingresos", ingresos)
                intent.putExtra("gastos", gastos)
                intent.putExtra("resultado", resultado)
                intent.putExtra("Saldo final", saldoFin)
                intent.putExtra("miDia", miDia)
                intent.putExtra("miMes", miMes)
                intent.putExtra("miYear", miYear)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Deves indicar la fecha.", Toast.LENGTH_SHORT).show()
            }


            // guardamos los datos el la base de datos




        }
    }//ff-------------------------------------------------------------------------------------------


//
}//fin class