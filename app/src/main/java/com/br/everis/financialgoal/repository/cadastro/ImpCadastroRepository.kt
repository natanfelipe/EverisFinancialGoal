package com.br.everis.financialgoal.repository.cadastro

import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelResponse
import com.br.everis.financialgoal.data.datasource.worker.cadastro.ImpCadastroDataSource

class ImpCadastroRepository(
    private val dataSource: ImpCadastroDataSource
):CadastroRepository{

    override fun cadastroRepository(
        Success: (success: CadastroModelResponse?) -> Unit,
        Error: (error: CadastroModelResponse?) -> Unit,
        cadastro: CadastroModelRequest
    ) {
        dataSource.cadastroDataSource(Success,Error,cadastro)
    }
}