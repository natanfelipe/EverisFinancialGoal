package com.br.everis.financialgoal.data.datasource.worker.index.indexdatasource

import com.br.everis.financialgoal.data.datasource.service.ImpApiService
import com.br.everis.financialgoal.data.datasource.model.index.IndexModelRequest
import com.br.everis.financialgoal.data.datasource.model.index.IndexModelResponse
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

sealed class IndexResult {
    class RequestSuccess(val success: IndexModelResponse?) : IndexResult()
    class RequestError(val error: IndexModelResponse?) : IndexResult()
}

class ImpIndexDataSource(
    private var apiService: ImpApiService
): IndexDataSource {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun indexDataSource(
        indexResultCallback: (result: IndexResult) -> Unit,
        index: IndexModelRequest
    ) {
        coroutineScope.launch {
            val request = apiService.requestAPI().indexRequest(index).clone().execute()
            if (request.code() == 200){
                indexResultCallback(IndexResult.RequestSuccess(
                    request.body()?.let {
                        IndexModelResponse(
                            it.message,
                            it.res,
                            it.data
                        )
                    }
                ))
            }else {
                val gson = Gson()
                val response = gson.fromJson(request.errorBody()?.charStream(), IndexModelResponse::class.java)
                indexResultCallback(IndexResult.RequestError(
                    IndexModelResponse(
                        response.message,
                        response.res,
                        response.data
                    )
                ))
            }
        }
    }
}