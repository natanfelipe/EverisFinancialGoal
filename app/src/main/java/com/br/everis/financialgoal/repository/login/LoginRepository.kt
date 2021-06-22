package com.br.everis.financialgoal.repository.login

import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest
import com.br.everis.financialgoal.data.datasource.worker.login.LoginResult

interface LoginRepository {
    fun loginRepository(
        loginResultCallback: (result: LoginResult) -> Unit,
        login: LoginModelRequest)
}