package com.uax.spinnersencillo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.spinnersencillo.databinding.ActivityMainBinding

// El spinner simpre va acompañado de su parte gráfica y su parte de datos
// datos: Son los que se mostrarán dentro del spinner.
// Pueden ser un conjunto de Strings

class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)





    }
}