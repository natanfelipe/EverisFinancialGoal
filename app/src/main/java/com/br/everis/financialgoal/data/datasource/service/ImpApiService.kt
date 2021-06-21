package com.br.everis.financialgoal.data.datasource.service

import com.br.everis.financialgoal.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImpApiService {
    companion object{
        const val BASE_URL = BuildConfig.BASE_URL
    }

    private fun provider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun cadastro() :ApiService = provider().create(ApiService::class.java)
}