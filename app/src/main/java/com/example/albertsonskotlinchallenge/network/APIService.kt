package com.example.albertsonsinterview.network

import retrofit2.http.GET
import com.example.albertsonsinterview.models.AcronymResponse
import retrofit2.Call
import retrofit2.http.Query

interface APIService {
    //Acronyms
    @GET("/software/acromine/dictionary.py")
    fun getAcronyms(@Query("sf") query: String?): Call<List<AcronymResponse?>?>?
}