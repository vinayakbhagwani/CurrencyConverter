package com.demo.currencyconverter.api

import com.demo.currencyconverter.data.models.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("/latest")
    suspend fun getRates(
        @Query("base") base:String,
        @Query("API_KEY") apikey:String
    ): Response<CurrencyResponse>
}