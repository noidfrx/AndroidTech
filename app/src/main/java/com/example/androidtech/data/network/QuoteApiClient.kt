package com.example.androidtech.data.network

import com.example.androidtech.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    //Acá llamamos a la otra parte de la url
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
    //Suspend porque utilizaremos corrutinas
}