package com.br.everis.financialgoal.data.datasource.worker.yearly.yearlydatasource

import com.br.everis.financialgoal.data.datasource.model.yearly.YearlyModelRequest
import com.br.everis.financialgoal.data.datasource.model.yearly.YearlyModelResponse
import com.br.everis.financialgoal.data.datasource.service.ImpApiService
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

sealed class YearlyResult {
    class RequestSuccess(val success: YearlyModelResponse?) : YearlyResult()
    class RequestError(val error: YearlyModelResponse?) : YearlyResult()
}

class ImpYearlyDataSource(
    private var apiService: ImpApiService
): YearlyDataSource {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun yearlyDataSource(
        yearlyResultCallback: (result: YearlyResult) -> Unit,
        yearly: YearlyModelRequest
    ) {
        coroutineScope.launch {
            val request = apiService.requestAPI().yearlyRequest(yearly).clone().execute()
            if (request.code() == 200){
                yearlyResultCallback(YearlyResult.RequestSuccess(
                    request.body()?.let {
                        YearlyModelResponse(
                            it.totalEarning,
                            it.totalInvestment,
                            it.accruedEarnings
                        )
                    }
                ))
            }else {
                val gson = Gson()
                val response = gson.fromJson(request.errorBody()?.charStream(), YearlyModelResponse::class.java)
                yearlyResultCallback(YearlyResult.RequestError(
                    YearlyModelResponse(
                        response.totalEarning,
                        response.totalInvestment,
                        response.accruedEarnings
                    )
                ))
            }
        }
    }
}