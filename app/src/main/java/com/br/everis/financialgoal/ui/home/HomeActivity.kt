package com.br.everis.financialgoal.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.calcs.CalcActivity
import com.br.everis.financialgoal.ui.login.LoginActivity
import com.br.everis.financialgoal.utils.preferences.AppPreferences
import com.br.everis.financialgoal.utils.sessionManagment.SessionManagement


class HomeActivity : AppCompatActivity() {

    companion object{
        const val KEY_NICK_NAME = "NickName"
    }

    lateinit var appPreferences: AppPreferences
    lateinit var tvNameHome:TextView
    lateinit var cardUltimaSimulacao:ConstraintLayout
    lateinit var cardCalculadora:ConstraintLayout
    lateinit var cardSimulador:ConstraintLayout
    lateinit var sessionManagement: SessionManagement

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        appPreferences = AppPreferences(this)

        initView()
        setView()
        eventClick()
    }

    private fun eventClick() {
        cardUltimaSimulacao.setOnClickListener {
            Toast.makeText(this,"Não implementado", Toast.LENGTH_SHORT).show()
        }
        cardCalculadora.setOnClickListener {
            startActivity(Intent(this,CalcActivity::class.java))
        }
        cardSimulador.setOnClickListener {
            Toast.makeText(this,"Não implementado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setView() {
        tvNameHome.text = appPreferences.getString(KEY_NICK_NAME)
    }

    private fun initView() {
        tvNameHome = findViewById(R.id.tv_name_home)
        cardUltimaSimulacao = findViewById(R.id.card_ultima_simulacao)
        cardCalculadora = findViewById(R.id.card_calculadora)
        cardSimulador = findViewById(R.id.card_simulador)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        sessionManagement = SessionManagement(this)
        sessionManagement.finishSession()
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }
}