package com.uax.formulario_2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.formulario_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    // En esta actividad veremos como pulsando un botón en la primera pantalla iremos a la segunda

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        // Hasta aquí ya lo tengo inicializado

        // Queremos asociar pulsaciones a botones ¿Como se hace?
        binding.btnLogin.setOnClickListener(this)
        binding.btnLImpiar.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        // ejecutar cuando un boton o un elemento sea pulsado

        // Lo que tengo que hacer antes de nada es decir que haré si ha sido pulsado
        // que boton ha sido pulsado?
        when(v?.id){ // el id del que ha sido pulsado es el id del boton login?
            binding.btnLogin.id->{ // Si es así haré esto
                // intent - origen - destino
                val intent: Intent = Intent(applicationContext)
            }
            binding.btnLImpiar.id->{ // Si no es así haré esto otro

            }
        }
    }
}