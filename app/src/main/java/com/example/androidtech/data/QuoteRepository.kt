package com.example.androidtech.data

import com.example.androidtech.data.model.QuoteModel
import com.example.androidtech.data.model.QuoteProvider
import com.example.androidtech.data.network.QuoteService

//Esta serìa la clase a la que llame para gestionar lo del network (retrofit) o database
class QuoteRepository {

    //Service que viene de network
    private val api = QuoteService()

    //Clase a la que llamo para que me devuelva las citas
    suspend fun getAllQuotes():List<QuoteModel>{
        //Obtenemos respuesta unica del servidor, obtenemos modelo de dato y lo guardamos en memoria
        /*  Primera vez se pide al api*/
        val response : List<QuoteModel> = api.getQuotes()

        //Almacenamos respuesta del servidor en provider, pequeña bd
        QuoteProvider.quotes = response
        return response
    }
}