package com.br.everis.financialgoal.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.home.HomeActivity
import com.br.everis.financialgoal.ui.login.fragment.ForgottenPasswordAlertDialog
import com.br.everis.financialgoal.utils.sessionManagment.SessionManagement

class LoginActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var btnLogin : Button
    private lateinit var textForgot : TextView
    private lateinit var btnBackHome : AppCompatImageView
    private val dialog = ForgottenPasswordAlertDialog()
    lateinit var sessionManagement: SessionManagement

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        click()
        btnBackHome = findViewById(R.id.btn_back_home)
        btnBackHome.setOnClickListener {
            finish()
        }
    }

    fun click(){
        btnLogin = findViewById(R.id.buttonLogin)
        textForgot = findViewById(R.id.textForgot)

        btnLogin.setOnClickListener(this)
        textForgot.setOnClickListener(this)

        sessionManagement = SessionManagement(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.buttonLogin ->{
                sessionManagement.initializeSession()
                startActivity(Intent(this,HomeActivity::class.java))
            }
            R.id.textForgot -> {
                dialog.show(supportFragmentManager,"custom dialog")
            }
            else ->{
                Toast.makeText(this, "Não implementado", Toast.LENGTH_SHORT).show()
        }
        }
    }
}
