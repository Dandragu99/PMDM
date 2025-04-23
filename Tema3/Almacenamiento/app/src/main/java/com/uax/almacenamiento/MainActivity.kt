package com.uax.almacenamiento

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.almacenamiento.dao.UserDAO
import com.uax.almacenamiento.databinding.ActivityMainBinding
import com.uax.almacenamiento.model.User

// En este proyecto vamos hacer un acceso a Bases de Datos y un CRUD
// Seleccion, actualización y borrado

// Para la Base de Datos necesito una clase especial. Me la creo en el paquete com.uax.almacenamiento.database
// Que será el paquete que almacenará el código de la base de datos
class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        binding.btnBorrar.setOnClickListener(this)
        binding.btnInsertar.setOnClickListener(this)
        binding.btnActualizar.setOnClickListener(this)
        binding.btnSeleccionar.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.btnBorrar.id ->{
                val userDAO = UserDAO(applicationContext)
                userDAO.deleteUser("Dani")
            }
            binding.btnInsertar.id ->{
                // Con esto vamos a ver que cuando pulso el botón inserto un usuario
                val userDAO = UserDAO(applicationContext)
                userDAO.insertUser(User("Dani",24))
            }
            binding.btnActualizar.id ->{
                val userDAO = UserDAO(applicationContext)
                userDAO.updateUser("Dani")
            }
            binding.btnSeleccionar.id ->{
                // Aquí me creo un dao para poder verlo
                val userDAO = UserDAO(applicationContext)
                binding.textView.text = userDAO.getUsers().toString()
            }
        }
    }
}