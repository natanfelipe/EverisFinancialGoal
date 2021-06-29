package com.br.everis.financialgoal.utils.cadastro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.ui.cadastro.fragment.EmailFragment
import com.br.everis.financialgoal.ui.cadastro.fragment.NomeFragment
import com.br.everis.financialgoal.ui.cadastro.fragment.SenhaFragment
import com.br.everis.financialgoal.ui.home.fragment.YearlyFragment

object ChangeFragment {

    fun navigationFragment(
        context:FragmentActivity,
        fragment:String,
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

            "yearly" -> {
                fragmentNav = YearlyFragment.newInstance(context)
            }
        }

        context.supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, fragmentNav)
            addToBackStack(null)
            commit()
        }

    }

}