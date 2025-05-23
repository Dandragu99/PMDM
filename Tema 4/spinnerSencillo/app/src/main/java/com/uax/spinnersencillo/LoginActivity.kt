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
import com.uax.spinnersencillo.model.User

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



                // Paso 5:Para pasar datos entre las activities necesitaremos objetos de tipo Bundle
                val bundle: Bundle = Bundle()

            /*    //Paso 6: Ponemos mail y el dato que queremos poner en este caso binding.correo.text y siempre toString() para cuando hablamos de EditText
                bundle.putString("mail", binding.correo.text.toString())
                bundle.putString("pass", binding.contrsenia.text.toString())
                -->
             */
                // Paso 7:Ahora que tenemos los bundle definidos lo que haremos es meter dentro del intent el bundle o los bundle creados.
                intent.putExtra("datos",bundle)
                // Y finalmente en el MainActivity lo que tendremos que hacer es recoger el dato

            /* --> Paso 13:  Como hemos creado un package model y creado una clase User con una interfaz serializable
            ya no nos hace falta  poner por separado los bundle sino que los podemos poner en conjunto
            *
            * */
                bundle.putSerializable("user",
                    User(binding.correo.text.toString(),binding.contrsenia.text.toString())
                )












            }
            binding.btnRegister.id ->{
                intent = Intent(applicationContext, registerActivity::class.java)
                // startActivity(intent)


            }
        }
        startActivity(intent)
    }
}