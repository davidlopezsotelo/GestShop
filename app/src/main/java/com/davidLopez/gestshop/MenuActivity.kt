package com.davidLopez.gestshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        setup()

    }

    private fun setup() {
        //botones-----------------------------------------------------------------------------------

        val botonAbrirdia=findViewById<Button>(R.id.button_abrirdia)
        val botonCuentas=findViewById<Button>(R.id.button_cuentas)
        val botonPedidos=findViewById<Button>(R.id.button_pedidos)
        val botonAgenda=findViewById<Button>(R.id.button_agenda)
        val botonSalir=findViewById<Button>(R.id.button_salir_menu)

        botonAbrirdia.setOnClickListener{
            val i =Intent(this,DiaActivity::class.java)
            startActivity(i)
            finish()
        }

    }


}