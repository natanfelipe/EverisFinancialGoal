package com.br.everis.financialgoal.utils

import android.app.AlertDialog
import android.graphics.Color
import android.view.View

class DialogAlert {

    private lateinit var alertDialogBuilder: AlertDialog.Builder
    private lateinit var alertDialog: AlertDialog

    fun onAlertDialog(view: View, title: String, text: String) {

        alertDialogBuilder = AlertDialog.Builder(view.context)
        alertDialog = alertDialogBuilder
            .setTitle(title)
            .setMessage(text)
            .setCancelable(false)
            .setPositiveButton("OK") { dialog, id ->
                dialog.dismiss()
            }
            .create()
        alertDialog.show()
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.rgb(123,31,162))
    }

}