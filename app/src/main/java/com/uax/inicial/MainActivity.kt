package com.uax.inicial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.inicial.databinding.ActivityMainBinding

// PARTE LOGICA DE LA PANTALLA --> ACTIVITY

class MainActivity : AppCompatActivity() {

    //PRIMER METODO DEL CICLO DE VIDA *ES OBLIGATRORIO
        // siempre para crear la variable lateinit
        // luego se inicializa
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // para inicializar el binding siempre se inicializa antes de los gráfico y lo lógico
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        //  asocia parte grafica y parte logica (this)
            // Aquí siempre hay que apuntar al elemento root, es importantísimos
            // el elemento root en este caso es ConstraintLayout(el nodo superior)
        setContentView(binding.root)
        //  después de esta línea lo grafico y lo logico están juntos
        // solamnete detrás de esta línea (imprescindible que lo entendamos bien)
    }
}