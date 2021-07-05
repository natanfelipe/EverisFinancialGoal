package com.br.everis.financialgoal.repository.yearly

import com.br.everis.financialgoal.data.datasource.worker.yearly.yearlydatasource.ImpYearlyDataSource
import com.br.everis.financialgoal.data.datasource.model.yearly.YearlyModelRequest
import com.br.everis.financialgoal.data.datasource.worker.yearly.yearlydatasource.YearlyResult

class ImpYearlyRepository (
    private val dataSource: ImpYearlyDataSource
    ): YearlyRepository {

    override fun yearlyRepository(
        yearlyResultCallback: (result: YearlyResult) -> Unit,
        yearly: YearlyModelRequest
    ) {
        dataSource.yearlyDataSource(yearlyResultCallback, yearly)
    }
}