package com.br.everis.financialgoal.data.datasource.model.monthly

import com.google.gson.annotations.SerializedName

data class MonthlyModelRequest(
    @SerializedName("initial")
    val val_inicial : Double,
    @SerializedName("month")
    val aport_mensal : Double,
    @SerializedName("profitability")
    val taxa_juros : Float,
    @SerializedName("period")
    val periodo_meses : Int ,
    @SerializedName("interestIsMonthly")
    val juros_mensais : Boolean
)
