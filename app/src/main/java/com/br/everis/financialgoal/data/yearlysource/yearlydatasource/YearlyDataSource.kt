package com.br.everis.financialgoal.data.yearlysource.yearlydatasource

import com.br.everis.financialgoal.data.yearlysource.model.YearlyModelRequest

interface YearlyDataSource {

    fun yearlyDataSource(
        yearlyResultCallback: (result: YearlyResult) -> Unit,
        calculo: YearlyModelRequest,
    )
}