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

    private lateinit var btnCriarConta: Button
    private lateinit var btnBackNavBar: AppCompatImageView
    private lateinit var edtSenha: EditText

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
        setView(view)
        setClick(activity)
    }

    private fun setClick(context: Context) {
        btnCriarConta.setOnClickListener {
            val cadastroObject = CadastroModelRequest(cadastro?.username, edtSenha.text.toString(), cadastro?.nickname)
            cadastroViewModel.initialize(cadastroObject)
            cadastroViewModel.response.observe(viewLifecycleOwner){
                if (it.res){
                    setMessage(context,it.message)
                    requireActivity().finish()
                    startActivity(Intent(activity,LoggedOutActivity::class.java))
                }else{
                    setMessage(context,it.message)
                }
            }
       }

        btnBackNavBar.setOnClickListener {
            navigationFragment(contextActivity,"nome",cadastro)
        }
    }

    private fun setView(view: View) {
        btnCriarConta = view.findViewById(R.id.btn_cadastro_senha)
        btnBackNavBar = view.findViewById(R.id.btn_back_cadastro)
        edtSenha = view.findViewById(R.id.edt_senha)
    }

    companion object {
        fun newInstance(
                cadastroObject:CadastroModelRequest?,
                contextActivity: FragmentActivity
        ) = SenhaFragment(cadastroObject,contextActivity)
    }
}