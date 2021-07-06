package com.br.everis.financialgoal.data.datasource.worker.monthly

import com.br.everis.financialgoal.data.datasource.model.monthly.MonthlyModelRequest
import com.br.everis.financialgoal.data.datasource.model.monthly.MonthlyModelResponse
import com.br.everis.financialgoal.data.datasource.service.ImpApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

sealed class MonthlyResult{
    class RequestMonthlySucess(val sucessmonthly: MonthlyModelResponse?) : MonthlyResult()
}

class ImpMonthlyDataSource (private var apiService: ImpApiService) : MonthlyDataSource {

    private val corrotineScope = CoroutineScope(Dispatchers.IO)

    override fun monthlyDataSource(
        monthlyResultCallback: (monthly: MonthlyResult) -> Unit,
        monthly: MonthlyModelRequest
    ) {
        corrotineScope.launch{
            val response = apiService.requestAPI().monthlyRequest(monthly).clone().execute()
            if(response.code() == 200){
                monthlyResultCallback(MonthlyResult.RequestMonthlySucess(
                    response.body()?.let{
                        MonthlyModelResponse(
                            it.invest_total,
                            it.ganho_total,
                            it.ganho_acumulado
                        )}))
            }
        }
    }

}