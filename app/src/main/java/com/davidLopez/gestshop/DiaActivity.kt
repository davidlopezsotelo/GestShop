package com.davidLopez.gestshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DiaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dia)

        setup()
    }

    private fun setup(){

        val botonResultado=findViewById<Button>(R.id.buttonResultado)
        val botonGuardar=findViewById<Button>(R.id.buttonGuardaDia)
        val botonMenu=findViewById<Button>(R.id.buttonMenu)

        botonMenu.setOnClickListener{
            val i= Intent(this,MenuActivity::class.java)
            startActivity(i)
            finish()
        }


    }
}