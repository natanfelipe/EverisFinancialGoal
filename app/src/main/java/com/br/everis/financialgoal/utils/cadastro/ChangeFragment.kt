package com.br.everis.financialgoal.utils.cadastro

import android.app.ActivityManager
import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.ui.cadastro.fragment.EmailFragment
import com.br.everis.financialgoal.ui.cadastro.fragment.NomeFragment
import com.br.everis.financialgoal.ui.cadastro.fragment.SenhaFragment

object ChangeFragment {

    fun navigationFragment(context:FragmentActivity,fragment:String, cadastroObject:CadastroModelRequest?){
        when(fragment){
            "email" -> {
                context.supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, EmailFragment.newInstance(context))
                    addToBackStack(null)
                    commit()
                }
            }
            "senha" -> {
                context.supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, SenhaFragment.newInstance(cadastroObject!!,context))
                    addToBackStack(null)
                    commit()
                }
            }

            "nome" -> {
                context.supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, NomeFragment.newInstance(cadastroObject!!, context))
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }
}