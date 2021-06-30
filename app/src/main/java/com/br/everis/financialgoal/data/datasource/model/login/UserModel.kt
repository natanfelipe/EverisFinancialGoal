package com.br.everis.financialgoal.data.datasource.model.login

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("username")
    val username:String? = null,
    @SerializedName("nickname")
    val nickname:String? = null
)