package com.uax.formulario_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.formulario_2.databinding.ActivityMainBinding
import com.uax.formulario_2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    // recuperamos los datos
    private var datosRecuperados: Bundle? = null // esto será la caja que recupere

    // Y aquí lo guardo en una variable( el serializable)
    private var usuario: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // declaramos la variable y como está en un intent dentro de un bundle recuperamos esos datos
        // con la palabra que hemos guardado esos datos
        datosRecuperados = intent.extras?.getBundle("datos") // como puede ser nulo usamos el "?"
        // Lo casteamos -> si está tachado significa que está deprecado
        usuario = datosRecuperados?.getSerializable("objeto") as Usuario

        binding.textoCorreo.text = usuario?.correo  ?: "sin correo"

    }
}