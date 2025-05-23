package com.uax.spinnersencillo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.spinnersencillo.databinding.ActivityMainBinding
import com.uax.spinnersencillo.model.User

// El spinner simpre va acompañado de su parte gráfica y su parte de datos
// datos: Son los que se mostrarán dentro del spinner.
// Pueden ser un conjunto de Strings

class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding
    // ¿Como recuperamos los datos del bundle?
    // Paso 8: primero creamos la variable bundle y lo igualamos a nulo porque puede ser un nulo
    private var bundleRecuperado: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        // Paso 9: para poder recuperar esos datos tenemos que hacer exactamente lo mismo que en el intent anterior
        bundleRecuperado = intent.extras?.getBundle("datos")
        /*
        // Paso 10: Y ya definido esto ahora sí, podemos recuperar los datos que declaramos previamente
        binding.textUser.text = bundleRecuperado?.getString("mail") ?: "sin correo"
        // Paso 11: Vamos a la carpeta com. y creamos un package model y dentro una clase User // Paso 12 en el User
        -->
        */
        // Paso 14: Vamos a recuperar los datos de esta manera
        val userRec = bundleRecuperado?.getSerializable("user") as User
        //--> Paso 15: Pero ahora ya creada la variable userRec ya no hace falta cogerlo desde el bundleRecuperado podemos hacer esto
        binding.textUser.text = userRec.mail ?: "sin correo"
        // El efecto sería el mismo pero en vez de pasar el objeto parámetro a parámetro con el bundle
        // ahora lo estaríamos pasando de manera conjunta




    }
}