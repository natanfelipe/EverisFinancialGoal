package com.br.everis.financialgoal.utils.dialogup

import android.view.View
import androidx.core.content.ContextCompat
import com.br.everis.financialgoal.R

class DialogSetColor {

    fun setColor(view: View) =
        "#" + Integer.toHexString(
            ContextCompat.getColor(view.context, R.color.positive_button)
        )
}