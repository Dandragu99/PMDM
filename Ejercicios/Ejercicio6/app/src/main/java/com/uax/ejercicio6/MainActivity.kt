package com.uax.ejercicio6

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.uax.ejercicio6.databinding.ActivityMainBinding

/*
Crea una aplicación, con tres spinners. Los cuales albergarán 3 notas.
Con un edit text que calculará la nota media de esas 3 notas.
Y un botón que llevará a una nueva pantalla la cuál dirá si has aprobado o no.
(si has sacado más de un 5 has aprobado).XD
*/
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnCalcualrMedia.setOnClickListener{


            val calcularMedia: Double = binding.spinner1.selectedItem.toString().toDouble() +
                    binding.spinner2.selectedItem.toString().toDouble() +
                    binding.spinner3.selectedItem.toString().toDouble()

            if (binding.editText.text.isEmpty()) {
                Snackbar.make(binding.root, "Faltan datos por poner datos", Snackbar.LENGTH_SHORT)
                    .show()
            }else{
                val mediaTotal = (calcularMedia/3)*0.3 + binding.editText.text.toString().toDouble() * 0.7
                if (mediaTotal<5){
                    Snackbar.make(binding.root,"No has aprobado",Snackbar.LENGTH_SHORT).show()

                }else{
                    val intent = Intent(applicationContext,MainActivity::class.java)
                    intent.putExtra("media",calcularMedia)
                    startActivity(intent)
                }
            }
        }
    }
}