package com.davidLopez.gestshop.UI

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.davidLopez.gestshop.DataBase.InformesActivity
import com.davidLopez.gestshop.R
import com.google.firebase.auth.FirebaseAuth

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        setup()

    }

    private fun setup() {
        //botones-----------------------------------------------------------------------------------

        val botonAbrirdia=findViewById<Button>(R.id.button_abrirdia)
        val botonInformes=findViewById<Button>(R.id.button_cuentas)
        val botonPedidos=findViewById<Button>(R.id.button_pedidos)
        val botonAgenda=findViewById<Button>(R.id.button_agenda)
        val botonCerrarSesion=findViewById<Button>(R.id.button_cerrarSesion)
        val botonArchivos=findViewById<Button>(R.id.button_archivos)

        botonAbrirdia.setOnClickListener{
            val i =Intent(this, DiaActivity::class.java)
            startActivity(i)
        }

        botonInformes.setOnClickListener{
            val i =Intent(this, InformesActivity::class.java)
            startActivity(i)
        }

        botonPedidos.setOnClickListener{
            val i =Intent(this, PedidosActivity::class.java)
            startActivity(i)
        }

        botonArchivos.setOnClickListener{
            val i=Intent(this, ArchivoActivity::class.java)
            startActivity(i)
        }

        botonAgenda.setOnClickListener{
            val i =Intent(this, AgendaActivity::class.java)
            startActivity(i)
        }

        botonCerrarSesion.setOnClickListener{

            //creamos el alert Dialog

            val dialog=AlertDialog.Builder(this)

            //creamos el mensaje que aparecera

            dialog.setMessage("Quieres salir de GestShop ???")

            //si el dialog es cancelable

                .setCancelable(false)

            //accion y texto del boton positivo

                .setPositiveButton("SI",DialogInterface.OnClickListener{dialog,id->salir()})

            //texto y accion del boton negativo

                .setNegativeButton("NO",DialogInterface.OnClickListener{dialog, id -> dialog.cancel()})

            //creamos la caja de dialogo

            val alert=dialog.create()

            //ponemos el titulo a la caja de dialogo

            alert.setTitle("CERRAR SESION")

            //mostrar
            alert.show()
        }

    }
    private fun salir() {
        FirebaseAuth.getInstance().signOut()
        finish()
    }

}