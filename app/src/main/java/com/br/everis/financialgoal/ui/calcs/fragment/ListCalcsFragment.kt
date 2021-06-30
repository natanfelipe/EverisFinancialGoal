package com.br.everis.financialgoal.ui.calcs.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.home.HomeActivity
import com.br.everis.financialgoal.utils.cadastro.ChangeFragment
import com.br.everis.financialgoal.utils.home.SessionManagmentHome

class ListCalcsFragment(
    private val contextActivity: FragmentActivity
) : Fragment() {

    lateinit var cardAplicacaoMensal:ConstraintLayout
    lateinit var cardAplicacaoUnica: ConstraintLayout
    lateinit var cardCorrecaoValor: ConstraintLayout
    lateinit var cardConversaoTaxas: ConstraintLayout
    lateinit var tvTitleNavBar: TextView
    lateinit var btnBackCadastro: AppCompatImageView

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
            ChangeFragment.navigationFragment(
                contextActivity,
                "yearly",
                R.id.fragment_calcs,
                null
            )
        }
        cardCorrecaoValor.setOnClickListener {
            sessionManagementHome.InitializeFlagFragment("correcaoValor")
            Toast.makeText(context,"Não implementado", Toast.LENGTH_SHORT).show()
        }
        cardConversaoTaxas.setOnClickListener {
            sessionManagementHome.InitializeFlagFragment("conversaoTaxas")
            Toast.makeText(context,"Não implementado", Toast.LENGTH_SHORT).show()
        }
        btnBackCadastro.setOnClickListener {
            startActivity(Intent(context, HomeActivity::class.java))
        }
        tvTitleNavBar.text = getString(R.string.title_navbar_listCalcs)
    }

    private fun initView(view: View, context: Context) {
        cardAplicacaoMensal = view.findViewById(R.id.card_aplicação_mensal)
        cardAplicacaoUnica = view.findViewById(R.id.card_aplicacao_unica)
        cardCorrecaoValor = view.findViewById(R.id.card_correcao_valor)
        cardConversaoTaxas = view.findViewById(R.id.card_conversao_taxas)
        sessionManagementHome = SessionManagmentHome(context)
        btnBackCadastro = view.findViewById(R.id.btn_back_cadastro)
        tvTitleNavBar = view.findViewById(R.id.tv_title_nav_bar)
    }

    companion object {
        fun newInstance(
            contextActivity: FragmentActivity
        ) = ListCalcsFragment(contextActivity)
    }
}