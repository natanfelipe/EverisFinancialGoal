package com.br.everis.financialgoal.repository.index

import com.br.everis.financialgoal.data.datasource.model.index.IndexModelRequest
import com.br.everis.financialgoal.data.datasource.worker.index.indexdatasource.IndexResult

interface IndexRepository {
    fun indexRepository (
        indexResultCallback: (result: IndexResult) -> Unit,
        index: IndexModelRequest
    )
}