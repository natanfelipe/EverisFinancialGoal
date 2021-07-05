package com.br.everis.financialgoal.ui.calcs.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.home.HomeActivity
import com.br.everis.financialgoal.utils.ChangeFragment
import com.br.everis.financialgoal.utils.cadastro.setToastMessage.setMessage
import com.br.everis.financialgoal.utils.calcs.CalcsEnum
import com.br.everis.financialgoal.utils.home.SessionManagmentHome

class ListCalcsFragment(
    private val contextActivity: FragmentActivity
) : Fragment() {

    private lateinit var cardAplicacaoMensal:ConstraintLayout
    private lateinit var cardAplicacaoUnica: ConstraintLayout
    private lateinit var cardCorrecaoValor: ConstraintLayout
    private lateinit var cardConversaoTaxas: ConstraintLayout
    private lateinit var tvTitleNavBar: TextView
    private lateinit var btnBackCadastro: AppCompatImageView

    private lateinit var sessionManagementHome: SessionManagmentHome

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
            sessionManagementHome.InitializeFlagFragment(CalcsEnum.APLICACAO_MENSAL.toString())
            ChangeFragment.navigationFragment(
                contextActivity,
                CalcsEnum.APLICACAO_MENSAL.toString(),
                R.id.fragment_calcs,
                null
            )
        }
        cardAplicacaoUnica.setOnClickListener {
            sessionManagementHome.InitializeFlagFragment(CalcsEnum.APLICACAO_UNICA.toString())
            ChangeFragment.navigationFragment(
                contextActivity,
                CalcsEnum.APLICACAO_UNICA.toString(),
                R.id.fragment_calcs,
                null
            )
        }
        cardCorrecaoValor.setOnClickListener {
//            sessionManagementHome.InitializeFlagFragment(CalcsEnum.CORRECAO_VALOR.toString())
            setMessage(context,context.getString(R.string.msg_nao_disponivel))
        }
        cardConversaoTaxas.setOnClickListener {  sessionManagementHome.InitializeFlagFragment(CalcsEnum.CONVERSAO_TAXAS.toString())
            sessionManagementHome.InitializeFlagFragment(CalcsEnum.CONVERSAO_TAXAS.toString())
            ChangeFragment.navigationFragment(
                contextActivity,
                CalcsEnum.CONVERSAO_TAXAS.toString(),
                R.id.fragment_calcs,
                null
            )
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