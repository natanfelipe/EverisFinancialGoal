package com.br.everis.financialgoal.utils.validators

import android.text.TextUtils
import android.util.Patterns
import android.view.View

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