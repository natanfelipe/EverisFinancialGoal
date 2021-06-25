package com.br.everis.financialgoal.data.datarecoverysource.recovery

import com.br.everis.financialgoal.data.datarecoverysource.model.RecoveryModelRequest
import com.br.everis.financialgoal.data.datarecoverysource.model.RecoveryModelResponse
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelResponse
import com.br.everis.financialgoal.data.datasource.service.ImpApiService
import com.br.everis.financialgoal.data.datasource.worker.cadastro.CadastroDataSource
import com.br.everis.financialgoal.data.datasource.worker.cadastro.CadastroResult
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

sealed class RecoveryResult {
    class RequestSuccess(val success: RecoveryModelResponse?) : RecoveryResult()
    class RequestError(val error: RecoveryModelResponse?) : RecoveryResult()
}

class ImpRecoveryDataSource(
    private var apiService: ImpApiService
): RecoveryDataSource {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun recoveryDataSource(
        recoveryResultCallback: (result: RecoveryResult) -> Unit,
        recovery: RecoveryModelRequest

    ) {
        coroutineScope.launch {
            val request = apiService.requestAPI().recoveryRequest(recovery).clone().execute()
            if (request.code() == 201){
                recoveryResultCallback(
                    RecoveryResult.RequestSuccess(
                    request.body()
                ))
            }else {
                val gson = Gson()
                val response = gson.fromJson(request.errorBody()?.charStream(), RecoveryModelResponse::class.java)
                recoveryResultCallback(RecoveryResult.RequestError(response))
            }
        }
    }

}