package com.br.everis.financialgoal.ui.cadastro.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatImageView
import com.br.everis.financialgoal.R

class NomeFragment : Fragment() {

    private lateinit var btnContinuarNome:Button
    private lateinit var btnBackNavBar: AppCompatImageView

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
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment,SenhaFragment.newInstance())
                addToBackStack(null)
                commit()
            }
        }
        btnBackNavBar.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment,EmailFragment.newInstance())
                addToBackStack(null)
                commit()
            }
        }
    }

    private fun setView(view: View) {
        btnContinuarNome = view.findViewById(R.id.btn_cadastro_nome)
        btnBackNavBar = view.findViewById(R.id.btn_back_cadastro)
    }

    companion object {
        fun newInstance() = NomeFragment()
    }
}