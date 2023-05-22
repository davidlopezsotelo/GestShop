package com.davidLopez.gestshop.Log

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.davidLopez.gestshop.BaseDatos.entities.Usuario
import com.davidLopez.gestshop.InicioActivity
import com.davidLopez.gestshop.UI.MenuActivity
import com.davidLopez.gestshop.R
import com.davidLopez.gestshop.app.App
import com.davidLopez.gestshop.databinding.ActivityLoginBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private val viewModel: UsuarioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        val usuario = App.getUsuario()
        usuario?.let {
            startActivity(Intent(this, InicioActivity::class.java))
            finish()
        }

        binding.buttonEntrar.setOnClickListener {
            login()
        }
        binding.buttonRegistroLog.setOnClickListener {
            registro()
        }
    }

    private fun login() {
        val correo = binding.correoEtLogin.text.toString()
        val password = binding.contrasenaEtLogin.text.toString()
        if (correo.isBlank() || password.isBlank()) {
            Toast.makeText(this,"deves rellenar los campos",Toast.LENGTH_LONG).show()
            return
        }
        viewModel.login(Usuario(correo, password)).observe(this) {
            if (!it.result) {
               showRellenar()
            } else {
                startActivity(Intent(this, InicioActivity::class.java))
                finish()
            }
        }
    }
    private fun registro() {
        startActivity(Intent(this, RegistroActivity::class.java))
        finish()
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
