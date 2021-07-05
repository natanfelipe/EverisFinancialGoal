package com.br.everis.financialgoal.data.datasource.model.yearly

data class YearlyModelRequest (
    val initial: Double,
    val monthly: Double,
    val profitability: Float,
    val period: Int,
    val interestIsMonthly: Boolean = true
    )