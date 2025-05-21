package com.uax.spinnersencillo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.spinnersencillo.databinding.ActivityLoginBinding
import com.uax.spinnersencillo.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity(),OnClickListener {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(this)
        binding.btnRegister.setOnClickListener(this)



    }
    // Paso 1:
    // Para unir las pantallas y poder cambiar entre ellas
    // Necesitaremos un objeto de tipo INTENT

    override fun onClick(v: View?) {
        // Paso 4:
        // ojo -> Como los dos botones utilizan el intent lo que podríamos hacer es crear la variable intent
        // Y una vez declarado lo inicializamos con el startActivity
        lateinit var intent : Intent
        when(v?.id){
            binding.btnLogin.id ->{
                // Paso 2:
                // dentro del intent va el applicationContext y la pantalla a la que nos vayamos a dirigir
                intent = Intent(applicationContext,MainActivity::class.java)
                // Paso 3:
                // Lo siguiente que haremos es arrancar el intent
                //startActivity(intent)
            }
            binding.btnRegister.id ->{
                intent = Intent(applicationContext, registerActivity::class.java)

            }
        }
        startActivity(intent)
    }
}