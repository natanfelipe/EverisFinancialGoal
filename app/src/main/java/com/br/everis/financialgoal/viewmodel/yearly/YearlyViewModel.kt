package com.br.everis.financialgoal.viewmodel.yearly

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.everis.financialgoal.data.datasource.model.yearly.YearlyModelRequest
import com.br.everis.financialgoal.data.datasource.model.yearly.YearlyModelResponse
import com.br.everis.financialgoal.data.datasource.worker.yearly.YearlyResult
import com.br.everis.financialgoal.repository.yearly.YearlyRepository

class YearlyViewModel(
    private val repository: YearlyRepository
): ViewModel() {

    private var _response = MutableLiveData<YearlyModelResponse>()
    val response: LiveData<YearlyModelResponse>
        get() = _response

    fun initialize(yearly: YearlyModelRequest) {
        getResponseApi(yearly)
    }

    private fun getResponseApi(yearly: YearlyModelRequest) {
        repository.yearlyRepository(::getResponse, yearly)
    }

    private fun getResponse(response: YearlyResult) {
        when (response) {
            is YearlyResult.RequestSuccess -> {
                _response.postValue(response.success)
            }

            is YearlyResult.RequestError -> {
                _response.postValue(response.error)
            }
        }
    }
}