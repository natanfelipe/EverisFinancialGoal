package com.br.everis.financialgoal.repository.monthly

import com.br.everis.financialgoal.data.datasource.model.monthly.MonthlyModelRequest
import com.br.everis.financialgoal.data.datasource.worker.monthly.ImpMonthlyDataSource
import com.br.everis.financialgoal.data.datasource.worker.monthly.MonthlyResult


class ImpMonthlyRepository (private val dataSource: ImpMonthlyDataSource): MonthlyRepository{
    override fun monthlyRepository(
        monthlyResultCallback: (monthly: MonthlyResult) -> Unit,
        monthly: MonthlyModelRequest
    ) {
        dataSource.monthlyDataSource(monthlyResultCallback, monthly)
    }
}