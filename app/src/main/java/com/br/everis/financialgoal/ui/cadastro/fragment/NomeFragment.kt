package com.br.everis.financialgoal.ui.cadastro.fragment

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
import com.br.everis.financialgoal.utils.cadastro.ChangeFragment.navigationFragment
import java.util.*

class NomeFragment(
        private val cadastroObjectNome:CadastroModelRequest?,
        private val contextActivity: FragmentActivity
        ) : Fragment() {

    private lateinit var btnContinuarNome:Button
    private lateinit var btnBackNavBar: AppCompatImageView
    private lateinit var edtNome:EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView(view)
        setClick()
    }

    private fun setClick() {
        btnContinuarNome.setOnClickListener {
            val cadastroObject = CadastroModelRequest(username = cadastroObjectNome?.username,nickname = edtNome.text.toString())
            navigationFragment(contextActivity, "senha", cadastroObject)
        }
        btnBackNavBar.setOnClickListener {
            navigationFragment(contextActivity,"email",null)
        }
    }

    private fun setView(view: View) {
        btnContinuarNome = view.findViewById(R.id.btn_cadastro_nome)
        btnBackNavBar = view.findViewById(R.id.btn_back_cadastro)
        edtNome = view.findViewById(R.id.edt_nome)
    }

    companion object {
        fun newInstance(
                cadastroObject: CadastroModelRequest?,
                contextActivity: FragmentActivity
        ) = NomeFragment(cadastroObject,contextActivity)
    }
}