package com.br.everis.financialgoal.ui.cadastro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.cadastro.fragment.EmailFragment
import com.br.everis.financialgoal.ui.loggedOut.LoggedOutActivity

class CadastroActivity : AppCompatActivity() {

    private lateinit var btnBack:AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        setView()
        setClick()
        inflateFragment()
    }

    private fun setClick() {
        btnBack.setOnClickListener {
            startActivity(Intent(this,LoggedOutActivity::class.java))
            finish()
        }
    }

    private fun setView() {
        btnBack = findViewById(R.id.btn_back_cadastro)
    }

    private fun inflateFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, EmailFragment.newInstance())
            addToBackStack(null)
            commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,LoggedOutActivity::class.java))
    }
}