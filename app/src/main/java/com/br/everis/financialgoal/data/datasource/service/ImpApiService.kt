package com.br.everis.financialgoal.data.datasource.service

import com.br.everis.financialgoal.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImpApiService {
    companion object{
        const val BASE_URL = BuildConfig.BASE_URL
    }

    val gson: Gson = GsonBuilder()
        .serializeNulls()
        .serializeSpecialFloatingPointValues()
        .setLenient()
        .create()

    private fun provider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun requestAPI() :ApiService = provider().create(ApiService::class.java)
}