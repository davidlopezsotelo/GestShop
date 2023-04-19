package com.davidLopez.gestshop.DataBase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.davidLopez.gestshop.R
import com.davidLopez.gestshop.UI.MenuActivity
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
        val saldo=datos.getDouble("saldo").toString()
        val ingresos=datos.getDouble("ingresos").toString()
        val gastos=datos.getDouble("gastos").toString()
        val resultado=datos.getDouble("resultado").toString()
        val saldoFinal=datos.getDouble("Saldo final").toString()

        val dia=datos.getInt("miDia")
        val mes=datos.getInt("miMes")
        val year=datos.getInt("miYear")





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

                        "fecha" to fecha,
                        "saldo inicial" to saldo,
                        "ingresos" to ingresos,
                        "gastos" to gastos,
                        "resultado" to resultado,
                        "saldo final" to saldoFinal,

                        "dia " to dia,
                        "mes" to mes,
                        "año" to year


                    )
                )
                Toast.makeText(this, "ENTRADA GUARDADA", Toast.LENGTH_SHORT).show()
            }else Toast.makeText(this,"ERROR AL GUARDAR LOS DATOS",Toast.LENGTH_SHORT)

            }

        botonMenu.setOnClickListener{
            val i=Intent(this, MenuActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}