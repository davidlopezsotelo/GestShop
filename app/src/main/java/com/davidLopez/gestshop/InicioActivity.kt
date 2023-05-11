package com.davidLopez.gestshop

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.davidLopez.gestshop.Log.LoginActivity
import com.davidLopez.gestshop.Log.RegistroActivity
import com.davidLopez.gestshop.UI.MenuActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private lateinit var auth: FirebaseAuth
class InicioActivity : AppCompatActivity() {

    //lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)


        auth= Firebase.auth

        setup()
    }





    private fun setup(){

//TODO ENLAZAR MODELO CON LIVE DATA

       // viewModel=ViewModelProvider(this).get()
       // viewModel.iniciar()

        val botonEntrar=findViewById<Button>(R.id.buttonEntrar)
        val botonRegistro=findViewById<Button>(R.id.buttonRegistroIni)
        val botonSalir=findViewById<Button>(R.id.button_salir)

        botonEntrar.setOnClickListener{
            VerificarUsuario()

        }

        botonRegistro.setOnClickListener{
            val i=Intent(this, RegistroActivity::class.java)
            startActivity(i)

        }

        botonSalir.setOnClickListener{
            //creamos el alert Dialog
            val dialog= AlertDialog.Builder(this)
            //creamos el mensaje que aparecera
            dialog.setMessage("Quieres salir de GestShop ???")
                //si el dialog es cancelable
                .setCancelable(false)
                //accion y texto del boton positivo
                .setPositiveButton("SI", DialogInterface.OnClickListener{ dialog, id->salir()})
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

    private fun salir() {
        FirebaseAuth.getInstance().signOut()
        finish()
    }


//si el usuario tiene sesion abierta, te manda al menu principal

    fun VerificarUsuario(){
        //FirebaseUser = FirebaseAuth.getInstance().currentUser!!

        val user = Firebase.auth.currentUser
        if (user != null) {
            // User is signed in
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        } else {
            // No user is signed in
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }

}