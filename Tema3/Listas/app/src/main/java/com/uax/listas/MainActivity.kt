package com.uax.listas

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.uax.listas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener, OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        // Primero como siempre poner el listener en this
        binding.btnEnviar.setOnClickListener(this)
        // Forma más sencilla aunque no la más correcta
        binding.spinnerHabilitado.onItemSelectedListener(this)






        // this // da error. Que debería pasar para que funcione - Pues implementando al interfaz
        // Como tengo dos métodos esto no sería lo mejor sino que sería igualarlo a un objeto
        /* Esto es lo que se debería hacer - Pero para hacerlo más fácil mejor usar el ItemSelected de arriba.
        binding.spinnerHabilitado.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                TODO("Not yet implemented")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        // Luego, poner el item selected listener -> configurado mediante propiedad.
        */






    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnEnviar.id -> {
                val seleccion = binding.spinnerHabilitado.selectedItem.toString()
                Snackbar.make(binding.root, "La seleccion es $seleccion", Snackbar.LENGTH_SHORT).show()
            }
        }
    }


    // Y nos trae dos métodos

    // Primer método se va a ejecutar cuando yo despliegue y cambie la selección

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }
    // Segundo método se va a ejecutar cuando yo toque pero no cambie la selección
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


}