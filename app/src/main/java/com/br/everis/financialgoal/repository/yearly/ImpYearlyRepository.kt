package com.br.everis.financialgoal.repository.yearly

import com.br.everis.financialgoal.data.yearlysource.yearlydatasource.ImpYearlyDataSource
import com.br.everis.financialgoal.data.yearlysource.model.YearlyModelRequest
import com.br.everis.financialgoal.data.yearlysource.yearlydatasource.YearlyResult

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