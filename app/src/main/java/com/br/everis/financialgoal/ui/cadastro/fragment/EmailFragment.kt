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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_email, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialogAlert = DialogAlert()
        fieldValidator = FieldValidator()
        setView(view)
        setClick()
    }

    private fun setClick() {

        btnContinuar.setOnClickListener {

            if(fieldValidator.isValidEmail(edtEmail.text.toString())){
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, NomeFragment.newInstance())
                    addToBackStack(null)
                    commit()
                }
            } else {
                dialogAlert.onAlertDialog(it, event)
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

    companion object {
        fun newInstance() = EmailFragment()
        const val event = 1
    }

}

