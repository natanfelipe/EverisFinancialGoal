package com.br.everis.financialgoal.ui.cadastro.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatImageView
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.MainActivity

class SenhaFragment : Fragment() {

    private lateinit var btnCriarConta: Button
    private lateinit var btnBackNavBar: AppCompatImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_senha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView(view)
        setClick()
    }

    private fun setClick() {
        val activity = activity as Context
        btnCriarConta.setOnClickListener {
            startActivity(Intent(activity,MainActivity::class.java))
        }

        btnBackNavBar.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment,NomeFragment.newInstance())
                addToBackStack(null)
                commit()
            }
        }
    }

    private fun setView(view: View) {
        btnCriarConta = view.findViewById(R.id.btn_cadastro_senha)
        btnBackNavBar = view.findViewById(R.id.btn_back_cadastro)
    }

    companion object {
        fun newInstance() = SenhaFragment()
    }
}