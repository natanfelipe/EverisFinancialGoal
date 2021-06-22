package com.br.everis.financialgoal.utils

import android.app.AlertDialog
import android.graphics.Color
import android.view.View

class DialogAlert {

    private lateinit var alertDialogBuilder: AlertDialog.Builder
    private lateinit var alertDialog: AlertDialog
    private lateinit var dialogEventManager: DialogEventManager

    fun onAlertDialog(view: View, event: Int) {

        dialogEventManager = DialogEventManager()
        dialogEventManager.setTitleAndMessage(event)

        alertDialogBuilder = AlertDialog.Builder(view.context)
        alertDialog = alertDialogBuilder
            .setTitle(DialogEventManager.TITLE)
            .setMessage(DialogEventManager.MESSAGE)
            .setCancelable(false)
            .setPositiveButton(DialogEventManager.POSITIVE_BUTTON) { dialog, id ->
                dialog.dismiss()
            }
            .create()
        alertDialog.show()
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.rgb(123,31,162))
    }

}