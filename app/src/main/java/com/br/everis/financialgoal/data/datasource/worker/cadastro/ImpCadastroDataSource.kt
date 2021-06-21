package com.br.everis.financialgoal.data.datasource.worker.cadastro

import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelResponse
import com.br.everis.financialgoal.data.datasource.service.ImpApiService
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ImpCadastroDataSource(
    private var apiService:ImpApiService
): CadastroDataSource {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun cadastroDataSource(
        Success: (success: CadastroModelResponse?) -> Unit,
        Error: (error: CadastroModelResponse?) -> Unit,
        cadastro: CadastroModelRequest
    ) {
        coroutineScope.launch {
            withContext(Dispatchers.IO){
                val request = apiService.cadastro().cadastroRequest(cadastro).clone().execute()
                if (request.code() == 201){
                    Success.invoke(
                        CadastroModelResponse(
                        message = "Cadastro Realizado com sucesso",
                        res = true
                    ))
                }else{
                    val gson = Gson()
                    val response = gson.fromJson(request.errorBody()?.charStream(), CadastroModelResponse::class.java)
                    print(response)
                    Error.invoke(response)
                }
            }
        }
    }

}