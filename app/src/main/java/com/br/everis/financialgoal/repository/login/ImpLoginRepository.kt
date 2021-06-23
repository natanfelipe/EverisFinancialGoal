package com.br.everis.financialgoal.repository.cadastro

import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest
import com.br.everis.financialgoal.data.datasource.worker.login.ImpLoginDataSource
import com.br.everis.financialgoal.data.datasource.worker.login.LoginResult
import com.br.everis.financialgoal.repository.login.LoginRepository


class ImpLoginRepository(
    private val dataSource: ImpLoginDataSource
):LoginRepository{
    override fun loginRepository(
        loginResultCallback: (login: LoginResult) -> Unit,
        login: LoginModelRequest
    ) {
        dataSource.loginDataSource(loginResultCallback,login)
    }
}