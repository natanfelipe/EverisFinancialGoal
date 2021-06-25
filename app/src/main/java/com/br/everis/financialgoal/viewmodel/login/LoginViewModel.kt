package com.br.everis.financialgoal.viewmodel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelResponse
import com.br.everis.financialgoal.data.datasource.worker.login.LoginResult
import com.br.everis.financialgoal.repository.cadastro.ImpLoginRepository
import com.br.everis.financialgoal.utils.FieldValidator


class LoginViewModel(private val repository: ImpLoginRepository): ViewModel() {

    private var loginModelResponse = MutableLiveData<LoginModelResponse>()
    val response: LiveData<LoginModelResponse> get() = loginModelResponse


    fun init(login: LoginModelRequest) {
        getResponseApi(login)
    }

    fun getResponseApi(login: LoginModelRequest) {
        repository.loginRepository(::getResponse, login)
    }

    fun getResponse(response: LoginResult) {
        when (response) {
            is LoginResult.RequestLoginSucess -> {
                loginModelResponse.postValue(response.sucess)
            }
            is LoginResult.RequestLoginError -> {
                loginModelResponse.postValue(response.error)
            }
        }
    }
}