package com.br.everis.financialgoal.data.datasource.model.index

data class IndexModelResponse(
    val message: String,
    val res: Boolean = true,
    val data: List<IndexModelResponseData>

)
data class IndexModelResponseData(
    val cdbIndex: Double,
    val initial: Double,
    val updatedInvestedAmount: Double,
    val incomeTaxOnProfitability: Double,
    val grossProfit: Double,
    val netAmountOfInvestment: Double
)