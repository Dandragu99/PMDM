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
                val intent: Intent = Intent(applicationContext, SecondActivity::class.java)
                // Quiero que la pantalla secundaria me de la bienvenida
                val bundle: Bundle = Bundle() // esto es como una caja
                bundle.putString("correo",binding.editCorreo.text.toString()) // acabo de meter un dato en la caja

                // Después de crear el serializable volvemos al main
                bundle.putSerializable(
                    "objeto"
                    ,Usuario(binding.editCorreo.text.toString(), binding.editPass.text.toString())
                )

                intent.putExtra("datos", bundle) // el intent va acompañado de datos
                // Luego, en el destino esos datos los tengo que recuperar (secondActivity)
                startActivity(intent)
            }
            binding.btnLImpiar.id->{ // Si no es así haré esto otro
                limpiar()
            }
        }
    }
    fun limpiar(){
        binding.editCorreo.text.clear()
        binding.editPass.text.clear()
    }

    // podemos modificar el onRestart y los demás métodos si lo necesitamos
    // con el override reescribimos los métos y podemos colocar las funciones que creemos
    override fun onRestart() {
        super.onRestart()
        limpiar()
    }
}

// MA onCreate - onStart - onResume - XXXX - onPause -onStop - onRestart -onResume - XXXX
// MA onCreate - onStart - onResume - XXXX - onPause -onStop - onDestroy