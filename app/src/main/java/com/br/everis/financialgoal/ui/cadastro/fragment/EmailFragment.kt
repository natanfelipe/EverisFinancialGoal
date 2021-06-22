package com.br.everis.financialgoal.ui.cadastro.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatImageView
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest

class EmailFragment : Fragment() {

    private lateinit var btnContinuar:Button
    private lateinit var btnBackNavBar:AppCompatImageView
    private lateinit var edtEmail:EditText

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
            parentFragmentManager.beginTransaction().apply {
                val cadastroObjectEmail= CadastroModelRequest(edtEmail.text.toString(),"","")
                replace(R.id.fragment,NomeFragment.newInstance(cadastroObjectEmail))
                addToBackStack(null)
                commit()
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
    }

}