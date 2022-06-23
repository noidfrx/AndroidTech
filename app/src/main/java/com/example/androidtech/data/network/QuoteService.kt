package com.example.androidtech.data.network

import com.example.androidtech.core.RetrofitHelper
import com.example.androidtech.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    //Usamos lo que es RetrofitHelper para instanciar retrofit
    private val retrofit = RetrofitHelper.getRetrofit()

    //Suspend porque usamos una corrutina
    suspend fun getQuotes():List<QuoteModel>{

        //CORRUTINA: Como queremos quitarle responsabilidad al hilo principal de la app, la que carga la vista, lo hacemos en una secundaria
        return withContext(Dispatchers.IO){

            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()

            //Nos puede entregar un null ?: Si esto es null devuelve una lista vacìa
            response.body() ?: emptyList()

        }


    }
}