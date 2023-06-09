package com.davidLopez.gestshop.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.davidLopez.gestshop.DataBase.GuardarActivity
import com.davidLopez.gestshop.UI.MenuActivity
import com.davidLopez.gestshop.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    //Creamos variable Firebase

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //inicializamos Firebase
        auth = Firebase.auth

        setup()
    }

    var Email=""
    var Password = ""

    private fun setup() {

        val BotonEntrar= findViewById<Button>(R.id.button_entrar)
        val BotonRegistro=findViewById<Button>(R.id.buttonRegistroLog)

        BotonEntrar.setOnClickListener{
            //hacer login en firebase
            ValidarDatos()
        }

        BotonRegistro.setOnClickListener{
            val j=Intent(this, RegistroActivity::class.java)
            startActivity(j)
            finish()
        }
    }

    private fun ValidarDatos() {

        val TextoEmailLog = findViewById<EditText>(R.id.correoEt_login)
        val TextoContrasenaLog = findViewById<EditText>(R.id.contrasenaEt_login)

        Email=TextoEmailLog.text.toString()
        Password=TextoContrasenaLog.text.toString()

        //mandamos email al activity guardar

       val intent = Intent(this, GuardarActivity::class.java)
        intent.putExtra("email" , Email)


        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){// verifica que se introduce un correo
            Toast.makeText(this,"Correo no valido.",Toast.LENGTH_SHORT).show()
        }
        else if (TextUtils.isEmpty(Password)){//verifica que se introduce un texto y no esta vacio
            Toast.makeText(this,"Ingrese contraseña.",Toast.LENGTH_SHORT).show()
        }
        else{//si las dos anteriores condiciones se cumplen ejecuta la funcion
            LoginUsuario()
        }

    }

    //Funcion que verifica si el usuario tiene cuenta.
    private fun LoginUsuario() {

        //Iniciamos sesion con firebase

        FirebaseAuth.getInstance().signInWithEmailAndPassword(Email,Password)
            .addOnCompleteListener(this,OnCompleteListener {task ->

                if (task.isSuccessful){
                    //val user=auth.currentUser
                    Toast.makeText(this,"Te has identificado correctamente.",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MenuActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(this,"Registro fallido.",Toast.LENGTH_SHORT).show()
                    showRellenar()
                }
        })
    }

    private fun showRellenar() {
        val builder= AlertDialog.Builder(this)// creamos un cuadro de dialogo

        builder.setTitle("ERROR DE AUTENTICACION!!")
        builder.setMessage("Deves de rellenar todos los campos correctamente.")
        builder.setPositiveButton("aceptar",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }

}
