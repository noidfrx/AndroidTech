package com.example.androidtech.domain

import com.example.androidtech.data.QuoteRepository
import com.example.androidtech.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    /*
        La clave de las funciones con suspend operator fun invoke dentro de
        un usercase es que ahora la funcion es llamada automaticamente

        class aaaaa{
            val getQuotesUseCase = GetQuotesUseCase()

            //SOLAMENTE SE HACE ESTO PARA LLAMAR A LA FUNCION sin puntos y demás
            getQuotesUseCase()

        }

    Nullable por si servidor entrega algo raro
    Llamamos a repositorio y obtenemos la info
    Es una funcion con un valor de return asi que se acorta
    */
    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}