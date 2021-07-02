package com.br.everis.financialgoal.repository.monthly

import com.br.everis.financialgoal.data.datasource.model.monthly.MonthlyModelRequest
import com.br.everis.financialgoal.data.datasource.worker.monthly.MonthlyResult

interface MonthlyRepository {
    fun monthlyRepository(
        monthlyResultCallback: (monthly : MonthlyResult) -> Unit,
        monthly : MonthlyModelRequest)
}