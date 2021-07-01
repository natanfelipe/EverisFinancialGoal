package com.br.everis.financialgoal.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.ui.cadastro.fragment.EmailFragment
import com.br.everis.financialgoal.ui.cadastro.fragment.NomeFragment
import com.br.everis.financialgoal.ui.cadastro.fragment.SenhaFragment
import com.br.everis.financialgoal.ui.home.fragment.YearlyFragment
import com.br.everis.financialgoal.ui.calcs.fragment.ListCalcsFragment
import com.br.everis.financialgoal.utils.cadastro.CadastroEnum
import com.br.everis.financialgoal.utils.calcs.CalcsEnum
import com.br.everis.financialgoal.utils.home.HomeEnum

object ChangeFragment {

    fun navigationFragment(
        context:FragmentActivity,
        fragment:String?,
        idFragment:Int,
        cadastroObject:CadastroModelRequest?){

        lateinit var fragmentNav: Fragment

        when(fragment){
            CadastroEnum.EMAIL.toString() -> {
                fragmentNav = EmailFragment.newInstance(context)
            }
            CadastroEnum.SENHA.toString() -> {
                fragmentNav = SenhaFragment.newInstance(cadastroObject,context)
            }

            CadastroEnum.NOME.toString() -> {
                fragmentNav = NomeFragment.newInstance(cadastroObject, context)
            }

            HomeEnum.CALCULADORA.toString() -> {
                fragmentNav = ListCalcsFragment.newInstance(context)
            }
            CadastroEnum.CALC_LIST.toString() -> {
                fragmentNav = ListCalcsFragment.newInstance(context)
            }

            CalcsEnum.APLICACAO_MENSAL.toString() -> {
                //TODO
            }

            CalcsEnum.APLICACAO_UNICA.toString() -> {
                fragmentNav = YearlyFragment.newInstance(context)
            }

            CalcsEnum.CONVERSAO_TAXAS.toString() -> {
                //TODO
            }

            CalcsEnum.CORRECAO_VALOR.toString() -> {
                //TODO
            }
        }

        context.supportFragmentManager.beginTransaction().apply {
            replace(idFragment, fragmentNav)
            addToBackStack(null)
            commit()
        }

    }

}