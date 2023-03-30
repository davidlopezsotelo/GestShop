package com.davidLopez.gestshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CuentasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuentas)

        setup()
    }

    private fun setup() {

        val botonMenu=findViewById<Button>(R.id.buttonMenuCuentas)


        botonMenu.setOnClickListener{
            val i= Intent(this,MenuActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}