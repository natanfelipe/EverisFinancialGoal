package com.br.everis.financialgoal.viewmodel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelResponse
import com.br.everis.financialgoal.data.datasource.worker.login.LoginResult
import com.br.everis.financialgoal.repository.cadastro.ImpLoginRepository

class LoginViewModel(private val repository: ImpLoginRepository): ViewModel(){

        var resp = MutableLiveData<LoginModelResponse>()
        val response: LiveData<LoginModelResponse>get() = resp

    fun init(login: LoginModelRequest){
        getResponseApi(login)
    }

    fun getResponseApi(login:LoginModelRequest){
        repository.loginRepository(::getResponse,login)
    }

    fun getResponse(response: LoginResult){
        when(response){
            is LoginResult.RequestLoginSucess ->{
               resp.postValue(response.sucess)
            }
            is LoginResult.RequestLoginError ->{
                resp.postValue(response.error)
            }
        }
    }
}