package com.uax.ejercicio5

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.ejercicio5.databinding.ActivityMainBinding

/*
Ejercicio: Calculadora de IMC (Índice de Masa Corporal)
Dos EditText para que el usuario introduzca:
Peso en kilogramos.
Altura en metros.
Un Button que al pulsarlo:
Verifique que los campos no estén vacíos.
Muestra el resultado en un TextView o con un Snackbar.
Si alguno de los campos está vacío o el valor no es válido, muestra un mensaje de error.*/

class MainActivity : AppCompatActivity(), OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.CalcularIMC.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.CalcularIMC.id ->{
                calcularIMC()
            }
        }
    }

    private fun calcularIMC() {
        val peso = binding.peso.text.toString()
        val altura = binding.altura.text.toString()
        if (peso.isNotEmpty() && altura.isNotEmpty()){
            val IMC = peso.toInt() / (altura.toInt() * 2)
            binding.resultado.text = "Tu índice de masa corporal es: $IMC"
        }else{
            binding.resultado.text = "Es obligatorio completar los campos."
        }
    }
}