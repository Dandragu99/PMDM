package com.uax.ejercicio4

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.uax.ejercicio4.databinding.ActivityMainBinding
import java.util.Date

/*Ejercicio: Calculadora de Edad
Objetivo: Crea una app que permita al usuario introducir su año de nacimiento y calcule su edad actual.

Dos campos de texto (EditText):
Uno para introducir el nombre (opcional).
Otro para el año de nacimiento (obligatorio).
Un botón:
Al pulsarlo, debe calcular la edad del usuario restando el año actual menos el año ingresado.
Un TextView:
Muestra el mensaje: "Tienes X años", o "Hola [nombre], tienes X años" si se rellenó el nombre.
Validación:
Si el año está vacío o es inválido (no numérico, año futuro, etc.), muestra un Toast: "Debes introducir un año válido".
*/

class MainActivity : AppCompatActivity(),OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.btnCalcular.id ->{
                calcularEdad()
            }
        }
    }

    fun calcularEdad(){
        val nombre = binding.Nombre.text.toString()
        val num1 = binding.AnioActual.text.toString()
        val num2 = binding.AnioNacimiento.text.toString()
        if (num1.isNotEmpty() && num2.isNotEmpty()){
            val edad = num1.toInt() - num2.toInt()
            binding.mostrarEdad.text = "La edad de $nombre es $edad"
        }else{
            binding.mostrarEdad.text = "Hay que completar los dos campos"
        }
    }




        /*   val nombre = binding.Nombre.text.toString()
                val anioActual: Int = 2025
                val edad = binding.Nacimiento.id

                val edadCalculada = calcularEdad(anioActual,edad)
                Snackbar.make(binding.root,"La edad de $nombre es $edadCalculada",Snackbar.LENGTH_SHORT).show()
            }*/
}