package com.br.everis.financialgoal.data.datasource.worker.login

import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelResponse
import com.br.everis.financialgoal.data.datasource.service.ApiService
import com.br.everis.financialgoal.data.datasource.service.ImpApiService
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

sealed class LoginResult{
    class RequestLoginSucess(val sucess: LoginModelResponse?) : LoginResult()
    class RequestLoginError(val error: LoginModelResponse?) : LoginResult()
}

class ImpLoginDataSource(
    private var apiService: ImpApiService
): LoginDataSource{

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    override fun loginDataSource(
        loginResultCallback: (result: LoginResult) -> Unit,
        login: LoginModelRequest
    ) {
        coroutineScope.launch {

                val request = apiService.requestAPI().loginRequest(login).clone().execute()
                 if(request.code()==200){
                        loginResultCallback(LoginResult.RequestLoginSucess(
                            request.body()?.let {
                                LoginModelResponse(
                                    request.message(),
                                    request.isSuccessful,
                                    it.user)
                            }))
                    }else{
                        val gson = Gson()
                        val response = gson.fromJson(request.errorBody()?.charStream(), LoginModelResponse::class.java)
                        loginResultCallback(LoginResult.RequestLoginError(response))
                }

        }
    }
}