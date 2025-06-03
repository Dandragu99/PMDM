package com.uax.ejercicio7

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.ejercicio7.databinding.ActivityMainBinding
import com.uax.ejercicio7.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private  var bundleRecuperado: Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        val bundle = intent.extras
        val examen = bundle?.getDouble("examen") ?: 0.0
        val media = bundle?.getDouble("media") ?: 0.0

        binding.textoNota.text = "Nota examen es : ${examen} la media es: ${media}"

        /*val nota: Double = intent.getDoubleExtra("media",0.0)
        binding.textoNota.text = "Tu nota final es ${nota}"
        */

    }
}