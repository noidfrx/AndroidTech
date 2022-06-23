package com.example.androidtech.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtech.data.model.QuoteModel
import com.example.androidtech.data.model.QuoteProvider
import com.example.androidtech.domain.GetQuotesUseCase
import com.example.androidtech.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

//Extiende de ViewModel para comportarse como tal
class QuoteViewModel : ViewModel() {

    //Encapsulamos el modelo que queremos en un Livedata mutable porque cambia
    val quoteModel = MutableLiveData<QuoteModel>()
    //Boolean que muestre o oculte progress bar
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    //En este metodo se hará llamada al CASO DE USO para que nos devuelva todas las quotes y almacene todas las quotes que recibe
    fun onCreate() {
        //Como funcion original es una corrutina usamos el ViewModelScope nos permite crear corrutina que se controla automaticamente
        viewModelScope.launch{
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            //Si no está vacío o nulo
            if(!result.isNullOrEmpty()){
                //Al LiveData del Quote model (La que pinta la cita en view)
                quoteModel.postValue(result[0]) //Tomamos la primera y la ponemos para que no esté en blanco al comienzo
                isLoading.postValue(false)
            }
        }
    }

    //Valor de livedata va a cambiar gracias a esta funcion pues se llama a esta funciòn
    fun randomQuote(){
        isLoading.postValue(true)
        //El viewmodel solamente va a llamar al caso de uso le da igual como funcione
        val quote = getRandomQuoteUseCase()
        if(quote != null){
            quoteModel.postValue(quote!!)
        }

        isLoading.postValue(false)
    }


}