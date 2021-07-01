package com.br.everis.financialgoal.viewmodel.monthly

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.monthly.MonthlyModelRequest
import com.br.everis.financialgoal.data.datasource.model.monthly.MonthlyModelResponse
import com.br.everis.financialgoal.data.datasource.worker.monthly.MonthlyResult
import com.br.everis.financialgoal.data.datasource.worker.monthly.MonthlyResult.RequestMonthlySucess
import com.br.everis.financialgoal.repository.monthly.ImpMonthlyRepository
import com.br.everis.financialgoal.repository.monthly.MonthlyRepository



class MonthlyViewModel(private val repository: MonthlyRepository):ViewModel() {

    private var monthlyModelResponse = MutableLiveData<MonthlyModelResponse>()
    val response: LiveData<MonthlyModelResponse>get() = monthlyModelResponse
    private var validatorMessage = MutableLiveData<Int>()
    val messageValidator = validatorMessage

    fun init(monthly: MonthlyModelRequest){
        repository.monthlyRepository(::getResponse,monthly)
    }
    fun getResponse(response: MonthlyResult){
        when(response){
            is RequestMonthlySucess ->{
                monthlyModelResponse.postValue(response.sucessmonthly)
            }
        }

    }
    fun isValid(periodo : Int):Boolean{
        if(periodo == 0){
            return false
            messageValidator.value = R.string.preiodo_invalido
        }else{
            return true
            messageValidator.value = R.string.is_valid
        }
    }
}