package com.demo.currencyconverter.main

import com.demo.currencyconverter.data.models.CurrencyResponse
import com.demo.currencyconverter.util.Resource

interface MainRepository {

    suspend fun getRates(base: String): Resource<CurrencyResponse>
}