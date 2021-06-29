package com.br.everis.financialgoal.utils.cadastro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.ui.cadastro.fragment.EmailFragment
import com.br.everis.financialgoal.ui.cadastro.fragment.NomeFragment
import com.br.everis.financialgoal.ui.cadastro.fragment.SenhaFragment
import com.br.everis.financialgoal.ui.calcs.fragment.ListCalcsFragment

object ChangeFragment {

    fun navigationFragment(
        context:FragmentActivity,
        fragment:String,
        idFragment:Int,
        cadastroObject:CadastroModelRequest?){

        lateinit var fragmentNav: Fragment

        when(fragment){
            CadastroEnum.email.toString() -> {
                fragmentNav = EmailFragment.newInstance(context)
            }
            CadastroEnum.senha.toString() -> {
                fragmentNav = SenhaFragment.newInstance(cadastroObject,context)
            }

            CadastroEnum.nome.toString() -> {
                fragmentNav = NomeFragment.newInstance(cadastroObject, context)
            }

            CadastroEnum.calc_list.toString() -> {
                fragmentNav = ListCalcsFragment.newInstance()
            }
        }

        context.supportFragmentManager.beginTransaction().apply {
            replace(idFragment, fragmentNav)
            addToBackStack(null)
            commit()
        }

    }

}