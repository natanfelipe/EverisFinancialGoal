package com.br.everis.financialgoal.data.datasource.worker.cadastro

import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelResponse
import com.br.everis.financialgoal.data.datasource.service.ImpApiService
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

sealed class CadastroResult {
    class RequestSuccess(val success: CadastroModelResponse?) : CadastroResult()
    class RequestError(val error: CadastroModelResponse?) : CadastroResult()
}

class ImpCadastroDataSource(
    private var apiService:ImpApiService
): CadastroDataSource {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun cadastroDataSource(
        cadastroResultCallback: (result: CadastroResult) -> Unit,
        cadastro: CadastroModelRequest
    ) {
        coroutineScope.launch {
            val request = apiService.requestAPI().cadastroRequest(cadastro).clone().execute()
            if (request.code() == 201){
                cadastroResultCallback(CadastroResult.RequestSuccess(
                        request.body()
                ))
            }else {
                val gson = Gson()
                val response = gson.fromJson(request.errorBody()?.charStream(), CadastroModelResponse::class.java)
                    cadastroResultCallback(CadastroResult.RequestError(response))
            }
        }
    }

}