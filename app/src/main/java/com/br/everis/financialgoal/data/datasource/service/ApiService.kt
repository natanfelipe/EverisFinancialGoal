package com.br.everis.financialgoal.data.datasource.service


import com.br.everis.financialgoal.BuildConfig
import com.br.everis.financialgoal.data.datasource.worker.yearly.model.YearlyModelRequest
import com.br.everis.financialgoal.data.datasource.worker.yearly.model.YearlyModelResponse
import com.br.everis.financialgoal.data.datarecoverysource.model.RecoveryModelRequest
import com.br.everis.financialgoal.data.datarecoverysource.model.RecoveryModelResponse
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelResponse
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelResponse
import com.br.everis.financialgoal.data.datasource.model.monthly.MonthlyModelRequest
import com.br.everis.financialgoal.data.datasource.model.monthly.MonthlyModelResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService
{
    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("/${BuildConfig.AMBIENTE}/usuarios")
    fun cadastroRequest(@Body cadastroBody: CadastroModelRequest): Call<CadastroModelResponse>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("${BuildConfig.AMBIENTE}/login")
    fun loginRequest(@Body loginBody: LoginModelRequest): Call<LoginModelResponse>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("/${BuildConfig.AMBIENTE}/recovery-password")
    fun recoveryRequest(@Body recoveryBody: RecoveryModelRequest): Call<RecoveryModelResponse>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("${BuildConfig.AMBIENTE}/calcularjuroscomposto")
    fun monthlyRequest(@Body monthlyBody: MonthlyModelRequest): Call<MonthlyModelResponse>

    @Headers("x-api-key: ${BuildConfig.API_KEY}")
    @POST("/${BuildConfig.AMBIENTE}/calcularjuroscomposto")
    fun yearlyRequest(@Body yearlyBody: YearlyModelRequest): Call<YearlyModelResponse>

}