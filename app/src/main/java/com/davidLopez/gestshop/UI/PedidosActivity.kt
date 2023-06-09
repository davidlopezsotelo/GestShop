package com.davidLopez.gestshop.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.davidLopez.gestshop.R

class PedidosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)

        setup()
    }

    private fun setup(){

        val botonMenu=findViewById<Button>(R.id.buttonMenuPedidos)

        botonMenu.setOnClickListener{
            val i=Intent(this, MenuActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}