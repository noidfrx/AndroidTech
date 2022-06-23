package com.example.androidtech.domain

import com.example.androidtech.data.QuoteRepository
import com.example.androidtech.data.model.QuoteModel
import com.example.androidtech.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    private val repository = QuoteRepository()

    //NO ES CORRUTINA PORQUE LO TENEMOS ALMACENADO EN MEMORIA POR AHORA
    operator fun invoke(): QuoteModel?{
        //Deberìa llamar al repository.GetAllQuotes pero ahora es muy largo
        //Así que vamos al QuoteProvider
        val quotes = QuoteProvider.quotes

        //Si no está vacío elige un valor de quote random, o sino un null
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}