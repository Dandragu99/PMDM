package com.uax.ejercicio1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.ejercicio1.databinding.ActivityMainBinding

/*Crea una aplicación en Android Studio que muestre un texto en pantalla.
 El texto debe decir "Hola, Android" y aparecer centrado en la pantalla.
  No es necesario que tenga botones ni ninguna funcionalidad adicional,
   solo que muestre el mensaje al abrir la app.*/

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

    }
}