package com.br.everis.financialgoal.viewmodel.taxes

import java.text.DecimalFormat
import kotlin.math.pow

class TaxesViewModel {

    fun converterTaxes(juros_anual: Double): Double {
        return  ((((1+(juros_anual/100)).pow((1/12.toDouble())))-1) * 100).format().toDouble()
    }

     fun Double.format(): String {
        val df = DecimalFormat("#.00")
        return df.format(this)
    }
}
