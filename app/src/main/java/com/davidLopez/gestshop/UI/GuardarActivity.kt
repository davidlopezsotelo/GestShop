package com.davidLopez.gestshop.UI

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.davidLopez.gestshop.R

class GuardarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guardar)

        setup()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun setup() {

        val botonGuardar=findViewById<Button>(R.id.button_guardar_resultado)
        val botonMenu=findViewById<Button>(R.id.button_menu_resumen)


        //introducir datos desde activity dia------------------------------------------------------

        val datos=intent.extras

        val fecha=datos!!.getInt("date")
        val saldo=datos.getDouble("saldo")
        val ingresos=datos.getDouble("ingresos")
        val gastos=datos.getDouble("gastos")
        val resultado=datos.getDouble("resultado")
        val saldoFinal=datos.getDouble("Saldo final")


        //mostramos los datos en los texview correspondientes, haciendo los casting necesarios

        val valor_fecha=findViewById<TextView>(R.id.text_fecha)// as TextView
        valor_fecha.text= fecha.toString()
        val saldoInicial=findViewById<TextView>(R.id.text_saldo) //as TextView
        saldoInicial.text=(saldo.toString())
        val valor_ingresos=findViewById<TextView>(R.id.text_ingresos) //as TextView
        valor_ingresos.text=(ingresos.toString())
        val valor_gastos=findViewById<TextView>(R.id.text_gastos)// as TextView
        valor_gastos.text=(gastos.toString())
        val valor_resultado=findViewById<TextView>(R.id.text_resultado) //as TextView
        valor_resultado.text=(resultado.toString())
        val valor_saldoFinal=findViewById<TextView>(R.id.text_saldoFinal) //as TextView
        valor_saldoFinal.text=(saldoFinal.toString())


        //Guardamos datos en la base de datos-------------------------------------------------------

        botonGuardar.setOnClickListener{
            //guardar datos en room database*******************************************************
            guargar()
        }


        botonMenu.setOnClickListener{
            val i=Intent(this, MenuActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    private fun guargar() {

        val datos=intent.extras


        val fecha= datos?.getString("date")
        val ingresos= datos?.getDouble("ingresos")
        val gastos= datos?.getDouble("gastos")
        val resultado= datos?.getDouble("resultado")
//----------------------------***********************----------------------------------------------
        /*
        introducir en room
         */
        val dia= datos?.getInt("dia")
        val mes= datos?.getInt("mes")
        val anio= datos?.getInt("anio")


        var registro=ContentValues()
        registro.put("fecha",fecha)
        registro.put("ingresos",ingresos)
        registro.put("gastos",gastos)
        registro.put("resultado",resultado)
        registro.put("dia",dia)
        registro.put("mes",mes)
        registro.put("año",anio)
        //registro.put("fecha",fecha)

    }


}