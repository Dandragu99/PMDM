package com.uax.spinnersencillo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.spinnersencillo.databinding.ActivityMainBinding
import com.uax.spinnersencillo.databinding.ActivityRegisterBinding

class registerActivity : AppCompatActivity(), OnClickListener{
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // FINALMENTE PARA HACER EL SPINNER
        // Lo primero que tenemos que hacer es ir al archivo string.xml
        // y poner un string-array y dentro los distintos items (usuario,admin,invitado)
        // de ahí vamos al layout y dentro ponemos un objeto de tipo <spinner>

        // Una vez que tengamos el layout. Lo que tenmos que hacer es capturar la pulsación
        // o bien en la pulsación o bien en el cambio de datos

        binding.btnRegister.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.btnRegister.id ->{
                // cogemos el spinner y dentro de el cogemos el objeto adapter
                // que es la parte de datos del spinner
                // y el getItem, posición que nos pide
                //binding.spinnerPerfil.selectedItem
                //aquí ya tendríamos el perfil seleccionado
                val perfil: String = binding.spinnerPerfil.selectedItem.toString()
                // lo sacamos por el log para verlo, tipamos la variable como string para no tener ninguna duda
                Log.v("perfil",perfil.toString())
                // así se ve la escucha a posteriori. Más adelante veremos la escucha a priori.
            }
        }
    }
}