package com.br.everis.financialgoal.data.datasource.service

import com.br.everis.financialgoal.BuildConfig
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelResponse
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService
{
    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("${BuildConfig.AMBIENTE}/usuarios")
    fun cadastroRequest(@Body cadastroBody: CadastroModelRequest): Call<CadastroModelResponse>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("${BuildConfig.AMBIENTE}/login")
    fun loginRequest(@Body loginBody: LoginModelRequest): Call<LoginModelResponse>
}