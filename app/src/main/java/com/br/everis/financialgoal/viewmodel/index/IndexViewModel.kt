package com.br.everis.financialgoal.viewmodel.index

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.everis.financialgoal.data.datasource.model.index.IndexModelRequest
import com.br.everis.financialgoal.data.datasource.model.index.IndexModelResponse
import com.br.everis.financialgoal.data.datasource.worker.index.indexdatasource.IndexResult
import com.br.everis.financialgoal.repository.index.IndexRepository

class IndexViewModel(
private val repository: IndexRepository
): ViewModel() {

    private var _response = MutableLiveData<IndexModelResponse>()
    val response: LiveData<IndexModelResponse>
    get() = _response

    fun initialize(yearly: IndexModelRequest) {
        getResponseApi(yearly)
    }

    private fun getResponseApi(yearly: IndexModelRequest) {
        repository.indexRepository(::getResponse, yearly)
    }

    private fun getResponse(response: IndexResult) {
        when (response) {
            is IndexResult.RequestSuccess -> {
                _response.postValue(response.success)
            }

            is IndexResult.RequestError -> {
                _response.postValue(response.error)
            }
        }
    }
}