package com.br.everis.financialgoal.utils

import android.app.AlertDialog
import android.graphics.Color
import android.view.View
import androidx.core.content.ContextCompat
import com.br.everis.financialgoal.R

class DialogAlert {

    private lateinit var alertDialogBuilder: AlertDialog.Builder
    private lateinit var alertDialog: AlertDialog

    fun onAlertDialog(view: View, title: String, text: String, positiveButton: String) {

        alertDialogBuilder = AlertDialog.Builder(view.context)
        alertDialog = alertDialogBuilder
            .setTitle(title)
            .setMessage(text)
            .setCancelable(false)
            .setPositiveButton(positiveButton) { dialog, id ->
                dialog.dismiss()
            }
            .create()
        alertDialog.show()
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
            .setTextColor(Color.parseColor(
                "#"+Integer.toHexString(
                    ContextCompat.getColor(
                        view.context, R.color.positive_button))))
    }

}