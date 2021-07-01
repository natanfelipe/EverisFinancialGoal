package com.br.everis.financialgoal.viewmodel.taxes

class TaxesViewModel {

    fun calcularjuros( val juros_anual : Double) : Double{

        val juros_convertido = juros_anual / 100

        val juros_mensal = ((1 + juros_convertido)^(1/12)) - 1
        return juros_mensal
       
    }
}