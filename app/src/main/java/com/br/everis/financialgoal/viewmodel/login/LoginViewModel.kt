package com.br.everis.financialgoal.viewmodel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelResponse
import com.br.everis.financialgoal.data.datasource.worker.login.LoginResult
import com.br.everis.financialgoal.repository.cadastro.ImpLoginRepository
import com.br.everis.financialgoal.utils.validators.FieldValidator

class LoginViewModel(private val repository: ImpLoginRepository): ViewModel() {

    private var loginModelResponse = MutableLiveData<LoginModelResponse>()
    val response: LiveData<LoginModelResponse> get() = loginModelResponse
    private lateinit var fieldValidator: FieldValidator
    private var validatorMessage = MutableLiveData<Int>()
    val messageValidator = validatorMessage

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
    fun isValid(email:String, senha:String):Boolean{
        fieldValidator = FieldValidator()

        if(!fieldValidator.isValidEmail(email)){
            messageValidator.value = R.string.email_alert_title
            return false
        }else if (!fieldValidator.isValidPassword(senha)){
            messageValidator.value = R.string.password_alert_title
            return false
        }else{
            return true
        }
    }
}