package com.br.everis.financialgoal.repository.cadastro

import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelResponse
import com.br.everis.financialgoal.data.datasource.worker.cadastro.CadastroResult
import com.br.everis.financialgoal.data.datasource.worker.cadastro.ImpCadastroDataSource

class ImpCadastroRepository(
    private val dataSource: ImpCadastroDataSource
):CadastroRepository{

    override fun cadastroRepository(
        cadastroResultCallback: (result: CadastroResult) -> Unit,
        cadastro: CadastroModelRequest
    ) {
        dataSource.cadastroDataSource(cadastroResultCallback,cadastro)
    }
}