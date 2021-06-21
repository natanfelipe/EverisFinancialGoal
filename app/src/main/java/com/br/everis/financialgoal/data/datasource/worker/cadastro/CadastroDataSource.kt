package com.br.everis.financialgoal.data.datasource.worker.cadastro

import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelResponse

interface CadastroDataSource {

    fun cadastroDataSource(
        Success:(success: CadastroModelResponse?) -> Unit,
        Error:(error: CadastroModelResponse?) -> Unit,
        cadastro:CadastroModelRequest
    )
}