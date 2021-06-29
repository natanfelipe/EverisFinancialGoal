package com.br.everis.financialgoal.viewmodel.recovery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.everis.financialgoal.data.datarecoverysource.model.RecoveryModelRequest
import com.br.everis.financialgoal.data.datarecoverysource.model.RecoveryModelResponse
import com.br.everis.financialgoal.data.datarecoverysource.recovery.RecoveryResult
import com.br.everis.financialgoal.repository.recovery.ImpRecoveryRepository
import com.br.everis.financialgoal.repository.recovery.RecoveryRepository

class RecoveryViewModel (
    private val repository: ImpRecoveryRepository
): ViewModel() {

    private var _response = MutableLiveData<RecoveryModelResponse>()
    val response: LiveData<RecoveryModelResponse>
        get() = _response

    fun initialize(recovery: RecoveryModelRequest){
        getResponseApi(recovery)
    }

    private fun getResponseApi(recovery: RecoveryModelRequest) {
        repository.recoveryRepository(::getResponse,recovery)
    }

    private fun getResponse(response: RecoveryResult){
        when(response){
            is RecoveryResult.RequestSuccess -> {
                _response.postValue(response.success)
            }

            is RecoveryResult.RequestError -> {
                _response.postValue(response.error)
            }
        }
    }

}