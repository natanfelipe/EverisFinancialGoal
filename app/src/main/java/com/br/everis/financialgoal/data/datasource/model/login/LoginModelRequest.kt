package com.br.everis.financialgoal.data.datasource.model.login

import com.google.gson.annotations.SerializedName

data class LoginModelRequest(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)