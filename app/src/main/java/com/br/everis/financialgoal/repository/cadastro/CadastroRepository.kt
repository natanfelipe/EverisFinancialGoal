package com.br.everis.financialgoal.repository.cadastro

import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelResponse

interface CadastroRepository {

    fun cadastroRepository(
        Success:(success: CadastroModelResponse?) -> Unit,
        Error:(error: CadastroModelResponse?) -> Unit,
        cadastro:CadastroModelRequest)
}