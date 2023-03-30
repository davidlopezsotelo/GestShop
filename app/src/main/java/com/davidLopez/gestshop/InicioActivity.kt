package com.davidLopez.gestshop

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)


        setup()
    }

    private fun setup(){
        val botonLogin=findViewById<Button>(R.id.buttonLogin)
        val botonRegistro=findViewById<Button>(R.id.buttonRegistro)
        val botonSalir=findViewById<Button>(R.id.button_salir)

        botonLogin.setOnClickListener{
            val i=Intent(this,LoginActivity::class.java)
            startActivity(i)
            finish()
        }

        botonRegistro.setOnClickListener{
            val i=Intent(this,RegistroActivity::class.java)
            startActivity(i)
            finish()
        }

        botonSalir.setOnClickListener{
            //creamos el alert Dialog
            val dialog= AlertDialog.Builder(this)
            //creamos el mensaje que aparecera
            dialog.setMessage("Quieres salir de GestShop ???")
                //si el dialog es cancelable
                .setCancelable(false)
                //accion y texto del boton positivo
                .setPositiveButton("SI", DialogInterface.OnClickListener{ dialog, id->finish()})
                //texto y accion del boton negativo
                .setNegativeButton("NO", DialogInterface.OnClickListener{ dialog, id -> dialog.cancel()})
            //creamos la caja de dialogo
            val alert=dialog.create()
            //ponemos el titulo a la caja de dialogo
            alert.setTitle("SALIR!!!!!")
            //mostrar
            alert.show()
        }
    }


    // funciones de los botones

}