package com.br.everis.financialgoal.ui.login.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datarecoverysource.model.RecoveryModelRequest
import com.br.everis.financialgoal.utils.dialogup.DialogAlert
import com.br.everis.financialgoal.utils.validators.FieldValidator
import com.br.everis.financialgoal.viewmodel.recovery.RecoveryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForgottenPasswordAlertDialog : DialogFragment() {

    private lateinit var dialogAlert: DialogAlert
    private lateinit var fieldValidator: FieldValidator
    private lateinit var btnOk:TextView
    private lateinit var btnCancelar:TextView
    private lateinit var email: EditText
    private lateinit var title: String
    private lateinit var text: String
    private lateinit var positiveButton: String
    private val recoveryViewModel: RecoveryViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            return inflater.inflate(R.layout.fragment_forgotten_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnOk = view.findViewById(R.id.tv_ok)
        btnCancelar = view.findViewById(R.id.tv_cancelar)
        email = view.findViewById(R.id.email)

        dialogAlert = DialogAlert()
        fieldValidator = FieldValidator()

        title = view.context.getString(R.string.email_alert_title)
        text = view.context.getString(R.string.email_alert_text)
        positiveButton = view.context.getString(R.string.positive_button)

        setClick()
    }

    private fun setClick() {
        btnOk.setOnClickListener {
            if (validator()) {
                val email = email.text.toString()
                setViewModel(email,it)
            } else {
                dialog?.cancel()
                dialogAlert.onAlertDialog(it, title, text, positiveButton)
            }
        }

        btnCancelar.setOnClickListener {
            dismiss()
        }
    }
    private fun setViewModel(email:String,view: View) {
        val recoveryModelRequest = RecoveryModelRequest(
            username = email
        )
        recoveryViewModel.initialize(recoveryModelRequest)
        recoveryViewModel.response.observe(viewLifecycleOwner){
            if (it.res){
                dialog?.cancel()
                dialogAlert.onAlertDialog(view, title, it.message, positiveButton)
            }else{
                dialog?.cancel()
                dialogAlert.onAlertDialog(view, title, it.message, positiveButton)
            }
        }
    }
    private fun validator(): Boolean = fieldValidator.isValidEmail(email.text.toString())

}