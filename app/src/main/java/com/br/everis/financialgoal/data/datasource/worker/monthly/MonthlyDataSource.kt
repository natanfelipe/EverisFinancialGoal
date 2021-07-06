package com.br.everis.financialgoal.data.datasource.worker.monthly

import com.br.everis.financialgoal.data.datasource.model.monthly.MonthlyModelRequest

interface MonthlyDataSource {
    fun monthlyDataSource (monthlyResultCallback: (monthly : MonthlyResult) -> Unit,
                           monthly : MonthlyModelRequest)
}