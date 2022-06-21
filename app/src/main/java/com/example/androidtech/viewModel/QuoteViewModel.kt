package com.example.androidtech.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtech.model.QuoteModel
import com.example.androidtech.model.QuoteProvider

//Extiende de ViewModel para comportarse como tal
class QuoteViewModel : ViewModel() {

    //Encapsulamos el modelo que queremos en un Livedata mutable porque cambia
    val quoteModel = MutableLiveData<QuoteModel>()

    //Valor de livedata va a cambiar gracias a esta funcion pues se llama a esta funciòn
    fun randomQuote(){
        //Actualizamos quoteRandom
        val currentQuote = QuoteProvider.random()
        //Añadimos valor en el postValue que es el cambio de data
        quoteModel.postValue(currentQuote)
    }
}