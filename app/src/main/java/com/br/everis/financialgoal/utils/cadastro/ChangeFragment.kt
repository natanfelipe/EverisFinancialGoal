package com.br.everis.financialgoal.utils.cadastro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.ui.cadastro.fragment.EmailFragment
import com.br.everis.financialgoal.ui.cadastro.fragment.NomeFragment
import com.br.everis.financialgoal.ui.cadastro.fragment.SenhaFragment

object ChangeFragment {

    fun navigationFragment(
        context:FragmentActivity,
        fragment:String,
        cadastroObject:CadastroModelRequest?){

        lateinit var fragmentNav: Fragment

        when(fragment){
            "email" -> {
                fragmentNav = EmailFragment.newInstance(context)
            }
            "senha" -> {
                fragmentNav = SenhaFragment.newInstance(cadastroObject,context)
            }

            "nome" -> {
                fragmentNav = NomeFragment.newInstance(cadastroObject, context)
            }
        }

        context.supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, fragmentNav)
            addToBackStack(null)
            commit()
        }

    }

}