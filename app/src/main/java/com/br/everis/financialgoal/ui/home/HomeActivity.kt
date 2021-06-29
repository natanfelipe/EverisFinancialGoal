package com.br.everis.financialgoal.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.utils.preferences.AppPreferences

class HomeActivity : AppCompatActivity() {

    companion object{
        const val KEY_NICK_NAME = "NickName"
    }

    lateinit var appPreferences: AppPreferences
    lateinit var bundle: Bundle
    lateinit var tvNameHome:TextView
    lateinit var cardUltimaSimulacao:ConstraintLayout
    lateinit var cardCalculadora:ConstraintLayout
    lateinit var cardSimulador:ConstraintLayout

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
            Toast.makeText(this,"Não implementado", Toast.LENGTH_SHORT).show()
        }
        cardSimulador.setOnClickListener {
            Toast.makeText(this,"Não implementado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setView() {
        tvNameHome.text = appPreferences.getString(KEY_NICK_NAME)
    }


    private fun initView() {
        bundle = Bundle()
        tvNameHome = findViewById(R.id.tv_name_home)
        cardUltimaSimulacao = findViewById(R.id.card_ultima_simulacao)
        cardCalculadora = findViewById(R.id.card_calculadora)
        cardSimulador = findViewById(R.id.card_simulador)
    }
}