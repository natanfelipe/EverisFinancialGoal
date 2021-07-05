package com.br.everis.financialgoal.repository.index

import com.br.everis.financialgoal.data.datasource.model.index.IndexModelRequest
import com.br.everis.financialgoal.data.datasource.worker.index.indexdatasource.ImpIndexDataSource
import com.br.everis.financialgoal.data.datasource.worker.index.indexdatasource.IndexResult

class ImpIndexRepository (
    private val dataSource: ImpIndexDataSource
    ): IndexRepository {

        override fun indexRepository(
            indexResultCallback: (result: IndexResult) -> Unit,
            index: IndexModelRequest
        ) {
            dataSource.indexDataSource(indexResultCallback, index)
        }
}