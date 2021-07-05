package com.br.everis.financialgoal.data.datasource.model.index

data class IndexModelRequest (
    val initial: Double,
    val cdiPercent: Float,
    val profitabilityDefinition: String,
    val period: Int,
    val type: String
    )
