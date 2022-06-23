package com.example.androidtech.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.androidtech.databinding.ActivityMainBinding
import com.example.androidtech.ui.viewModel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    //Para el binding
    private lateinit var binding:ActivityMainBinding

    //Conexión de viewModel con activity el by viewModels() nos va a ayudar con la conexión de viewModel y activity
    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Uso del binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Cambio solo de la vista
        setContentView(binding.root)

        //Llamamos a viewModel y creamos funcion onCreate
        quoteViewModel.onCreate()



        //Accedemos a model del viewmodel .observe(owner, fun)
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            //Lo de aquí adentro está conectado al livedata y cuando cambie algo(nueva cita) se ejecuta lo que está aquí
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })

        quoteViewModel.isLoading.observe(this) {
            //La visibilidad va a estar dada según el boolean encontrado dentro del livedata
            binding.progress.isVisible = it
        }

        //Cuando tocamos algo en la pantalla, se obtiene cita random y se la pone al viewModel
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}