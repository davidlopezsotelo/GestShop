package com.davidLopez.gestshop.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.davidLopez.gestshop.R

class AgendaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        setup()
    }

    private fun setup(){
        val botonMenu=findViewById<Button>(R.id.buttonMenuAgenda)

        botonMenu.setOnClickListener{
            val i= Intent(this, MenuActivity::class.java)
            finish()
        }

    }
}