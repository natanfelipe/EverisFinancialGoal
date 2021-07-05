package com.br.everis.financialgoal.data.datasource.worker.yearly.yearlydatasource

import com.br.everis.financialgoal.data.datasource.model.yearly.YearlyModelRequest

interface YearlyDataSource {

    fun yearlyDataSource(
        yearlyResultCallback: (result: YearlyResult) -> Unit,
        calculo: YearlyModelRequest,
    )
}