package com.br.everis.financialgoal.repository.login

import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest
import com.br.everis.financialgoal.data.datasource.worker.login.LoginResult
import kotlin.reflect.KFunction1

interface LoginRepository {
    fun loginRepository(
        loginResultCallback: (login: LoginResult) -> Unit,
        login: LoginModelRequest)
}