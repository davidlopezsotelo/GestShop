package com.davidLopez.gestshop.Log

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.davidLopez.gestshop.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


//https://www.youtube.com/watch?v=XMylQ1cxpFM&list=PLhcYacorV7U4Qsq-I9RH80mVGJ_8IyOPW&index=11&t=959s

class RegistroActivity : AppCompatActivity() {

    var Nombre=""
    var Email=""
    var Password = ""
    var RepPassword=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        setup()
    }
    private fun setup() {

        val BotonRegistro = findViewById<Button>(R.id.buttonRegistroReg)
        val BotonLogin = findViewById<Button>(R.id.button_salir_reg)//

        BotonRegistro.setOnClickListener {
            validarDatos()
        }
        BotonLogin.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
    }

    private fun validarDatos(){

        val TextoNombre = findViewById<EditText>(R.id.NombreEt)
        val TextoEmail = findViewById<EditText>(R.id.correoEt)
        val TextoContrasena = findViewById<EditText>(R.id.contrasenaEt)
        val TextoRepContrasena = findViewById<EditText>(R.id.RepContrasenaEt)

        Nombre=TextoNombre.text.toString()
        Email=TextoEmail.text.toString()
        Password=TextoContrasena.text.toString()
        RepPassword=TextoRepContrasena.text.toString()



        if (TextUtils.isEmpty(Nombre)){
            Toast.makeText(this, "Ingrese nombre",Toast.LENGTH_SHORT).show()
        }else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            Toast.makeText(this,"Ingrese direccion de email",Toast.LENGTH_SHORT).show()
        }else  if (TextUtils.isEmpty(Password)){
            Toast.makeText(this, "Ingrese contraseña ",Toast.LENGTH_SHORT).show()
        }else  if (TextUtils.isEmpty(RepPassword)){
            Toast.makeText(this, "Repita contraseña",Toast.LENGTH_SHORT).show()
        }else crearCuenta()

    }


    private fun crearCuenta() {

        //CREAR EL USUARIO EN FIREBASE

        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(
                Email,Password
            )
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showRegistro()
                    guardarInfo()

                } else {
                    showAlert()// mensaje de alerta
                }
            }
    }

    //guardamos el usuario en la base de datos
    private fun guardarInfo() {

        val db = FirebaseFirestore.getInstance()
        db.collection("users").document(Email).set(
            hashMapOf("nombre" to Nombre,
            "correo" to Email,
            "contraseña" to Password)
        )
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



}//fin class