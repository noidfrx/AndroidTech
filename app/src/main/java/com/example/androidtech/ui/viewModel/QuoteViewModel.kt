package com.example.androidtech.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtech.data.model.QuoteModel
import com.example.androidtech.data.model.QuoteProvider
import com.example.androidtech.domain.GetQuotesUseCase

//Extiende de ViewModel para comportarse como tal
class QuoteViewModel : ViewModel() {

    //Encapsulamos el modelo que queremos en un Livedata mutable porque cambia
    val quoteModel = MutableLiveData<QuoteModel>()

    var getQuotesUseCase = GetQuotesUseCase()

    //En este metodo se hará llamada al caso de uso para que nos devuelva todas las quotes y almacene todas las quotes
    fun onCreate() {
        TODO("Not yet implemented")
    }

    //Valor de livedata va a cambiar gracias a esta funcion pues se llama a esta funciòn
    fun randomQuote(){
        //Actualizamos quoteRandom
        //val currentQuote = QuoteProvider.random()
        //Añadimos valor en el postValue que es el cambio de data
        //quoteModel.postValue(currentQuote)
    }


}