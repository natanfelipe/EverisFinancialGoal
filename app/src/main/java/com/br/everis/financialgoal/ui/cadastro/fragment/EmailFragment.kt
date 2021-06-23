package com.br.everis.financialgoal.ui.cadastro.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.utils.DialogAlert
import com.br.everis.financialgoal.utils.FieldValidator

class EmailFragment : Fragment() {

    private lateinit var edtEmail: EditText
    private lateinit var btnContinuar:Button
    private lateinit var btnBackNavBar:AppCompatImageView
    private lateinit var dialogAlert: DialogAlert
    private lateinit var fieldValidator: FieldValidator
    private lateinit var title: String
    private lateinit var text: String
    private lateinit var positive_button: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_email, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = view.context.getString(R.string.email_alert_title)
        text = view.context.getString(R.string.email_alert_text)
        positive_button = view.context.getString(R.string.positive_button)

        dialogAlert = DialogAlert()
        fieldValidator = FieldValidator()
        setView(view)
        setClick()
    }

    private fun setClick() {

        btnContinuar.setOnClickListener {

            if(validator()){
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, NomeFragment.newInstance())
                    addToBackStack(null)
                    commit()
                }
            } else {
                dialogAlert.onAlertDialog(it, title, text, positive_button)
            }
        }

        btnBackNavBar.setOnClickListener {
            requireActivity().finish()
        }
    }

    private fun setView(view: View) {
        btnContinuar = view.findViewById(R.id.btn_cadastro_email)
        btnBackNavBar = view.findViewById(R.id.btn_back_cadastro)
        edtEmail = view.findViewById(R.id.edt_email)
    }

    private fun validator() : Boolean = fieldValidator.isValidEmail(edtEmail.text.toString())

    companion object {
        fun newInstance() = EmailFragment()
       }

}

