package com.br.everis.financialgoal.repository.yearly

import com.br.everis.financialgoal.data.datasource.model.yearly.YearlyModelRequest
import com.br.everis.financialgoal.data.datasource.worker.yearly.yearlydatasource.YearlyResult

interface YearlyRepository {
    fun yearlyRepository (
        yearlyResultCallback: (result: YearlyResult) -> Unit,
        yearly: YearlyModelRequest
    )
}
