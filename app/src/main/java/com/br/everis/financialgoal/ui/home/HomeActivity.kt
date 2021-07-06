package com.br.everis.financialgoal.ui.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.calcs.CalcActivity
import com.br.everis.financialgoal.ui.home.adapter.HomeListAdapter
import com.br.everis.financialgoal.ui.login.LoginActivity
import com.br.everis.financialgoal.utils.cadastro.setToastMessage.setMessage
import com.br.everis.financialgoal.utils.home.ClickItemHome
import com.br.everis.financialgoal.utils.home.HomeEnum
import com.br.everis.financialgoal.utils.home.SessionManagmentHome
import com.br.everis.financialgoal.utils.preferences.AppPreferences
import com.br.everis.financialgoal.utils.sessionManagment.SessionManagement


class HomeActivity : AppCompatActivity() {

    companion object{
        const val KEY_NICK_NAME = "NickName"
    }

    lateinit var appPreferences: AppPreferences
    lateinit var tvNameHome:TextView
    lateinit var cardUltimaSimulacao:ConstraintLayout
    lateinit var sessionManagement: SessionManagement

    lateinit var sessionManagementHome: SessionManagmentHome

    private val listCards = arrayListOf(HomeEnum.CALCULADORA.toString(),HomeEnum.SIMULADOR.toString())
    private val listImages = arrayListOf(R.drawable.ic_correcao_valor, R.drawable.ic_simulator)

    lateinit var fragmentCalcs:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initView()
        setView()
        setAdapter(this)
        eventClick(fragmentCalcs)
    }

    private fun eventClick(fragment:String) {
        cardUltimaSimulacao.setOnClickListener {

            if (fragment.isNotEmpty()){
                startActivity(Intent(this,CalcActivity::class.java).apply {
                    putExtra("fragment",fragment)
                }
                )
            }
        }
    }

    private fun setView() {
        tvNameHome.text = appPreferences.getString(KEY_NICK_NAME)
        if(fragmentCalcs.isEmpty()){
            cardUltimaSimulacao.visibility = View.GONE
        }else{
            cardUltimaSimulacao.visibility = View.VISIBLE
        }
    }

    private fun initView() {
        tvNameHome = findViewById(R.id.tv_name_home)
        cardUltimaSimulacao = findViewById(R.id.card_ultima_simulacao)

        sessionManagementHome = SessionManagmentHome(this)

        fragmentCalcs = sessionManagementHome.getFlagFragment()

        appPreferences = AppPreferences(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        sessionManagement = SessionManagement(this)
        sessionManagement.finishSession()
        sessionManagementHome.FinishFlagFragment()
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }

    private fun setAdapter(context: Context) {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_card_home)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = HomeListAdapter(listCards,listImages,object:ClickItemHome{
            override fun ClickItemHome(fragment:String) {

                when(fragment){
                    HomeEnum.CALCULADORA.toString() -> {
                       startActivity(Intent(context,CalcActivity::class.java).apply {
                           putExtra("fragment",HomeEnum.CALCULADORA.toString())
                            }
                       )
                    }

                    HomeEnum.SIMULADOR.toString() -> {
                        setMessage(context,getString(R.string.msg_nao_disponivel))
                    }
                }

            }
        })
    }
}