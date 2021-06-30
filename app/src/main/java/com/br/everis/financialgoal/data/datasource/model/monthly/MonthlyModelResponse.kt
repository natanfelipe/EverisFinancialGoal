package com.br.everis.financialgoal.data.datasource.model.monthly

import com.google.gson.annotations.SerializedName

data class MonthlyModelResponse(
    @SerializedName("totalInvestment")
    val invest_total : Double,
    @SerializedName("totalEarning")
    val ganho_total :Double,
    @SerializedName("accruedEarnings")
    val ganho_acumulado : Double
)
