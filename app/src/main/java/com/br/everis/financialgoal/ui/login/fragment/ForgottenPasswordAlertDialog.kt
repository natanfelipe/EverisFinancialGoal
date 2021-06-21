package com.br.everis.financialgoal.ui.login.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.br.everis.financialgoal.R

class ForgottenPasswordAlertDialog : DialogFragment() {

    private lateinit var btnOk:TextView
    private lateinit var btnCancelar:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            return inflater.inflate(R.layout.fragment_forgotten_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnOk = view.findViewById(R.id.tv_ok)
        btnCancelar = view.findViewById(R.id.tv_cancelar)

        setClick()
    }

    private fun setClick() {
        btnOk.setOnClickListener {
            dialog?.cancel()
        }
        btnCancelar.setOnClickListener {
            dialog?.cancel()
        }
    }

}