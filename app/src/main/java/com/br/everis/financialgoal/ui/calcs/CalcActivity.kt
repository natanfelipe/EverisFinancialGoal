package com.br.everis.financialgoal.ui.calcs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.home.HomeActivity
import com.br.everis.financialgoal.ui.loggedOut.LoggedOutActivity
import com.br.everis.financialgoal.utils.cadastro.ChangeFragment

class CalcActivity(private var fragment: String = "calculadora") : AppCompatActivity() {

    lateinit var tvTitleNavBar: TextView
    lateinit var btnBackCadastro: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        inflateFragment()
        initView()
        setView()
    }

    private fun initView() {
        btnBackCadastro = findViewById(R.id.btn_back_cadastro)
        tvTitleNavBar = findViewById(R.id.tv_title_nav_bar)
    }

    private fun setView() {
        btnBackCadastro.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }
        tvTitleNavBar.text = getString(R.string.title_navbar_listCalcs)
    }

    private fun inflateFragment() {
        ChangeFragment.navigationFragment(this, fragment,R.id.fragment_calcs, null)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, HomeActivity::class.java))
    }
}