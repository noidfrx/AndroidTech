package com.example.androidtech.data.model

import com.google.gson.annotations.SerializedName

//En el caso que el modelo tenga un nombre diferente al que vamos a recibir del backend se usa SerializaedName
data class QuoteModel (@SerializedName("quote") val quote:String, @SerializedName("author") val author:String)