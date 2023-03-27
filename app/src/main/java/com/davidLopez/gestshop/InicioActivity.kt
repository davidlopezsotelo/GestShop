package com.davidLopez.gestshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)


        setup()
    }

    private fun setup(){
        val botonInicio=findViewById<Button>(R.id.buttonInicio)
        val botonSalir=findViewById<Button>(R.id.button_salir)

        botonInicio.setOnClickListener{
            val i=Intent(this,MenuActivity::class.java)
            startActivity(i)
            finish()
        }
        botonSalir.setOnClickListener{
            finish()
        }
    }


    // funciones de los botones

}