package com.davidLopez.gestshop

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

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
        }

        botonCuentas.setOnClickListener{
            val i =Intent(this,CuentasActivity::class.java)
            startActivity(i)
        }

        botonPedidos.setOnClickListener{
            val i =Intent(this,PedidosActivity::class.java)
            startActivity(i)
        }

        botonAgenda.setOnClickListener{
            val i =Intent(this,AgendaActivity::class.java)
            startActivity(i)
        }

        botonSalir.setOnClickListener{
           // finish()

            //creamos el alert Dialog
            val dialog=AlertDialog.Builder(this)
            //creamos el mensaje que aparecera
            dialog.setMessage("Quieres salir de GestShop ???")
            //si el dialog es cancelable
                .setCancelable(false)
            //accion y texto del boton positivo
                .setPositiveButton("SI",DialogInterface.OnClickListener{dialog,id->finish()})
            //texto y accion del boton negativo
                .setNegativeButton("NO",DialogInterface.OnClickListener{dialog, id -> dialog.cancel()})
            //creamos la caja de dialogo
            val alert=dialog.create()
            //ponemos el titulo a la caja de dialogo
            alert.setTitle("SALIR!!!!!")
            //mostrar
            alert.show()


        }



    }


}