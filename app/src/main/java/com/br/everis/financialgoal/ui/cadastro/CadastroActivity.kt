package com.br.everis.financialgoal.ui.cadastro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.cadastro.fragment.EmailFragment
import com.br.everis.financialgoal.ui.loggedOut.LoggedOutActivity
import com.br.everis.financialgoal.ui.monthly.MonthlyFragment
import com.br.everis.financialgoal.utils.cadastro.ChangeFragment.navigationFragment

class CadastroActivity : AppCompatActivity() {

    lateinit var myContext: FragmentActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

       //inflateFragment()
        val newFragment = MonthlyFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }



    private fun inflateFragment() {
        navigationFragment(this,"email",R.id.fragment, null)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, LoggedOutActivity::class.java))
    }
}