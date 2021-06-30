package com.br.everis.financialgoal.data.datasource.model.login

import com.google.gson.annotations.SerializedName

data class LoginModelResponse(
    @SerializedName("message")
    val message : String,
    @SerializedName("res")
    val res : Boolean,
    @SerializedName("user")
    val user:UserModel
)