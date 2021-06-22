package com.br.everis.financialgoal.repository.login

import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest
import com.br.everis.financialgoal.data.datasource.worker.login.ImpLoginDataSource
import com.br.everis.financialgoal.data.datasource.worker.login.LoginResult

class ImpLoginRepository(private val dataSource: ImpLoginDataSource): LoginRepository {
    override fun loginRepository(
        loginResultCallback: (result: LoginResult) -> Unit,
        login: LoginModelRequest
    ) {
        dataSource.loginDataSource(loginResultCallback, login)
    }
}