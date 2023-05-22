package com.davidLopez.gestshop.Log

import android.content.Intent
import android.os.Bundle

import android.widget.Toast
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import com.davidLopez.gestshop.BaseDatos.entities.Usuario
import com.davidLopez.gestshop.InicioActivity
import com.davidLopez.gestshop.databinding.ActivityRegistroBinding

//https://www.youtube.com/watch?v=XMylQ1cxpFM&list=PLhcYacorV7U4Qsq-I9RH80mVGJ_8IyOPW&index=11&t=959s
class RegistroActivity : AppCompatActivity() {
     private lateinit var binding: ActivityRegistroBinding
     private val viewModel:UsuarioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
    }
}