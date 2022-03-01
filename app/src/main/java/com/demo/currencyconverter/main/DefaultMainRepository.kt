package com.demo.currencyconverter.main

import com.demo.currencyconverter.api.CurrencyApi
import com.demo.currencyconverter.data.models.CurrencyResponse
import com.demo.currencyconverter.util.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyApi
) : MainRepository {

    override suspend fun getRates(base: String): Resource<CurrencyResponse> {

        return try {
            val response = api.getRates(base, API_KEY)
            val result = response.body()
            if (response.isSuccessful && result!=null){
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message?: "An error occurred")
        }
    }

    companion object{
        val API_KEY : String = "03854c306baa4eb7c0e8f9891df1007f"
    }
}