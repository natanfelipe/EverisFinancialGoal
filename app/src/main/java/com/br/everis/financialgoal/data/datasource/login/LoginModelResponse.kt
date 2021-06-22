package com.br.everis.financialgoal.data.datasource.login

import com.google.gson.annotations.SerializedName

data class LoginModelResponse(
    @SerializedName("message")
    val message : String,
    @SerializedName("res")
    val res : Boolean
)