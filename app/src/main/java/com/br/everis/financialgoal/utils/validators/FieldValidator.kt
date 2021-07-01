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

    fun isValidPeriod(month: Int) : Boolean = month > 0

    fun isValidTax(tax: Float) : Boolean = tax > 0F

    fun isValidUniqueApplication(app: Double) : Boolean = app > 0.0

}