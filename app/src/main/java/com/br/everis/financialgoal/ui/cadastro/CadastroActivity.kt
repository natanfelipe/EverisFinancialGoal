package com.br.everis.financialgoal.ui.cadastro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.br.everis.financialgoal.R

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,EmailFragment.newInstance())
            addToBackStack(null)
            commit()
        }
    }
}