package com.br.everis.financialgoal.data.datasource.model.index

data class IndexModelRequest(
    val cdbIndex: Double,
    val initial: Double,
    val updatedInvestedAmount: Double,
    val incomeTaxOnProfitability: Double,
    val grossProfit: Double,
    val netAmountOfInvestment: Double
)