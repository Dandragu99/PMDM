package com.uax.formulario_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.formulario_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // En esta actividad veremos como pulsando un botón en la primera pantalla iremos a la segunda

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        // Hasta aquí ya lo tengo inicializado

    }
}