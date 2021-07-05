package com.br.everis.financialgoal.data.datasource.worker.index.indexdatasource

import com.br.everis.financialgoal.data.datasource.model.index.IndexModelRequest

interface IndexDataSource {

    fun indexDataSource(
        indexResultCallback: (result: IndexResult) -> Unit,
        calculo: IndexModelRequest,
    )
}