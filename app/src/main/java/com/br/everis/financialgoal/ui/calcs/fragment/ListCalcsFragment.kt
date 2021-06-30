package com.br.everis.financialgoal.ui.calcs.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.utils.home.SessionManagmentHome

class ListCalcsFragment : Fragment() {

    lateinit var cardAplicacaoMensal:ConstraintLayout
    lateinit var cardAplicacaoUnica: ConstraintLayout
    lateinit var cardCorrecaoValor: ConstraintLayout
    lateinit var cardConversaoTaxas: ConstraintLayout

    lateinit var sessionManagementHome: SessionManagmentHome

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_calcs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity as Context
        initView(view,activity)
        setView(activity)
    }

    private fun setView(context: Context) {
        cardAplicacaoMensal.setOnClickListener {
            sessionManagementHome.InitializeFlagFragment("aplicacaoMensal")
            Toast.makeText(context,"Não implementado", Toast.LENGTH_SHORT).show()
        }
        cardAplicacaoUnica.setOnClickListener {
            sessionManagementHome.InitializeFlagFragment("aplicacaoUnica")
            Toast.makeText(context,"Não implementado", Toast.LENGTH_SHORT).show()
        }
        cardCorrecaoValor.setOnClickListener {
            sessionManagementHome.InitializeFlagFragment("correcaoValor")
            Toast.makeText(context,"Não implementado", Toast.LENGTH_SHORT).show()
        }
        cardConversaoTaxas.setOnClickListener {
            sessionManagementHome.InitializeFlagFragment("conversaoTaxas")
            Toast.makeText(context,"Não implementado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initView(view: View, context: Context) {
        cardAplicacaoMensal = view.findViewById(R.id.card_aplicação_mensal)
        cardAplicacaoUnica = view.findViewById(R.id.card_aplicacao_unica)
        cardCorrecaoValor = view.findViewById(R.id.card_correcao_valor)
        cardConversaoTaxas = view.findViewById(R.id.card_conversao_taxas)
        sessionManagementHome = SessionManagmentHome(context)
    }

    companion object {
        fun newInstance() = ListCalcsFragment()
    }
}