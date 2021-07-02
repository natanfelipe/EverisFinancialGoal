package com.br.everis.financialgoal.viewmodel.taxes

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*
import kotlin.math.pow

class TaxesViewModel {

    fun converterTaxes(juros_anual: Double): Double {
        return  ((((1+(juros_anual/100)).pow((1/12.toDouble())))-1) * 100)
    }

    fun currencyFormat(valor: Double) : String{
        val format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(2);
        format.setCurrency(Currency.getInstance("BRL"));

        return format.format(valor);
    }
}
