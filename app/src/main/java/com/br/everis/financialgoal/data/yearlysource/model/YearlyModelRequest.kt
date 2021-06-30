package com.br.everis.financialgoal.data.yearlysource.model

data class YearlyModelRequest (
    val initial: Double,
    val month: Double,
    val profitability: Float,
    val period: Int,
    val interestIsMonthly: Boolean = true
    )