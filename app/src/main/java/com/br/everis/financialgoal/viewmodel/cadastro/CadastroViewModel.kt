package com.br.everis.financialgoal.viewmodel.cadastro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelResponse
import com.br.everis.financialgoal.repository.cadastro.ImpCadastroRepository

class CadastroViewModel(
    private val repository: ImpCadastroRepository
): ViewModel() {

    var _response = MutableLiveData<CadastroModelResponse>()
    val response: LiveData<CadastroModelResponse>
        get() = _response

    fun init(cadastro: CadastroModelRequest){
        getResponseApi(cadastro)
    }

    private fun getResponseApi(cadastro: CadastroModelRequest) {
        repository.cadastroRepository(::responseSuccess,::responseError, cadastro)
    }

    private fun responseSuccess(response: CadastroModelResponse?){
        _response.postValue(response)
    }

    private fun responseError(response: CadastroModelResponse?){
        _response.postValue(response)
    }

}