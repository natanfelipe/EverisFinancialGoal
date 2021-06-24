package com.br.everis.financialgoal.viewmodel.cadastro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelResponse
import com.br.everis.financialgoal.data.datasource.worker.cadastro.CadastroResult
import com.br.everis.financialgoal.repository.cadastro.ImpCadastroRepository

class CadastroViewModel(
    private val repository: ImpCadastroRepository
): ViewModel() {

    private var _response = MutableLiveData<CadastroModelResponse>()
    val response: LiveData<CadastroModelResponse>
        get() = _response

    fun initialize(cadastro: CadastroModelRequest){
        getResponseApi(cadastro)
    }

    private fun getResponseApi(cadastro: CadastroModelRequest) {
        repository.cadastroRepository(::getResponse,cadastro)
    }

    private fun getResponse(response: CadastroResult){

        when(response){

            is CadastroResult.RequestSuccess -> {
                _response.postValue(response.success)
            }

            is CadastroResult.RequestError -> {
                _response.postValue(response.error)
            }
        }
    }

}