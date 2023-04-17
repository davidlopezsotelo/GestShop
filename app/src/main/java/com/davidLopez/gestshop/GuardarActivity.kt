package com.davidLopez.gestshop

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class GuardarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guardar)

        setup()
    }

    private fun setup() {

        val botonGuardar=findViewById<Button>(R.id.button_guardar_resultado)
        val botonMenu=findViewById<Button>(R.id.button_menu_resumen)


        //introducir datos desde activity dia------------------------------------------------------

        val datos=intent.extras

        var fecha=datos!!.getString("date")
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

            // crear instancia en la base de datos

                val db = FirebaseFirestore.getInstance()

            if ( fecha!= null) {
                db.collection("contabilidad").document(fecha).set(
                    hashMapOf(
                        "saldo inicial" to saldo,
                        "ingresos" to ingresos,
                        "gastos" to gastos,
                        "resultado" to resultado,
                        "saldo final" to saldoFinal
                    )
                )
                Toast.makeText(this, "ENTRADA GUARDADA", Toast.LENGTH_SHORT).show()
            }else Toast.makeText(this,"ERROR AL GUARDAR LOS DATOS",Toast.LENGTH_SHORT)

            }

        botonMenu.setOnClickListener{
            val i=Intent(this,MenuActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}