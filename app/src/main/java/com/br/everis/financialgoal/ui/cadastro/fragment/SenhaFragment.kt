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
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.ui.loggedOut.LoggedOutActivity
import com.br.everis.financialgoal.utils.DialogAlert
import com.br.everis.financialgoal.utils.FieldValidator
import com.br.everis.financialgoal.viewmodel.cadastro.CadastroViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SenhaFragment : Fragment() {

    private lateinit var edtSenha: EditText
    private lateinit var btnCriarConta: Button
    private lateinit var btnBackNavBar: AppCompatImageView
    private lateinit var dialogAlert: DialogAlert
    private lateinit var fieldValidator: FieldValidator
    private lateinit var TITLE: String
    private lateinit var TEXT: String
    private lateinit var POSITIVE_BUTTON: String

    private val mockCadastro: CadastroModelRequest = CadastroModelRequest(
        "android06@gmail.com",
        "12345678",
        "android06"
    )

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

        TITLE = view.context.getString(R.string.password_alert_title)
        TEXT = view.context.getString(R.string.password_alert_text)
        POSITIVE_BUTTON = view.context.getString(R.string.positive_button)

        fieldValidator = FieldValidator()
        dialogAlert = DialogAlert()
        setView(view)
        setClick(activity)
    }

    private fun setClick(context: Context) {

        btnCriarConta.setOnClickListener {

            if (validator()) {
                cadastroViewModel.init(mockCadastro)
                cadastroViewModel.response.observe(viewLifecycleOwner) {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                    startActivity(Intent(activity, LoggedOutActivity::class.java))
                }
            } else {
                dialogAlert.onAlertDialog(it, TITLE, TEXT, POSITIVE_BUTTON)
            }
        }

            btnBackNavBar.setOnClickListener {
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, NomeFragment.newInstance())
                    addToBackStack(null)
                    commit()
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
        fun newInstance() = SenhaFragment()
      }
}