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
import com.br.everis.financialgoal.viewmodel.cadastro.CadastroViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class SenhaFragment(private val cadastro:CadastroModelRequest) : Fragment() {

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
            val cadastroObject = CadastroModelRequest(cadastro.username, edtSenha.text.toString(), cadastro.nickname)
            cadastroViewModel.init(cadastroObject)
            cadastroViewModel.response.observe(viewLifecycleOwner){
                if (it.res){
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    activity?.finish()
                    startActivity(Intent(activity,LoggedOutActivity::class.java))
                }else if(!it.res){
                    Toast.makeText(context ,it.message,Toast.LENGTH_SHORT).show()
                }
            }

       }

        btnBackNavBar.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment,NomeFragment.newInstance(cadastro))
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

    companion object {
        fun newInstance(cadastroObject:CadastroModelRequest) = SenhaFragment(cadastroObject)
    }
}