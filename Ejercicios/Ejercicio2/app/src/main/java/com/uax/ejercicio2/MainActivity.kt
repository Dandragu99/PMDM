package com.uax.ejercicio2

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.ejercicio2.databinding.ActivityMainBinding


/*Crea una aplicación en Android Studio con un campo de texto y un botón.
 Cuando el usuario escriba su nombre en el campo de texto y pulse el botón,
  la aplicación debe mostrar un mensaje debajo que diga
   "Hola, [nombre]" (por ejemplo, "Hola, Ana").
* */
class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.buttonEnviar.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v?.id){
            binding.buttonEnviar.id->{
                binding.VistaTexto.text = "Hola, ${binding.editText.text}"
            }
        }
    }
}