package com.br.everis.financialgoal.data.datasource.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImpApiService {
    companion object{
        const val BASE_URL = "https://zdktzx1nbi.execute-api.sa-east-1.amazonaws.com"
    }

    private fun provider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun requestAPI() :ApiService = provider().create(ApiService::class.java)
}