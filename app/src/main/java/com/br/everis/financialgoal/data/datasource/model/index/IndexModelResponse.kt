package com.br.everis.financialgoal.data.datasource.model.index

data class IndexModelResponse(
    val message: String,
    val res: Boolean,
    val data: List<IndexModelRequest>
)