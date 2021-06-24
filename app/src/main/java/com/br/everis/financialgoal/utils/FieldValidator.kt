package com.br.everis.financialgoal.utils

import android.text.TextUtils
import android.util.Patterns

class FieldValidator {

    fun isValidEmail(email: String) : Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidNameOrNickame(nameOrNickname: String) : Boolean {
        return !TextUtils.isEmpty(nameOrNickname)
    }

    fun isValidPassword(password: String) : Boolean {
        return !TextUtils.isEmpty(password) && password.length > 7
    }
}