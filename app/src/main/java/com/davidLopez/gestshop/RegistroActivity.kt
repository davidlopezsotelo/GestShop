package com.davidLopez.gestshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private lateinit var auth: FirebaseAuth

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)



        setup()
    }

    private fun setup(){

        val BotonRegistro=findViewById<Button>(R.id.buttonRegistroReg)
        val BotonSalir=findViewById<Button>(R.id.button_salir_reg)
        val TextoNombre=findViewById<EditText>(R.id.NombreEt)
        val TextoEmail=findViewById<EditText>(R.id.correoEt)
        val TextoContraseña=findViewById<EditText>(R.id.contraseñaEt)
        val TextoRepContraseña=findViewById<EditText>(R.id.RepContraseñaEt)


        BotonRegistro.setOnClickListener{
            if (TextoNombre.text.isNotEmpty() &&TextoEmail.text.isNotEmpty()
                && TextoContraseña.text.isNotEmpty()&&TextoRepContraseña.text.isNotEmpty()
                ) {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(
                        TextoEmail.text.toString(),
                        TextoContraseña.text.toString()
                    )
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            showRegistro()

                        } else {
                            showAlert()// mensaje de alerta
                        }

                    }
            } else {
                showRellenar()
            }
        }
    }//fin setup

    //creamos una funcion que mostrara un  mensaje de alerta mediante un cuadro de dialogo----------
    private  fun showRellenar() {
        val builder= AlertDialog.Builder(this)// creamos un cuadro de dialogo

        builder.setTitle("ERROR DE AUTENTICACION!!")
        builder.setMessage("Deves de rellenar todos los campos correctamente.")
        builder.setPositiveButton("aceptar",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }

    //creamos una funcion que mostrara un  mensaje de alerta mediante un cuadro de dialogo----------
    private fun showRegistro() {

        val builder= AlertDialog.Builder(this)// creamos un cuadro de dialogo
        builder.setTitle("Registro")
        builder.setMessage("Te has registrado correctamente.")
        builder.setPositiveButton("aceptar",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }

    //creamos una funcion que mostrara un  mensaje de alerta mediante un cuadro de dialogo---------
    private fun showAlert(){

        val builder= AlertDialog.Builder(this)// creamos un cuadro de dialogo

        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error registrando al usuario.")
        builder.setPositiveButton("aceptar",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }//ff

}