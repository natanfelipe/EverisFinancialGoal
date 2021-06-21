package com.br.everis.financialgoal.ui.login.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.br.everis.financialgoal.R

class EmailAlertDialog : DialogFragment() {

    companion object {
        val TITLE_TEXT = "SENHA INVÁLIDA"
        val TEXT = "forneça um email válido."
    }

    private lateinit var btnOk: TextView
    private lateinit var tvDinamicTitle:TextView
    private lateinit var tvDinamicText:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_forgotten_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tvDinamicTitle = view.findViewById(R.id.tv_dinamic_title)
        tvDinamicText = view.findViewById(R.id.tv_dinamic_text)

        tvDinamicTitle.text = TITLE_TEXT
        tvDinamicText.text = TEXT

        setClick()
    }

    private fun setClick() {
        btnOk.setOnClickListener {
            dialog?.cancel()
        }
    }

}