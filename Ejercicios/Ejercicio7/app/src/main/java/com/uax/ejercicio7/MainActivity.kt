package com.uax.ejercicio7

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.uax.ejercicio7.databinding.ActivityMainBinding
import com.uax.ejercicio7.databinding.ActivitySecondBinding

/*Ejercicio para calcular la nota final.
Depende de dos tareas las cuales dependerán de un spinner cada una con una puntuación de 0 a 10
Una nota de examen que introducirás en un editText
Y un botón llamado evaluar
Calculo de la nota final -> (tarea1 + tarea2)/2 *0.4 + examen * 0.6
Si la nota es inferior a 5 muestra un SnackBar diciendo has suspendido
Si es mayor a 5 Lanza una SecondActivity que ponga la nota final.
* */
class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnEvaluar.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val nota1 = binding.spinner1.selectedItem.toString().toDouble()
        val nota2 =  binding.spinner2.selectedItem.toString().toDouble()

        val mediNotas: Double = nota1 + nota2
        when(v?.id){
            binding.btnEvaluar.id->{
                if (binding.EditExamen.text.toString().isEmpty()){
                    Snackbar.make(binding.root,"Hay que introducir todos los datos",Snackbar.LENGTH_SHORT).show()
                }else{
                    val examen: Double = binding.EditExamen.text.toString().toDouble()
                    val mediaTotal = mediNotas/2 * 0.4 + examen * 0.6
                    if (mediaTotal < 5){
                        Snackbar.make(binding.root,"Suspendido",Snackbar.LENGTH_SHORT).show()
                    }else{
                        val intent = Intent(applicationContext,SecondActivity::class.java)
                        intent.putExtra("media",mediaTotal)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}