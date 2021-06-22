package com.br.everis.financialgoal.ui.cadastro.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.DialogFragment
import com.br.everis.financialgoal.R

class EmailFragment : DialogFragment() {

    private lateinit var edtEmail: EditText
    private lateinit var btnContinuar:Button
    private lateinit var btnBackNavBar:AppCompatImageView
    private lateinit var alertDialog: AlertDialog.Builder

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_email, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView(view)
        setClick()
    }

    private fun setClick() {

        btnContinuar.setOnClickListener {
            if(!isBoolean()){
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, NomeFragment.newInstance())
                    addToBackStack(null)
                    commit()
                }
            } else {
                onAlertDialog(it)
            }
        }

        btnBackNavBar.setOnClickListener {
            activity?.finish()
        }
    }

    private fun setView(view: View) {
        btnContinuar = view.findViewById(R.id.btn_cadastro_email)
        btnBackNavBar = view.findViewById(R.id.btn_back_cadastro)
        edtEmail = view.findViewById(R.id.edt_email)
    }

    private fun onAlertDialog(view: View) {

        alertDialog = AlertDialog.Builder(view.context)
        alertDialog.setTitle(TITLE)
        alertDialog.setMessage(MESSAGE)
            .setCancelable(false)
            .setPositiveButton(POSITIVE_BUTTON) { dialog, id ->
                dialog.dismiss()
            }
        alertDialog.show()
    }

    private fun isBoolean() : Boolean {
        return TextUtils.isEmpty(edtEmail.text.toString())
    }

    companion object {
        fun newInstance() = EmailFragment()
        const val TITLE = "E-mail inválido"
        const val MESSAGE = "forneça um endereço de e-mail válido"
        const val POSITIVE_BUTTON = "OK"
    }

}

