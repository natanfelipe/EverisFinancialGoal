package com.br.everis.financialgoal.utils.validators

import android.text.TextUtils
import android.util.Patterns
import android.view.View
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.yearly.DIALOG_POSITIVE_BUTTON
import com.br.everis.financialgoal.ui.yearly.DIALOG_TEXT
import com.br.everis.financialgoal.ui.yearly.DIALOG_TITLE

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


    fun isValidYearly(period: String, tax: String, applicationValue: String, view: View) : Boolean {

        if (period.isNotEmpty() && period.toDouble() > 2147483647){
            DIALOG_TITLE = view.context.getString(R.string.txt_campo_invalido_periodo_mensal)
            DIALOG_TEXT = view.context.getString(R.string.txt_periodo_extenso)
            DIALOG_POSITIVE_BUTTON = view.context.getString(R.string.positive_button)
            return false
        } else if (period.isEmpty() || period.toInt() == 0) {
            DIALOG_TITLE = view.context.getString(R.string.txt_campo_invalido_periodo_mensal)
            DIALOG_TEXT = view.context.getString(R.string.txt_periodo_text)
            DIALOG_POSITIVE_BUTTON = view.context.getString(R.string.positive_button)
            return false
        } else if (tax.isEmpty() || tax.toFloat() < 0.0000000001F) {
            DIALOG_TITLE = view.context.getString(R.string.txt_campo_invalido_taxa)
            DIALOG_TEXT = view.context.getString(R.string.txt_taxa_text)
            DIALOG_POSITIVE_BUTTON = view.context.getString(R.string.positive_button)
            return false
        } else if (applicationValue.isEmpty() || applicationValue.toDouble() == 0.0) {
            DIALOG_TITLE = view.context.getString(R.string.txt_campo_invalido_valor_aplicacao)
            DIALOG_TEXT = view.context.getString(R.string.txt_valor_text)
            DIALOG_POSITIVE_BUTTON = view.context.getString(R.string.positive_button)
            return false
        }
        return true
    }
}