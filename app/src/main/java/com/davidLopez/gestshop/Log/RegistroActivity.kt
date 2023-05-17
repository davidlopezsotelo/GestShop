package com.davidLopez.gestshop.Log

import android.content.Intent
import android.os.Bundle

import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.davidLopez.gestshop.BaseDatos.entities.Usuario
import com.davidLopez.gestshop.InicioActivity
import com.davidLopez.gestshop.databinding.ActivityRegistroBinding



//https://www.youtube.com/watch?v=XMylQ1cxpFM&list=PLhcYacorV7U4Qsq-I9RH80mVGJ_8IyOPW&index=11&t=959s


class RegistroActivity : AppCompatActivity() {


     private lateinit var binding: ActivityRegistroBinding
     private val viewModel:UsuarioViewModel = TODO()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setup()
    }

    override fun onStart() {
        super.onStart()
        binding.buttonRegistroReg.setOnClickListener {
            registro()
        }
    }

    private fun registro() {
        val nombre = binding.NombreEt.text.toString()
        val email = binding.correoEt.text.toString()
        val password = binding.contrasenaEt.text.toString()
        val repPassword = binding.RepContrasenaEt.text.toString()

        if (nombre.isBlank() || email.isBlank() || password.isBlank() || repPassword.isBlank()) {
            Toast.makeText(this, "Deves rellenar todos los campos", Toast.LENGTH_SHORT).show()
            return
        }
        if (password != repPassword) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return
        }

       viewModel.save (Usuario(nombre, password)).observe(this) {
            if (!it) {
                Toast.makeText(this, "Error al crear usuario", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, InicioActivity::class.java))

                finish()
            }

        }


        /* private fun setup() {

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
*/

        //guardamos el usuario en la base de datos


        //creamos una funcion que mostrara un  mensaje de alerta mediante un cuadro de dialogo----------





    }//fin class
}