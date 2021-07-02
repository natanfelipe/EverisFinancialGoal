package com.br.everis.financialgoal.viewmodel.taxes

import kotlin.math.pow

class TaxesViewModel {

    fun calcularjuros( val juros_anual : Double) : Double{

        val juros_convertido : Double = juros_anual / 100

        val juros_mensal = ((1.0 / juros_convertido).toDouble()).pow(5)) - 1
        return juros_mensal

    }
}