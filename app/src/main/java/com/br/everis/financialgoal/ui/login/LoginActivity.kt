package com.br.everis.financialgoal.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.login.fragment.ForgottenPasswordAlertDialog

class LoginActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var btnLogin : Button
    private lateinit var textForgot : TextView
    private lateinit var btnBackHome : AppCompatImageView
    private val dialog = ForgottenPasswordAlertDialog()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        click()
        btnBackHome = findViewById(R.id.btnBackHome)
        btnBackHome.setOnClickListener {
            finish()
        }
    }

    fun click(){
        btnLogin = findViewById(R.id.buttonLogin)
        textForgot = findViewById(R.id.textForgot)

        btnLogin.setOnClickListener(this)
        textForgot.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.buttonLogin ->{
                Toast.makeText(this, "Não implementado", Toast.LENGTH_SHORT).show()
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
