package com.br.everis.financialgoal.data.datasource.worker.login

import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest


interface LoginDataSource {
    fun loginDataSource(
       loginResultCallback: (result: LoginResult) -> Unit,
       login: LoginModelRequest)
}