package com.uax.ejercicio3

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.ejercicio3.databinding.ActivityMainBinding

/*Crea una aplicación en Android Studio
 que permita al usuario introducir dos números en dos campos de texto (EditText).
 Añade un botón que, al pulsarlo,
 sume ambos números y muestre el resultado debajo, en un TextView.
 Si alguno de los campos está vacío,
 muestra un mensaje indicando que ambos números son obligatorios.
* */

class MainActivity : AppCompatActivity(),OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnSumar.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnSumar.id -> {
                sumar()
            }
        }
    }

    fun sumar() {
       val num1 = binding.numUno.text.toString()
        val num2 = binding.numDos.text.toString()
        if (num1.isNotEmpty() && num2.isNotEmpty()){
            val suma = num1.toInt() + num2.toInt()
            binding.resultado.text = "resulatdo: $suma"
        }else{
            binding.resultado.text = "Los dos números son obligatorios"
        }
    }
}