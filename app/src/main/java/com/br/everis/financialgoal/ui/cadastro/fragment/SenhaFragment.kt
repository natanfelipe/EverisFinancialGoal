package com.br.everis.financialgoal.ui.cadastro.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatImageView
import com.br.everis.financialgoal.utils.DialogAlert
import com.br.everis.financialgoal.utils.FieldValidator
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.ui.loggedOut.LoggedOutActivity
import com.br.everis.financialgoal.utils.cadastro.ChangeFragment.navigationFragment
import com.br.everis.financialgoal.utils.cadastro.setToastMessage.setMessage
import com.br.everis.financialgoal.viewmodel.cadastro.CadastroViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class SenhaFragment(
        private val cadastro:CadastroModelRequest?,
        private val contextActivity: FragmentActivity
        ) : Fragment() {

    private lateinit var edtSenha: EditText
    private lateinit var btnCriarConta: Button
    private lateinit var btnBackNavBar: AppCompatImageView
    private lateinit var dialogAlert: DialogAlert
    private lateinit var fieldValidator: FieldValidator
    private lateinit var title: String
    private lateinit var text: String
    private lateinit var positiveButton: String

    private val cadastroViewModel: CadastroViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_senha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity as Context

        title = view.context.getString(R.string.password_alert_title)
        text = view.context.getString(R.string.password_alert_text)
        positiveButton = view.context.getString(R.string.positive_button)

        fieldValidator = FieldValidator()
        dialogAlert = DialogAlert()
        setView(view)
        setClick(activity)
    }

    private fun setClick(context: Context) {

        btnCriarConta.setOnClickListener {

          val cadastroObject = CadastroModelRequest(cadastro?.username, edtSenha.text.toString(), cadastro?.nickname)
            cadastroViewModel.initialize(cadastroObject)
            cadastroViewModel.response.observe(viewLifecycleOwner){

            if (validator()) {
                setMessage(context,it.message)
                    requireActivity().finish()
                    startActivity(Intent(activity,LoggedOutActivity::class.java))

            } else {
                view?.let { it1 -> dialogAlert.onAlertDialog(it1, title, text, positiveButton) }
            }
        }

            btnBackNavBar.setOnClickListener {
               navigationFragment(contextActivity,"nome",cadastro)
                }
            }
        }

    private fun setView(view: View) {
        btnCriarConta = view.findViewById(R.id.btn_cadastro_senha)
        btnBackNavBar = view.findViewById(R.id.btn_back_cadastro)
        edtSenha = view.findViewById(R.id.edt_senha)
    }

    private fun validator() : Boolean = fieldValidator.isValidPassword(edtSenha.text.toString())

    companion object {
        fun newInstance(
                cadastroObject:CadastroModelRequest?,
                contextActivity: FragmentActivity
        ) = SenhaFragment(cadastroObject,contextActivity)
    }
}