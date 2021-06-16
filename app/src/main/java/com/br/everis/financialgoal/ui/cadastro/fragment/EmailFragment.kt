package com.br.everis.financialgoal.ui.cadastro.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.br.everis.financialgoal.R

class EmailFragment : Fragment() {

    private lateinit var btnContinuar:Button

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
                replace(R.id.fragment,NomeFragment.newInstance())
                addToBackStack(null)
                commit()
            }
        }
    }

    private fun setView(view: View) {
        btnContinuar = view.findViewById(R.id.btn_cadastro_email)
    }

    companion object {
        fun newInstance() = EmailFragment()
    }

}