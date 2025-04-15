package com.uax.estado1

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uax.estado1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener, OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Empezamos con la parte lógica y lo primero es llamar al escuchador(Listener)
        binding.btnAnadir.setOnClickListener(this)
        // Escucha cuando cambia el estado del botón
        // ¿Por que no puedo poner this? -> Pues porque no está implementado en la interfaz.
        // HAY QUE IMPLEMENTARLO ARRIBA y ya nos deja de dar error.
        binding.CheckEdicion.setOnCheckedChangeListener(this)



    }
    // Implementamos el método onClick

    override fun onClick(v: View?) {
        // ¿Aquí que tenemos que hacer?
        // Pues preguntar quién ha pulsado el botón.
        when(v?.id){
            // ¿Ha sido este quién ha pulsado el botón?
            binding.btnAnadir.id->{
                // Si es así añadir 1 al contador
            }
        }


    }

    // Aquí ya tenemos implementado el método onCheckedChange

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        // ¿Que es lo primero que tengo que hacer?
        // Pues otro when
        when(buttonView?.id){
            binding.CheckEdicion.id->{ // Como son dos posible escenarios pues tocará un if
                if (binding.CheckEdicion.isChecked){
                // si está en true se pone edit en activado
                    binding.editText.isEnabled = true
                }else {
                    // si está en false se pone el edit en desactivado
                    binding.editText.isEnabled = false
                }

                /*
                * Hay una forma más elegante de hacerlo
                *
                * when(buttonView?.id){
                    binding.CheckEdicion.id->{
                        binding.editText.isEnable = isChecked
                *
                * De esta forma nos podemos ahorrar el if
                * */


            }
        }
    }
}