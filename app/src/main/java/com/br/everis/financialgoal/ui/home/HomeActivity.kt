package com.br.everis.financialgoal.ui.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.cadastro.CadastroModelRequest
import com.br.everis.financialgoal.ui.calcs.CalcActivity
import com.br.everis.financialgoal.ui.home.adapter.HomeListAdapter
import com.br.everis.financialgoal.ui.login.LoginActivity
import com.br.everis.financialgoal.utils.cadastro.CadastroEnum
import com.br.everis.financialgoal.utils.cadastro.ChangeFragment
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

    val listCards = arrayListOf<String>("calculadora","simulador")
    val listImages = arrayListOf<Int>(R.drawable.ic_correcao_valor, R.drawable.ic_simulator)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        appPreferences = AppPreferences(this)

        initView()
        setView()
        setAdapter(this)
        eventClick()
    }

    private fun eventClick() {
        cardUltimaSimulacao.setOnClickListener {
            val fragmentCalcs:String = sessionManagementHome.getFlagFragment()
            if (fragmentCalcs.isNotEmpty()){
                startActivity(Intent(this,CalcActivity::class.java).apply {
                    putExtra("fragment",fragmentCalcs)
                }
                )
            }
        }
    }

    private fun setView() {
        tvNameHome.text = appPreferences.getString(KEY_NICK_NAME)
    }

    private fun initView() {
        tvNameHome = findViewById(R.id.tv_name_home)
        cardUltimaSimulacao = findViewById(R.id.card_ultima_simulacao)

        sessionManagementHome = SessionManagmentHome(this)
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
                    HomeEnum.calculadora.toString() -> {
                       startActivity(Intent(context,CalcActivity::class.java).apply {
                           putExtra("fragment","calculadora")
                            }
                       )
                    }

                    HomeEnum.simulador.toString() -> {
                        Toast.makeText(context,"Simulador não disponível", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        })
    }
}